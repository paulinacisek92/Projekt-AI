package wat.edu.planzajec.serwis.mapper;

import wat.edu.planzajec.model.dto.ProwadzacyDto;
import wat.edu.planzajec.model.encja.Prowadzacy;

import java.util.List;

public interface ProwadzacyMapper {
    ProwadzacyDto mapToDto(Prowadzacy prowadzacy);
    List<ProwadzacyDto> mapListToDto(List<Prowadzacy> prowadzacy);
}
