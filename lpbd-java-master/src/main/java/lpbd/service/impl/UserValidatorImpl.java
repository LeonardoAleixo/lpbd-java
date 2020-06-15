package lpbd.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lpbd.model.User;
import lpbd.response.ObjectUser;
import lpbd.service.PessoaFisicaValidator;
import lpbd.service.UserValidator;
import lpbd.util.DateUtil;

@Service
public class UserValidatorImpl implements UserValidator {
	
	@Autowired
	private PessoaFisicaValidator pessoaFisicaValidator;

	/*
	 * Alterado LPBD - Valdir Evaristo - 29/05/2019 
	 * Método para aplicar validação de data do usuário a partir da data selecionada.
	 * @Parameter ObjectUser
	 */
	@Override
	public User valideUser(ObjectUser objectUser) throws Exception{
		User user = null;
		if (objectUser.getNome() == null || objectUser.getNome().isEmpty()) {
			throw new Exception("Nome de usuário não informado");
		}
		if (objectUser.getSobrenome() == null || objectUser.getSobrenome().isEmpty()) {
			throw new Exception("Sobrenome de usuário não informado");
		}
		if (objectUser.getDataNascimento() == null) {
			throw new Exception("Data de nascimento de usuário não informado");
		}
		
		
		if (objectUser.getDataNascimento() != null 
				&& DateUtil.getDifferenceBetweenDates(new Date(objectUser.
						getDataNascimento()), new Date(), DateUtil.YEARS) < 18) {
			throw new Exception("Idade precisa ser maior ou igual a 18 anos");
		}
		if (!pessoaFisicaValidator.validarCpf(objectUser.getCpf())) {
			throw new Exception("Cpf inválido");
		}
		if (objectUser.getTelefone() == null || objectUser.getTelefone().isEmpty() ) {
			throw new Exception("Telefone de usuário não informado");
		}
		user = new User();
		user.setCpf(objectUser.getCpf());
		user.setDataNascimento(new Date(objectUser.getDataNascimento()));
		user.setNome(objectUser.getNome());
		user.setSobrenome(objectUser.getSobrenome());
		user.setTelefone(objectUser.getTelefone());
		return user;
	}

	
}
