package app;

import entity.AlbumsEntity;
import entity.ArtistsEntity;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static void main(String[] args) {
        System.out.println("Start Application");

        ArtistRepository artistRepository = new ArtistRepository();

        ArtistsEntity artistsEntityToCreate = new ArtistsEntity();
        artistsEntityToCreate.setName("ArtistNou1");
        artistsEntityToCreate.setCountry("Romania");

        artistRepository.create(artistsEntityToCreate);
        System.out.println("Artistul cu id-ul 13 " + artistRepository.findById(13));
        System.out.println("Artistii cu numele Gigi " + artistRepository.findByName("Gigi"));

        AlbumRepository albumRepository = new AlbumRepository();

        AlbumsEntity albumsEntityToCreate = new AlbumsEntity();
        albumsEntityToCreate.setName("AlbumNou");
        albumsEntityToCreate.setArtistId(3);
        albumsEntityToCreate.setReleaseYear(2015);

        albumRepository.create(albumsEntityToCreate);

        System.out.println("Albumul cu id-ul 5 " + albumRepository.findById(5));
        System.out.println("Albumul cu numele AlbumNou " + albumRepository.findByName("AlbumNou"));
        System.out.println("Albumele cu artistul Gigi " + albumRepository.findByArtists("Gigi"));
        System.out.println("Stop Application");

    }
}
