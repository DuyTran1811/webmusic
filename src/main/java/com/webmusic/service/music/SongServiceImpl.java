package com.webmusic.service.music;

import com.webmusic.model.music.Song;
import com.webmusic.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl {
    private final ISongRepository songRepository;

    @Autowired
    public SongServiceImpl(ISongRepository repository) {
        this.songRepository = repository;
    }

    public List<Song> searchBySinger(String singerName) {
        return songRepository.searchBySinger(singerName);
    }

}
