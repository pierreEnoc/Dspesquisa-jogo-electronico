package despesquisa.Pesquisar.de.jogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import despesquisa.Pesquisar.de.jogo.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
