package wat.edu.planzajec.serwis;

import wat.edu.planzajec.model.dto.GrupaDto;
import wat.edu.planzajec.model.dto.ProwadzacyDto;
import wat.edu.planzajec.model.dto.PrzedmiotDto;
import wat.edu.planzajec.model.dto.ZajeciaDto;

import java.util.List;

public interface PlanZajecService {
    List<List<ZajeciaDto>> zwrocListeZajecGrupyNaDanyTydzien(String numerGrupy, int numerTygodnia);
    List<List<ZajeciaDto>> zwrocListeZajecProwadzacegoNaDanyTydzien(long idProwadzacego, int numerTygodnia);
    List<GrupaDto> zwrocListeGrup();
    List<ProwadzacyDto> zwrocListeProwadzacych();
    List<PrzedmiotDto> zwrocListePrzedmiotowGrupy(String numerGrupy);
    List<PrzedmiotDto> zwrocListePrzedmiotowProwadzacego(long idProwadzacego);
    List<GrupaDto> zwrocListeGrupProwadzacego(long idProwadzacego);
}
