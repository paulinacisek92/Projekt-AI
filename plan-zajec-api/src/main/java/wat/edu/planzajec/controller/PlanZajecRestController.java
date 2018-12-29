package wat.edu.planzajec.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wat.edu.planzajec.model.dto.GrupaDto;
import wat.edu.planzajec.model.dto.ProwadzacyDto;
import wat.edu.planzajec.model.dto.PrzedmiotDto;
import wat.edu.planzajec.model.dto.ZajeciaDto;

import java.util.List;



//przekladanie przez prowadzacego
//pobranie listy przedmiotow prowadzacego
//pobranie listy grup dla ktorych ten przedmiot prowadacy prowdzi
//pobranie listy zajec z danego przedmiotu z dana grupa danego prowadzacego
//wystawic endpoint z lista dostepnych blokow godzinowcyh an dany dzien danej grupy i prowadzacego
//wystawic endpoint do zapisania zmian - automatyczne wyszukanie sali

//przekladanie przez grupe
//pobranie listy grup
//pobranie listy przedmiotow grupy
//pobranie listy zajec z danego przedmiotu z dana grupa
//wystawic endpoint z lista dostepnych blokow godzinowcyh an dany dzien danej grupy i prowadzacego
public interface PlanZajecRestController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/zajecia/grupa/{numerGrupy}/{numerTygodnia}")
    ResponseEntity<List<List<ZajeciaDto>>> pobierzZajeciaGrupyNaDanyNumerTygodnia(@PathVariable("numerGrupy") String numerGrupy, @PathVariable("numerTygodnia") int numerTygodnia);

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/zajecia/prowadzacy/{idProwadzacego}/{numerTygodnia}")
    ResponseEntity<List<List<ZajeciaDto>>> pobierzZajeciaProwadzacegoNaDanyNumerTygodnia(@PathVariable("idProwadzacego") long idProwadzacego, @PathVariable("numerTygodnia") int numerTygodnia);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/grupy")
    ResponseEntity<List<GrupaDto>> pobierzListeGrup();

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/prowadzacy")
    ResponseEntity<List<ProwadzacyDto>> pobierzListeProwadzacych();

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/zajecia/{numerGrupy}")
    ResponseEntity<List<PrzedmiotDto>> pobierzListePrzedmiotowgrupy(@PathVariable("numerGrupy")String numerGrupy);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="/zajecia/{idProwadzacego}")
    ResponseEntity<List<PrzedmiotDto>> pobierzListePrzedmiotowProwadzacego(@PathVariable("idProwadzacego") long idProwadzacego);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/prowadzacy/{idProwadzacego}/grupy")
    ResponseEntity<List<GrupaDto>> pobierzListeGrupProwadzacego(@PathVariable("idProwadzacego") long idProwadzacego);

}
