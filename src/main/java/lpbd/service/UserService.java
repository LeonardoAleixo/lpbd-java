package lpbd.service;

import java.util.List;

import lpbd.model.User;
import lpbd.response.ObjectUser;

/*
 * Alterado LPBD - Renato Galo - 20/05/2019 
 * Inteface para alterações da tabela do User 
 * Implementação de interface da Classe UserServiceImpl
 * com finalizade de obter padronizaçao de projeto
 */
public interface UserService {
	public ObjectUser saveUser(ObjectUser objectUser) throws Exception;

	public ObjectUser getUserByID(Integer id) throws Exception;

	/*
	 * Alterado LPBD - Valdir Evaristo - 14/05/2019 Serviço de preenchimento de
	 * objeto baseado nos Parametros
	 * 
	 * @Parameter User
	 */
	public ObjectUser preencherUser(User user);

	public List<ObjectUser> getAll();
}
