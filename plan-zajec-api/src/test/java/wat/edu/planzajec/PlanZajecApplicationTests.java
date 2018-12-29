package wat.edu.planzajec;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import wat.edu.planzajec.repository.BlokCzasowyRepository;
import wat.edu.planzajec.repository.ZajeciaRepository;
import wat.edu.planzajec.serwis.impl.PlanZajecServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlanZajecApplication.class)
@WebAppConfiguration
public class PlanZajecApplicationTests {


    @Autowired
    private PlanZajecServiceImpl planZajecService;

    @Autowired
    private ZajeciaRepository zajeciaRepository;

    @Autowired
    private BlokCzasowyRepository blokCzasowyRepository;


//    @Test
//    public void test() {
//        List<Zajecia> zajecia = zajeciaRepository.findAll();
//        List<BlokCzasowy> bloki = blokCzasowyRepository.findAll();
//        planZajecService.odpowiedz(planZajecService.przygotujListeZajecNaDniTygodnia(zajecia));
//    }

}
