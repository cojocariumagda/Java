package lab9.app;

import lab9.repo.AlbumsRepository;

public class AlbumManager {
    public static void main(String[] args) {
        System.out.println("Start main");
        AlbumsRepository albumsRepository = new AlbumsRepository();
        System.out.println(albumsRepository._findById(2));
    }
}
