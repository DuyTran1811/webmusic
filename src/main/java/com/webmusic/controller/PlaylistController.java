package com.webmusic.controller;

import com.webmusic.model.Playlist;
import com.webmusic.model.Song;
import com.webmusic.service.playlist.IPlaylistService;
import com.webmusic.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.util.Date;


@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;
    @Autowired
    private ISongService iSongService;

    @GetMapping
    public ResponseEntity<Page<Playlist>> listPlayList(Pageable pageable){
        return new ResponseEntity<>(playlistService.getAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlayList(@RequestBody Playlist playlist){
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlayList(@PathVariable Long id){
        playlistService.delete(id);
        return new ResponseEntity<>(playlistService.findById(id).get(),HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/{id_song}")
    public ResponseEntity<Song> addSongToPlayList(@PathVariable("id") Long id , @PathVariable("id_song") Long id_song){
        if (iSongService.findById(id_song).isPresent()){
            Song song = iSongService.findById(id_song).get();
            Playlist playlist = playlistService.findById(id).get();
            playlist.getSongs().add(song);
            playlistService.save(playlist);
            return new ResponseEntity<>(song,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping
    public ResponseEntity<Playlist> editPlayList(@RequestBody Playlist playlist){
        if (playlistService.findById(playlist.getId()).isPresent()){
            playlistService.save(playlist);
            return new ResponseEntity<>(playlist,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
