package despesquisa.Pesquisar.de.jogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import despesquisa.Pesquisar.de.jogo.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

}
