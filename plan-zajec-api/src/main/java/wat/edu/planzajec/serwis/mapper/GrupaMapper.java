package wat.edu.planzajec.serwis.mapper;

import wat.edu.planzajec.model.dto.GrupaDto;
import wat.edu.planzajec.model.encja.Grupa;

import java.util.List;

public interface GrupaMapper {
    GrupaDto mapToDto(Grupa grupa);
    List<GrupaDto> mapListToDto(List<Grupa> listaGrup);
}
