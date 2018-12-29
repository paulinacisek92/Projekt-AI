package wat.edu.planzajec.serwis.mapper.impl;

import org.springframework.stereotype.Component;
import wat.edu.planzajec.model.dto.PrzedmiotDto;
import wat.edu.planzajec.model.encja.Przedmiot;
import wat.edu.planzajec.serwis.mapper.PrzedmiotMapper;

@Component
public class PrzedmiotMapperImpl implements PrzedmiotMapper {
    @Override
    public PrzedmiotDto mapToDto(Przedmiot przedmiot) {
        PrzedmiotDto przedmiotDto = new PrzedmiotDto();
        przedmiotDto.setNazwaPrzedmiotu(przedmiot.getNazwaPrzedmiotu());
        przedmiotDto.setNumerSemestru(przedmiot.getSemestr().getNumerSemestru());
        przedmiotDto.setPersonaliaProwadzacego(przedmiot.getProwadzacy().getDanePersonalne());
        return przedmiotDto;
    }
}
