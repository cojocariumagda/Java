package lab8;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistController {

    //compulsory
    /*List<Artist> list = new ArrayList<Artist>();

    public void create (String name, String country)
    {
        Artist currentArtist = new Artist(name, country);
        list.add(currentArtist);
    }

    public Artist findByName (String name)
    {
        for (Artist artist : list)
        {
            if (artist.getName() == name)
                return artist;
        }
        return null;
    }*/

    public void create (String name, String country)
    {
        if (name == null || country == null)
        {
            System.out.println("Unul din parametrii sunt nuli");
            return;
        }

        SingletonDatabase dbHandle = SingletonDatabase.getInstance();
        String sql = "INSERT INTO artists (name, country) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = dbHandle.conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, country);
            preparedStatement.execute();
            System.out.println("Am inserat instanta " + name  + " " + country);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void findByName (String name)
    {
        if (name == null)
        {
            System.out.println("Paramatrul este nul");
            return;
        }
        String sql = "SELECT * FROM artists WHERE name = '" + name + "'";
        SingletonDatabase dbHandle = SingletonDatabase.getInstance();
        try {
            Statement statement =  dbHandle.conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("name") + ", " + resultSet.getString("country"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
