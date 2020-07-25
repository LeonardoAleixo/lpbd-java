package lpbd.rest;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lpbd.response.ObjectTarefa;
import lpbd.service.TarefaService;

@RestController
@Validated
@RequestMapping("/lpbd/tarefa")
public class TarefaRest {
	@Autowired
	private TarefaService tarefaService;

	@GetMapping("/get/id/{id}/")
	@CrossOrigin
	ResponseEntity<String> getById(@PathVariable Integer id) {
		String response = null;
		try {
			response = tarefaService.encontrarPorId(id).toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get/id/user/{id}/")
	@CrossOrigin
	ResponseEntity<String> getByIdUser(@PathVariable Integer id) {
		String response = null;
		try {
			response = tarefaService.encontrarPorUsuario(id).toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/get/id/importancia/{id}/")
	@CrossOrigin
	ResponseEntity<String> getByIdImportancia(@PathVariable Integer id) {
		String response = null;
		try {
			response = tarefaService.encontrarPorImportancia(id).toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/get/all/")
	@CrossOrigin(origins = "*", maxAge = 3600)
	ResponseEntity<String> getAll() {
		String response = null;
		try {
			response = tarefaService.encontrarPorPeriodo( new Date(), new Date()).toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	
	@PostMapping("/save/")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	ResponseEntity<String> save(@Valid @RequestBody ObjectTarefa objectTarefa) {
		String response = "";
		try {
			response = tarefaService.salvar(objectTarefa).toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
