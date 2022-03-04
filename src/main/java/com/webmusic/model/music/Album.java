package com.webmusic.model.music;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder @Entity @AllArgsConstructor @NoArgsConstructor @Table(name = "albums")
public class Album {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer albumId;
    private String albumName;
    private String description;
    @ManyToOne @JoinColumn(name = "songs_id")
    private Song song;
}
