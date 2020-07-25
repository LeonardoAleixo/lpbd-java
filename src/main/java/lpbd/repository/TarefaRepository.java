package lpbd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lpbd.model.Tarefa;

public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
	@Query("SELECT t FROM Tarefa t WHERE t.usuario = :usuario")
	List<Tarefa> findAllByUser(@Param("usuario") Integer usuario);
	
	
	@Query("SELECT t FROM Tarefa t WHERE t.importancia = :importancia")
	List<Tarefa> findAllByImportancia(@Param("importancia") Integer importancia);
}
