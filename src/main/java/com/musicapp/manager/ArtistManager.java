package com.musicapp.manager;

import com.musicapp.model.Album;
import com.musicapp.model.Artist;
import com.musicapp.model.Discography;

import java.util.ArrayList;
import java.util.List;

public class ArtistManager {
    private static List<Artist> artists = new ArrayList<>();
    private static List<Album> albums = new ArrayList<>();
    private static int artistIdCounter = 1;
    private static int albumIdCounter = 1;

    public static List<Artist> getAllArtists() {
        return new ArrayList<>(artists);
    }

    public static void addArtist(Artist artist) {
        artist.setId(artistIdCounter++);
        artists.add(artist);
    }

    public static void updateArtist(Artist artist) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getId() == artist.getId()) {
                artists.set(i, artist);
                return;
            }
        }
    }

    public static void deleteArtist(int id) {
        artists.removeIf(artist -> artist.getId() == id);
        albums.removeIf(album -> album.getArtistId() == id);
    }

    public static List<Artist> getSoloArtists() {
        List<Artist> soloArtists = new ArrayList<>();
        for (Artist artist : artists) {
            if (artist.getType().equalsIgnoreCase("solo")) {
                soloArtists.add(artist);
            }
        }
        return soloArtists;
    }

    public static List<Artist> getArtistsFormedAfterYear(int year) {
        List<Artist> filteredArtists = new ArrayList<>();
        for (Artist artist : artists) {
            if (artist.getFormationYear() > year) {
                filteredArtists.add(artist);
            }
        }
        return filteredArtists;
    }

    public static void addAlbum(Album album) {
        album.setId(albumIdCounter++);
        albums.add(album);
    }

    public static Discography getDiscographyByArtistId(int artistId) {
        Artist artist = null;
        List<Album> artistAlbums = new ArrayList<>();
        for (Artist a : artists) {
            if (a.getId() == artistId) {
                artist = a;
                break;
            }
        }

        for (Album album : albums) {
            if (album.getArtistId() == artistId) {
                artistAlbums.add(album);
            }
        }

        return new Discography(artist, artistAlbums);
    }

    public static List<Discography> getDiscographiesByRecordLabel(String recordLabel) {
        List<Discography> discographies = new ArrayList<>();
        for (Artist artist : artists) {
            List<Album> artistAlbums = new ArrayList<>();
            for (Album album : albums) {
                if (album.getArtistId() == artist.getId() && album.getRecordLabel().equalsIgnoreCase(recordLabel)) {
                    artistAlbums.add(album);
                }
            }
            if (!artistAlbums.isEmpty()) {
                discographies.add(new Discography(artist, artistAlbums));
            }
        }
        return discographies;
    }
}
