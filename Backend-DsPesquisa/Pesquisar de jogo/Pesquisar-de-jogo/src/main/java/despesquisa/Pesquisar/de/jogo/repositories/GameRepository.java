package despesquisa.Pesquisar.de.jogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import despesquisa.Pesquisar.de.jogo.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
