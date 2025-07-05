package com.musicapp.test;

import com.musicapp.manager.ArtistManager;
import com.musicapp.model.Album;
import com.musicapp.model.Artist;
import com.musicapp.model.Discography;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArtistManagerTest {
    @BeforeEach
    void setUp() {
        ArtistManager.getAllArtists().clear();
        ArtistManager.addArtist(new Artist(0, "Artist One", "Solo", 2000, null, "www.artistone.com"));
        ArtistManager.addArtist(new Artist(0, "Band One", "Bend", 1995, 2005, "www.bandone.com"));
        ArtistManager.addAlbum(new Album(0, 1, "Album One", 2001, "Sony Music"));
        ArtistManager.addAlbum(new Album(0, 1, "Album Two", 2002, "Sony Music"));
    }

    @Test
    void testGetAllArtists() {
        List<Artist> artists = ArtistManager.getAllArtists();
        assertEquals(2, artists.size());
    }

    @Test
    void testAddArtist() {
        Artist artist = new Artist(0, "New Artist", "Solo", 2010, null, "www.newartist.com");
        ArtistManager.addArtist(artist);
        assertEquals(3, ArtistManager.getAllArtists().size());
    }

    @Test
    void testUpdateArtist() {
        Artist artist = ArtistManager.getAllArtists().get(0);
        artist.setOfficialWebsite("www.updatedwebsite.com");
        ArtistManager.updateArtist(artist);
        assertEquals("www.updatedwebsite.com", ArtistManager.getAllArtists().get(0).getOfficialWebsite());
    }

    @Test
    void testDeleteArtist() {
        ArtistManager.deleteArtist(1);
        assertEquals(1, ArtistManager.getAllArtists().size());
    }

    @Test
    void testGetSoloArtists() {
        List<Artist> soloArtists = ArtistManager.getSoloArtists();
        assertEquals(1, soloArtists.size());
    }

    @Test
    void testGetArtistsFormedAfterYear() {
        List<Artist> artists = ArtistManager.getArtistsFormedAfterYear(1999);
        assertEquals(1, artists.size());
    }

    @Test
    void testGetDiscographyByArtistId() {
        Discography discography = ArtistManager.getDiscographyByArtistId(1);
        assertNotNull(discography.getArtist());
        assertEquals(2, discography.getAlbums().size());
    }

    @Test
    void testGetDiscographiesByRecordLabel() {
        List<Discography> discographies = ArtistManager.getDiscographiesByRecordLabel("Sony Music");
        assertEquals(1, discographies.size());
    }
}
