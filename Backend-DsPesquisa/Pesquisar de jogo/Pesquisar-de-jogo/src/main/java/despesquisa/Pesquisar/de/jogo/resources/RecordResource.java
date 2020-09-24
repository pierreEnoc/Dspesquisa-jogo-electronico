package despesquisa.Pesquisar.de.jogo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import despesquisa.Pesquisar.de.jogo.dto.RecordDTO;
import despesquisa.Pesquisar.de.jogo.dto.RecordInsertDTO;
import despesquisa.Pesquisar.de.jogo.services.RecordService;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {
	
	@Autowired
	private RecordService recordService;

	@PostMapping
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
		
		RecordDTO newDTO = recordService.insert(dto);
		return ResponseEntity.ok().body(newDTO);	
	}
}
