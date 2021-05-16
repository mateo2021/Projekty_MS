package ovh.devnote.DAO;


import ovh.devnote.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistDao extends JpaRepository<Playlist, Integer> {

}