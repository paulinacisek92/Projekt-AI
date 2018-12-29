package wat.edu.planzajec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wat.edu.planzajec.model.encja.Grupa;

import java.util.List;


public interface GrupaRepository extends JpaRepository<Grupa, Long> {
    Grupa findFirstByNumerGrupy(String numerGrupy);
//
//    @Query("SELECT g FROM Przedmiot as p inner join ")
//    List<Grupa> zwrocListeGrupProwadzacego(long idProwadzacego);


}
