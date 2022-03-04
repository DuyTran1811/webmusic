package com.webmusic.model.music;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @Builder @Entity @AllArgsConstructor @NoArgsConstructor
@Table(name = "tags")
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;
    private String name;
    @ManyToOne @JoinColumn(name = "songs_id")
    private Song song;
}
