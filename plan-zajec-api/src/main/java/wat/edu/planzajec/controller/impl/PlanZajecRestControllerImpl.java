package wat.edu.planzajec.controller.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wat.edu.planzajec.controller.PlanZajecRestController;
import wat.edu.planzajec.model.dto.GrupaDto;
import wat.edu.planzajec.model.dto.ProwadzacyDto;
import wat.edu.planzajec.model.dto.PrzedmiotDto;
import wat.edu.planzajec.model.dto.ZajeciaDto;
import wat.edu.planzajec.serwis.PlanZajecService;

import java.util.List;

@RequestMapping("/api")
@RestController
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class PlanZajecRestControllerImpl implements PlanZajecRestController {

    private final PlanZajecService planZajecService;

    @Override
    public ResponseEntity<List<List<ZajeciaDto>>> pobierzZajeciaGrupyNaDanyNumerTygodnia(@PathVariable("numerGrupy") String numerGrupy, @PathVariable("numerTygodnia") int numerTygodnia) {
        return ResponseEntity.ok(planZajecService.zwrocListeZajecGrupyNaDanyTydzien(numerGrupy, numerTygodnia));
    }

    @Override
    public ResponseEntity<List<List<ZajeciaDto>>> pobierzZajeciaProwadzacegoNaDanyNumerTygodnia(@PathVariable("idProwadzacego") long idProwadzacego, @PathVariable("numerTygodnia") int numerTygodnia) {
        return ResponseEntity.ok(planZajecService.zwrocListeZajecProwadzacegoNaDanyTydzien(idProwadzacego, numerTygodnia));
    }

    @Override
    public ResponseEntity<List<GrupaDto>> pobierzListeGrup() {
        return ResponseEntity.ok(planZajecService.zwrocListeGrup());
    }

    @Override
    public ResponseEntity<List<ProwadzacyDto>> pobierzListeProwadzacych() {
        return ResponseEntity.ok(planZajecService.zwrocListeProwadzacych());
    }

    @Override
    public ResponseEntity<List<PrzedmiotDto>> pobierzListePrzedmiotowgrupy(@PathVariable("numerGrupy") String numerGrupy) {
        return ResponseEntity.ok(planZajecService.zwrocListePrzedmiotowGrupy(numerGrupy));
    }

    @Override
    public ResponseEntity<List<PrzedmiotDto>> pobierzListePrzedmiotowProwadzacego(@PathVariable("idProwadzacego") long idProwadzacego) {
        return ResponseEntity.ok(planZajecService.zwrocListePrzedmiotowProwadzacego(idProwadzacego));
    }

    @Override
    public ResponseEntity<List<GrupaDto>> pobierzListeGrupProwadzacego(@PathVariable("idProwadzacego") long idProwadzacego) {
        return ResponseEntity.ok(planZajecService.zwrocListeGrupProwadzacego(idProwadzacego));
    }


}
