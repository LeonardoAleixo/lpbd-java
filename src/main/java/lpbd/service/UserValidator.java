package lpbd.service;

import lpbd.model.User;
import lpbd.response.ObjectUser;


/*
 * Alterado LPBD - Renato Galo - 20/05/2019 
 * Inteface para alterações da tabela do User
 */
public interface UserValidator {
	public User valideUser(ObjectUser objectUser) throws Exception;
}
