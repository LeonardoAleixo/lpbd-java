package lpbd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lpbd.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	 /*
     * Alterado LPBD - Leonardo Aleixo - 30/07/2019 
     * Query JPA para busca de todos os usuários.
     */
	@Query("SELECT u FROM User u")
	List<User> findAllUsers();
	
}
