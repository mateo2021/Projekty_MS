package ovh.devnote.controller;

import com.google.common.collect.ImmutableList;
import ovh.devnote.model.Author;
import ovh.devnote.model.Content;
import ovh.devnote.model.Song;
import ovh.devnote.service.SongService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;


public class SongControllerTest {

    @Mock
    private SongService songService;

    @InjectMocks
    private SongController songController;

    private List<Song> songs = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Content content = new Content();
        Author author = new Author();

        songs.add(new Song("name", author, "duration", "date", "album", content));
        songs.add(new Song("name1", author, "duration1", "date1", "album1", content));
        songs.add(new Song("name2", author, "duration2", "date2", "album2", content));
    }


    @Test
    public void getAllSongsVerify() throws Exception {

        when(songService.listSong()).thenReturn(ImmutableList.of());

        List<Song> allSongs = songController.getAllSongs();

        verify(songService).listSong();

    }

    @Test
    public void getAllSongsTest() throws Exception {

        when(songService.listSong()).thenReturn(songs);

        List<Song> allSongs = songController.getAllSongs();

        Assert.assertEquals(3, allSongs.size());
    }

    @Test
    public void getSongByIdTest() throws Exception {

        int id = 1;

        when(songService.getSong(id)).thenReturn(songs.get(id));

        Song song = songController.getSong(id);

        Assert.assertEquals("name1", song.getName());

    }









}