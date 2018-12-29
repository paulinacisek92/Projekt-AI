package wat.edu.planzajec.model.encja;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "przedmiot")
@Data
@NoArgsConstructor
public class Przedmiot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nazwaPrzedmiotu;

    @ManyToOne(fetch = FetchType.EAGER)
    private Prowadzacy prowadzacy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Semestr semestr;
}
