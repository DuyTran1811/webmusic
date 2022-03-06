package com.webmusic.service.music;

import com.webmusic.controller.exception.NullException;
import com.webmusic.controller.exception.ResponseNotFoundException;
import com.webmusic.model.music.Song;
import com.webmusic.repository.music.ISongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SongServiceImpl {
    private final ISongRepository songRepository;

    public SongServiceImpl(ISongRepository repository) {
        this.songRepository = repository;
    }

    public List<Song> searchBySinger(String singerName) {
        if (singerName == null || singerName.equals(" "))
            throw new ResponseNotFoundException(String.format("singerName %s not found", singerName));
        return songRepository.searchBySinger(singerName);
    }

    public Song addNewSong(Song song) {
        if (Objects.isNull(song)) {
            throw new NullException("song %s not Null");
        }
        return songRepository.save(song);
    }
}
