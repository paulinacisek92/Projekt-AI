package wat.edu.planzajec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wat.edu.planzajec.model.encja.Zajecia;

import java.util.List;

public interface ZajeciaRepository extends JpaRepository<Zajecia,Long> {
    List<Zajecia> findAllByGrupa_NumerGrupy(String numerGrupy);
    List<Zajecia> findAllByProwadzacy_Id(long idProwadzacego);
}
