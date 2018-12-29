package wat.edu.planzajec.model.encja;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "semestr")
public class Semestr implements Serializable {

    @Id
    private long numerSemestru;

}
