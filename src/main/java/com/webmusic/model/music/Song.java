package com.webmusic.model.music;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "songs")
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;
    private String nameSong;
    private String nameSinger;
    private String avatar;
    private String genre;
    private String theme;
    @OneToMany(mappedBy = "song")
    private List<Tag> tag;
    @OneToMany(mappedBy = "song")
    private Set<Comment> comments;
    @OneToMany(mappedBy = "song")
    private Set<Album> albums;
}
