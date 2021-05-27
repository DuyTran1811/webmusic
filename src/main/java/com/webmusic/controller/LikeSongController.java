package com.webmusic.controller;

import com.webmusic.model.*;
import com.webmusic.service.like.song.ILikeSongService;
import com.webmusic.service.like.song.LikeSongService;
import com.webmusic.service.song.ISongService;
import com.webmusic.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("LikeSong")
public class LikeSongController {
    @Autowired
    private ILikeSongService iLikeSongService;
    @Autowired
    private ISongService iSongService;
    @Autowired
    private IUserService iUserService;

    @GetMapping("/{id_user}")
    public ResponseEntity<?> checkLike(@PathVariable("id_user") Long idUser) {
        List<LikeSong> likes = iLikeSongService.checkLike(idUser);
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @PostMapping("/{idUser}")
    public ResponseEntity<?> addLike(@RequestBody Long id_Song, @PathVariable("idUser") Long id) {
        Optional<Song> song = iSongService.findById(id_Song);
        Optional<User> user = iUserService.findById(id);
        if (song.isPresent() && user.isPresent()) {
            LikeSong like = new LikeSong();
            like.setSong(song.get());
            like.setUser(user.get());
            return new ResponseEntity<>(iLikeSongService.addLike(like), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id_song}")
    public ResponseEntity<Void> remove(@PathVariable Long id_song) {
        LikeSong likeSong = iLikeSongService.findBySongId(id_song);
        iLikeSongService.unLike(likeSong);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
