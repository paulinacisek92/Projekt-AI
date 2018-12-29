package wat.edu.planzajec.serwis.mapper.impl;

import org.springframework.stereotype.Component;
import wat.edu.planzajec.model.dto.GrupaDto;
import wat.edu.planzajec.model.encja.Grupa;
import wat.edu.planzajec.serwis.mapper.GrupaMapper;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class GrupaMapperImpl implements GrupaMapper {
    @Override
    public GrupaDto mapToDto(Grupa grupa) {
        GrupaDto grupaDto = new GrupaDto();
        grupaDto.setNumerGrupy(grupa.getNumerGrupy());
        return grupaDto;
    }

    @Override
    public List<GrupaDto> mapListToDto(List<Grupa> listaGrup) {
        return listaGrup.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
