package wat.edu.planzajec.serwis.mapper;

import wat.edu.planzajec.model.dto.PrzedmiotDto;
import wat.edu.planzajec.model.encja.Przedmiot;

public interface PrzedmiotMapper {
    PrzedmiotDto mapToDto(Przedmiot przedmiot);
}
