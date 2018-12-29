package wat.edu.planzajec.model.encja;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "prowadzacy")
@NoArgsConstructor
public class Prowadzacy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String danePersonalne;
}
