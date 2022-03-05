package com.webmusic.model.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data @Builder @Entity @AllArgsConstructor @NoArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String description;
    private String createBy;
    private Date createDate;
    @ManyToOne @JoinColumn(name = "songs_id")
    @JsonIgnore
    private Song song;
}
