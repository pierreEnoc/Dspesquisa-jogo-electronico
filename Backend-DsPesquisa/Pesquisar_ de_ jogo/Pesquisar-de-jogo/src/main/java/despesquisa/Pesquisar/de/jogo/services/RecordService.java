package despesquisa.Pesquisar.de.jogo.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import despesquisa.Pesquisar.de.jogo.dto.RecordDTO;
import despesquisa.Pesquisar.de.jogo.dto.RecordInsertDTO;
import despesquisa.Pesquisar.de.jogo.entities.Game;
import despesquisa.Pesquisar.de.jogo.entities.Record;
import despesquisa.Pesquisar.de.jogo.repositories.GameRepository;
import despesquisa.Pesquisar.de.jogo.repositories.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());
		
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);
		
		entity = recordRepository.save(entity);
		return new RecordDTO(entity);
	}
    
	@Transactional(readOnly = true)
	public Page<RecordDTO> findBYMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
	
		return recordRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}

}
