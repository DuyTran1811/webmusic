package com.webmusic.controller.music;

import com.webmusic.model.music.Song;
import com.webmusic.service.music.SongServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/songs")
public class SongController {

    private final SongServiceImpl songService;
//    IPlaylistService playlistService;
//    ISingerService iSingerService;


    public SongController(SongServiceImpl songService) {
        this.songService = songService;
//        this.playlistService = playlistService;
//        this.iSingerService = iSingerService;
    }


    @GetMapping("searchSinger/{name}")
    public ResponseEntity<List<Song>> findBySinger(@PathVariable String name) {
        List<Song> listSinger = songService.searchBySinger(name);
        return ResponseEntity.ok(listSinger);
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<Song>> getAll(Pageable pageable) {
//        Page<Song> getAllSong = songService.getAll(pageable);
//        List<Song> songs = getAllSong.getContent();
//        return new ResponseEntity<>(songs, OK);
//    }

//    @GetMapping("/all/{id}")
//    public ResponseEntity<List<Song>> getAllById(Pageable pageable, @PathVariable("id") Long id) {
//        Pageable page = PageRequest.of(pageable.getPageNumber(), 1000);
//        Page<Song> getAllSong = songService.getSongByUser(id, page);
//        List<Song> songs = getAllSong.getContent();
//        return new ResponseEntity<>(songs, OK);
//    }

//    @PostMapping("/add")
//    public ResponseEntity<Song> addSong(@Valid @RequestBody Song song) {
//        Song newSong = songService.save(song);
//        return new ResponseEntity<>(newSong, CREATED);
//    }

//    @PutMapping("/edit")
//    public ResponseEntity<Song> editSong(@Valid @RequestBody Song song) {
//        Song editSong = songService.save(song);
//        return new ResponseEntity<>(editSong, OK);
//    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteSong(@PathVariable("id") Long id) {
//        if (id == null) {
//            return new ResponseEntity<>(NOT_FOUND);
//        }
//        songService.delete(id);
//        return new ResponseEntity<>(OK);
//    }

//    @GetMapping("/top15")
//    public ResponseEntity<List<Song>> getTop15() {
//        return new ResponseEntity<>(songService.getTop15(), OK);
//    }

//    @GetMapping("/latest")
//    public ResponseEntity<List<Song>> getLatest() {
//        return new ResponseEntity<>(songService.getLastestSongs(), OK);
//    }

//    @PostMapping("/search")
//    public ResponseEntity<List<?>> findByName(@RequestBody Song song, Pageable pageable) {
//        List<Object> list = new ArrayList<>();
//        Page<Song> songs = songService.findByNameContains(song.getName(), pageable);
//        List<Song> songList = songs.getContent();
//        List<Playlist> playlists = playlistService.findByNameContains(song.getName());
//        List<Singer> singers = iSingerService.findByNameContains(song.getName());
//        list.add(songList);
//        list.add(playlists);
//        list.add(singers);
//        return new ResponseEntity(list, HttpStatus.OK);
//    }

//    @GetMapping("/list/{id}")
//    public ResponseEntity<List<Object>> getAlbumById(@PathVariable Long id, Pageable page) {
//        Page<Object> getSongs = songService.getSongById(id, page);
//        List<Object> songs = getSongs.getContent();
//        return new ResponseEntity<>(songs, OK);
//    }

//    @GetMapping("top15Likes")
//    public ResponseEntity<?> getTop15Likes() {
//        return new ResponseEntity<>(songService.top15Like(), OK);
//    }

}
