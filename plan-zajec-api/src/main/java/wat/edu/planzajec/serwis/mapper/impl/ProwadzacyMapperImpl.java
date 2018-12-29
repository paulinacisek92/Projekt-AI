package wat.edu.planzajec.serwis.mapper.impl;

import org.springframework.stereotype.Component;
import wat.edu.planzajec.model.dto.ProwadzacyDto;
import wat.edu.planzajec.model.encja.Prowadzacy;
import wat.edu.planzajec.serwis.mapper.ProwadzacyMapper;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProwadzacyMapperImpl implements ProwadzacyMapper {

    @Override
    public ProwadzacyDto mapToDto(Prowadzacy prowadzacy) {
        ProwadzacyDto prowadzacyDto = new ProwadzacyDto();
        prowadzacyDto.setIdProwadzacego(prowadzacy.getId());
        prowadzacyDto.setPersonaliaProwadzacego(prowadzacy.getDanePersonalne());
        return prowadzacyDto;
    }

    @Override
    public List<ProwadzacyDto> mapListToDto(List<Prowadzacy> prowadzacy) {
        return prowadzacy.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
