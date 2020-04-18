package lab9.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "artists")
@Data
@NamedQueries({
        @NamedQuery(name = "Artists.findByName",
                query="SELECT a FROM Artists a where a.name =: name")
})
public class Artists implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country")
    private String country;

    
}