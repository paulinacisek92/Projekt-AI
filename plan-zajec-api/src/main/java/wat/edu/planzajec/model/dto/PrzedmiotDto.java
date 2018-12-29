package wat.edu.planzajec.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PrzedmiotDto implements Serializable {

    private String nazwaPrzedmiotu;

    private String personaliaProwadzacego;

    private long numerSemestru;

}
