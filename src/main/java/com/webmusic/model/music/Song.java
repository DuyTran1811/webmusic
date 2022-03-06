package com.webmusic.model.music;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Builder @Entity @AllArgsConstructor @NoArgsConstructor
@Table(name = "songs")
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    private String nameSong;
    private String nameSinger;
    private String linkSong;
    private String avatar;
    private String genre;
    private String theme;
    private Long listens;
    private Long likeSong;
    @OneToMany(mappedBy = "song")
    private List<Tag> tag;
    @OneToMany(mappedBy = "song")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "song")
    private Set<Album> albums;
}
