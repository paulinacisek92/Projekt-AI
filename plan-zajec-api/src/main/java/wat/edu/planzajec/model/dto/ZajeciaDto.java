package wat.edu.planzajec.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ZajeciaDto implements Serializable {

    private long idZajec;

    private String nazwaGrupy;

    private String personaliaProwadzacego;

    private String nazwaPrzedmiotu;

    private String dzienZajec;

    private String godzinaRozpoczeciaZajec;

    private String godzinaZakonczeniaZajec;

    private long numerBloku;

    private String numerSali;

}
