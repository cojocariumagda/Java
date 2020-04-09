package lab8;

import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        //create Connection
        System.out.println("Incerc conectarea la baza de date");
        SingletonDatabase dbHandle = SingletonDatabase.getInstance();
        System.out.println("Am reusit conectarea la baza de date");

        AlbumController albumController = new AlbumController();
        ArtistController artistController = new ArtistController();

        artistController.create("Magda", "Romania");
        artistController.create("Gigi", "Romania");
        albumController.create("GigiBalan", 1, 2020);
        albumController.create("MagdaBalan", 2, 2019);

        artistController.findByName("Magda");
        albumController.findByArtist(1);


        //close Connection
        try {
            dbHandle.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

