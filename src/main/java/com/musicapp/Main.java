package com.musicapp;

import com.musicapp.manager.ArtistManager;
import com.musicapp.model.Album;
import com.musicapp.model.Artist;
import com.musicapp.model.Discography;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Artist artist1 = new Artist(0, "Artist One", "Solo", 2000, null, "www.artistone.com");
        Artist artist2 = new Artist(0, "Band One", "Bend", 1995, 2005, "www.bandone.com");
        ArtistManager.addArtist(artist1);
        ArtistManager.addArtist(artist2);

        System.out.println("Svi izvođači:");
        for (Artist artist : ArtistManager.getAllArtists()) {
            System.out.println(artist.getName());
        }

        artist1.setOfficialWebsite("www.newartistone.com");
        ArtistManager.updateArtist(artist1);

        ArtistManager.deleteArtist(artist2.getId());

        System.out.println("\nSolo izvođači:");
        for (Artist artist : ArtistManager.getSoloArtists()) {
            System.out.println(artist.getName());
        }

        System.out.println("\nIzvođači formirani posle 1999:");
        for (Artist artist : ArtistManager.getArtistsFormedAfterYear(1999)) {
            System.out.println(artist.getName());
        }

        Album album1 = new Album(0, artist1.getId(), "Album One", 2001, "Sony Music");
        Album album2 = new Album(0, artist1.getId(), "Album Two", 2002, "Sony Music");
        ArtistManager.addAlbum(album1);
        ArtistManager.addAlbum(album2);

        System.out.println("\nDiskografija za izvođača sa ID 1:");
        Discography discography = ArtistManager.getDiscographyByArtistId(1);
        System.out.println("Izvođač: " + discography.getArtist().getName());
        for (Album album : discography.getAlbums()) {
            System.out.println("Album: " + album.getTitle() + ", Godina: " + album.getReleaseYear() + ", Izdavačka kuća: " + album.getRecordLabel());
        }

        System.out.println("\nDiskografija za izdavačku kuću 'Sony Music':");
        List<Discography> sonyDiscographies = ArtistManager.getDiscographiesByRecordLabel("Sony Music");
        for (Discography d : sonyDiscographies) {
            System.out.println("Izvođač: " + d.getArtist().getName());
            for (Album album : d.getAlbums()) {
                System.out.println("Album: " + album.getTitle() + ", Godina: " + album.getReleaseYear() + ", Izdavačka kuća: " + album.getRecordLabel());
            }
        }
    }
}
