package lab8;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlbumController {

    //compulsory
    /*List<Album> albumList = new ArrayList<Album>();

    public void create (String name, int artistId, int releaseYear)
    {
        Album currentAlbum = new Album(name, artistId, releaseYear);
        albumList.add(currentAlbum);
    }

    public Album findByArtist(int artistId)
    {
        for (Album album : albumList)
        {
            if (album.getArtistId() == artistId)
                return album;
        }
        return null;
    }*/

    public void create (String name, int artistId, int releaseYear)
    {
        if (name == null || artistId == 0 || releaseYear == 0)
        {
            System.out.println("Unul din parametrii sunt nuli");
            return;
        }

        SingletonDatabase dbHandle = SingletonDatabase.getInstance();
        String sql = "INSERT INTO albums (name, artist_id, release_year) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = dbHandle.conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, artistId);
            preparedStatement.setInt(3, releaseYear);
            preparedStatement.execute();
            System.out.println("Am inserat instanta " + name  + " " + artistId  + " " + releaseYear);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void findByArtist(int artistId)
    {
        if (artistId == 0)
        {
            System.out.println("Paramatrul este nul");
            return;
        }
        String sql = "SELECT * FROM albums WHERE artist_id = " + artistId;
        SingletonDatabase dbHandle = SingletonDatabase.getInstance();
        try {
            Statement statement =  dbHandle.conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("name") + ", " + resultSet.getInt("release_year"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
