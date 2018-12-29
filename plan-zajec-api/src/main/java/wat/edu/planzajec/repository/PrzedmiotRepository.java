package wat.edu.planzajec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wat.edu.planzajec.model.encja.Przedmiot;
import wat.edu.planzajec.model.encja.Semestr;

import java.util.List;

public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Long> {
    List<Przedmiot> findAllByProwadzacy_Id(long idProwadzacego);
    List<Przedmiot> findAllBySemestr(Semestr semestr);
}
