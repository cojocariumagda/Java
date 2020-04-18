package lab9.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Table(name = "albums")
@Data
@Entity
@NamedQueries({
        @NamedQuery(name = "Albums.findByName",
                    query="SELECT a FROM Albums a where a.name =: name"),
        @NamedQuery(name = "Albums.findByArtist",
                    query="SELECT a FROM Albums a where a.artistId =: id")
})
public class Albums implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "artist_id", nullable = false)
    private Integer artistId;

    @Column(name = "release_year")
    private Integer releaseYear;

    public Albums(String name, Integer artistId, Integer releaseYear) {
        this.name = name;
        this.artistId = artistId;
        this.releaseYear = releaseYear;
    }
}