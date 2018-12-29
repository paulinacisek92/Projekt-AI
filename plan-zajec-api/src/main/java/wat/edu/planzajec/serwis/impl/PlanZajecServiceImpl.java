package wat.edu.planzajec.serwis.impl;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wat.edu.planzajec.model.dto.GrupaDto;
import wat.edu.planzajec.model.dto.ProwadzacyDto;
import wat.edu.planzajec.model.dto.PrzedmiotDto;
import wat.edu.planzajec.model.dto.ZajeciaDto;
import wat.edu.planzajec.model.encja.BlokCzasowy;
import wat.edu.planzajec.model.encja.Grupa;
import wat.edu.planzajec.model.encja.Zajecia;
import wat.edu.planzajec.repository.*;
import wat.edu.planzajec.serwis.PlanZajecService;
import wat.edu.planzajec.serwis.mapper.GrupaMapper;
import wat.edu.planzajec.serwis.mapper.ProwadzacyMapper;
import wat.edu.planzajec.serwis.mapper.PrzedmiotMapper;
import wat.edu.planzajec.serwis.mapper.impl.ZajeciaMapperImpl;

import java.time.DayOfWeek;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PlanZajecServiceImpl implements PlanZajecService {

    private final ZajeciaRepository zajeciaRepository;

    private final GrupaRepository grupaRepository;

    private final ProwadzacyRepository prowadzacyRepository;

    private final PrzedmiotRepository przedmiotRepository;

    private final BlokCzasowyRepository blokCzasowyRepository;

    private final ZajeciaMapperImpl zajeciaMapper;

    private final ProwadzacyMapper prowadzacyMapper;

    private final GrupaMapper grupaMapper;

    private final PrzedmiotMapper przedmiotMapper;

    @Override
    public List<List<ZajeciaDto>> zwrocListeZajecGrupyNaDanyTydzien(String numerGrupy, int numerTygodnia) {
        if (numerTygodnia > 52) {
            numerTygodnia %= 52;
        }
        List<Zajecia> listaZajecGrupy = zajeciaRepository.findAllByGrupa_NumerGrupy(numerGrupy);
        listaZajecGrupy = wyszukajZajeciaNaDanyNumerTygodnia(listaZajecGrupy, numerTygodnia);
        List<List<Zajecia>> zajeciaPogrupowanePoBlokach = przygotujListeZajecPoBlokach(listaZajecGrupy);
        return przygotujOdpowiedz(zajeciaPogrupowanePoBlokach);
    }

    @Override
    public List<List<ZajeciaDto>> zwrocListeZajecProwadzacegoNaDanyTydzien(long idProwadzacego, int numerTygodnia) {
        if (numerTygodnia > 52) {
            numerTygodnia %= 52;
        }
        List<Zajecia> listaZajecProwadzacego = zajeciaRepository.findAllByProwadzacy_Id(idProwadzacego);
        listaZajecProwadzacego = wyszukajZajeciaNaDanyNumerTygodnia(listaZajecProwadzacego, numerTygodnia);
        List<List<Zajecia>> zajeciaPogrupowanePoBlokach = przygotujListeZajecPoBlokach(listaZajecProwadzacego);
        return przygotujOdpowiedz(zajeciaPogrupowanePoBlokach);
    }

    @Override
    public List<GrupaDto> zwrocListeGrup() {
        return grupaRepository.findAll().stream().map(grupaMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProwadzacyDto> zwrocListeProwadzacych() {
        return prowadzacyRepository.findAll().stream().map(prowadzacyMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<PrzedmiotDto> zwrocListePrzedmiotowGrupy(String numerGrupy) {
        Grupa grupa = grupaRepository.findFirstByNumerGrupy(numerGrupy);
        return przedmiotRepository.findAllBySemestr(grupa.getAktualnySemestrGrupy()).stream().map(przedmiotMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<PrzedmiotDto> zwrocListePrzedmiotowProwadzacego(long idProwadzacego) {
        return przedmiotRepository.findAllByProwadzacy_Id(idProwadzacego).stream().map(przedmiotMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<GrupaDto> zwrocListeGrupProwadzacego(long idProwadzacego) {
        return null;
    }

    private List<Zajecia> wyszukajZajeciaNaDanyNumerTygodnia(List<Zajecia> listaZajec, int numerTygodnia) {
        TemporalField definicjaNumeruTygodnia = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        return listaZajec.stream()
                .filter(zajecia -> zajecia.getDzienZajec().get(definicjaNumeruTygodnia) == numerTygodnia).collect(Collectors.toList());
    }

    private List<List<Zajecia>> przygotujListeZajecPoBlokach(List<Zajecia> listaZajec) {
        List<BlokCzasowy> blokiZajec = blokCzasowyRepository.findAll();
        return blokiZajec.stream().map(blokCzasowy -> listaZajec.stream().filter(zajecia -> zajecia.getBlokCzasowy().equals(blokCzasowy))
                .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private List<List<ZajeciaDto>> przygotujOdpowiedz(List<List<Zajecia>> zajeciaWBlokach) {
        DayOfWeek[] dniTygodnia = DayOfWeek.values();
        return zajeciaWBlokach.stream().map(zajeciaBloki -> {
            List<ZajeciaDto> listaZajecWBlokach = new LinkedList<>();
            for (DayOfWeek dzienTygodnia : dniTygodnia) {
                Optional<Zajecia> zajeciaWDanymDniu = zajeciaBloki.stream().filter(zajecia -> zajecia.getDzienZajec().getDayOfWeek().equals(dzienTygodnia)).findFirst();
                if (zajeciaWDanymDniu.isPresent())
                    listaZajecWBlokach.add(zajeciaMapper.mapToDto(zajeciaWDanymDniu.get()));
                else listaZajecWBlokach.add(new ZajeciaDto());
            }
            return listaZajecWBlokach;
        }).collect(Collectors.toList());
    }
}

