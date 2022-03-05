package com.webmusic.repository.music;

import com.webmusic.model.music.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT s.* FROM Song s WHERE s.nameSinger=:?1", nativeQuery = true)
    List<Song> searchBySinger(@Param("nameSinger") String singerName);
}
