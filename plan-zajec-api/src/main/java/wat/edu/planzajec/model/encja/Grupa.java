package wat.edu.planzajec.model.encja;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "grupa")
@NoArgsConstructor
public class Grupa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String numerGrupy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Semestr aktualnySemestrGrupy;
}
