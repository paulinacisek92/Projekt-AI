package wat.edu.planzajec.model.encja;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "blok_czasowy")
public class BlokCzasowy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="godzina_poczatku")
    private String godzinaPoczatkuBloku;

    @Column(name ="godzina_konca")
    private String godzinaKoncaBloku;
}
