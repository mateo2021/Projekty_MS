package ovh.devnote.DAO;


import ovh.devnote.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongDao extends JpaRepository<Song, Integer> {

    @Query("SELECT s FROM Song s WHERE s.author.name LIKE CONCAT('%',:name,'%') OR s.name LIKE CONCAT('%',:name,'%')")
    List<Song> findSongsByName(@Param("name") String name);



}
