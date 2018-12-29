package wat.edu.planzajec.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProwadzacyDto implements Serializable {
    private long idProwadzacego;
    private String personaliaProwadzacego;
}
