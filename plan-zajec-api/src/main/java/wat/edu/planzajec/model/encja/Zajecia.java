package wat.edu.planzajec.model.encja;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "zajecia")
@Data
public class Zajecia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Grupa grupa;

    @ManyToOne(fetch = FetchType.EAGER)
    private Prowadzacy prowadzacy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    private BlokCzasowy blokCzasowy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Przedmiot przedmiot;

    private LocalDate dzienZajec;
}
