package wat.edu.planzajec.serwis.mapper.impl;


import org.springframework.stereotype.Component;
import wat.edu.planzajec.model.dto.ZajeciaDto;
import wat.edu.planzajec.model.encja.Zajecia;
import wat.edu.planzajec.serwis.mapper.ZajeciaMapper;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ZajeciaMapperImpl implements ZajeciaMapper {

    private final DateTimeFormatter formatterToDto = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public ZajeciaDto mapToDto(Zajecia zajecia) {
        ZajeciaDto zajeciaDto = new ZajeciaDto();
        zajeciaDto.setDzienZajec(zajecia.getDzienZajec().format(formatterToDto));
        zajeciaDto.setGodzinaRozpoczeciaZajec(zajecia.getBlokCzasowy().getGodzinaPoczatkuBloku());
        zajeciaDto.setGodzinaZakonczeniaZajec(zajecia.getBlokCzasowy().getGodzinaKoncaBloku());
        zajeciaDto.setIdZajec(zajecia.getId());
        zajeciaDto.setNazwaGrupy(zajecia.getGrupa().getNumerGrupy());
        zajeciaDto.setPersonaliaProwadzacego(zajecia.getProwadzacy().getDanePersonalne());
        zajeciaDto.setNazwaPrzedmiotu(zajecia.getPrzedmiot().getNazwaPrzedmiotu());
        zajeciaDto.setNumerBloku(zajecia.getBlokCzasowy().getId());
        zajeciaDto.setNumerSali(zajecia.getSala().getNumerSali());
        return zajeciaDto;
    }

    @Override
    public List<ZajeciaDto> mapListToDto(List<Zajecia> zajecia) {
        return zajecia.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
