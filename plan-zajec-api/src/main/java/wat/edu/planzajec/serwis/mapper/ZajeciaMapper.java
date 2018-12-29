package wat.edu.planzajec.serwis.mapper;

import wat.edu.planzajec.model.dto.ZajeciaDto;
import wat.edu.planzajec.model.encja.Zajecia;

import java.util.List;

public interface ZajeciaMapper {
    ZajeciaDto mapToDto(Zajecia zajecia);
    List<ZajeciaDto> mapListToDto(List<Zajecia> zajecia);
}
