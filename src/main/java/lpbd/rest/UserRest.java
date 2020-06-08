package lpbd.rest;

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

import lpbd.response.ObjectUser;
import lpbd.service.UserService;

@RestController
@Validated
@RequestMapping("/lpbd/user")
public class UserRest {

	@Autowired
	private UserService userService;

	/*
     * Alterado LPBD - Valdir Evaristo - 20/05/2019 
     * Serviço Rest para buscar usuario atraves dos parametros
     * @Parameter Integer id
     */
	@GetMapping("/get/id/{id}/")
	@CrossOrigin
	ResponseEntity<String> getBbyId(@PathVariable Integer id) {
		String response = null;
		try {
			response = userService.getUserByID(id).toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	
	/*
     * Alterado LPBD - Valdir Evaristo -  20/05/2019 
     * Serviço Rest para buscar todos os usuários do banco de dados
     */
	@GetMapping("/get/all/")
	@CrossOrigin(origins = "*", maxAge = 3600)
	ResponseEntity<String> getAll() {
		String response = null;
		try {
			response = userService.getAll().toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	
	/*
     * Alterado LPBD - Julio Rangel - 14/05/2019 
     * Serviço Rest para salvar usuário através dos parâmetros.
     * @Parameter ObjectUser
     */
	@PostMapping("/save/")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin
	ResponseEntity<String> save(@Valid @RequestBody ObjectUser objectUser) {
		String response = "";
		try {
			response = userService.saveUser(objectUser).toString();
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
