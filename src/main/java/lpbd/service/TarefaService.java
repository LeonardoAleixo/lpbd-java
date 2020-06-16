package lpbd.service;

import java.util.Date;
import java.util.List;

import lpbd.model.Tarefa;
import lpbd.response.ObjectTarefa;

public interface TarefaService {
	
	public List<ObjectTarefa> encontrarPorUsuario(Integer idUsuario);
	
	public ObjectTarefa encontrarPorId(Integer idTarefa);
	
	public List<ObjectTarefa> encontrarPorPeriodo(Date inicio, Date fim);
	
	public ObjectTarefa salvar(ObjectTarefa objectTarefa);
	
	public ObjectTarefa preencherObjectTarefa(Tarefa tarefa);
	
	public Tarefa preencherTarefa(ObjectTarefa objTarefa);
}
