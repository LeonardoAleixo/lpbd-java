package lpbd.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lpbd.model.Tarefa;
import lpbd.repository.TarefaRepository;
import lpbd.response.ObjectTarefa;
import lpbd.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Override
	public List<ObjectTarefa> encontrarPorUsuario(Integer idUsuario) {
		List<Tarefa> listaTarefa = tarefaRepository.findAllByUser(idUsuario);
		List<ObjectTarefa> listaObjectTarefa = new ArrayList<>();
		for(Tarefa tarefa : listaTarefa) {
			listaObjectTarefa.add(preencherObjectTarefa(tarefa));
		}
		return listaObjectTarefa;
	}
	
	@Override
	public List<ObjectTarefa> encontrarPorImportancia(Integer importancia) {
		List<Tarefa> listaTarefa = tarefaRepository.findAllByImportancia(importancia);
		List<ObjectTarefa> listaObjectTarefa = new ArrayList<>();
		for(Tarefa tarefa : listaTarefa) {
			listaObjectTarefa.add(preencherObjectTarefa(tarefa));
		}
		return listaObjectTarefa;
	}

	@Override
	public ObjectTarefa encontrarPorId(Integer idTarefa) {
		Tarefa tarefa = tarefaRepository.findById(idTarefa).get();
		return preencherObjectTarefa(tarefa);
	}

	@Override
	public List<ObjectTarefa> encontrarPorPeriodo(Date inicio, Date fim) {
		return null;
	}

	@Override
	public ObjectTarefa salvar(ObjectTarefa objectTarefa) {
		Tarefa tarefa = preencherTarefa(objectTarefa);
		tarefa = tarefaRepository.save(tarefa);
		return preencherObjectTarefa(tarefa);
	}

	@Override
	public ObjectTarefa preencherObjectTarefa(Tarefa tarefa) {
		ObjectTarefa objectTarefa = new ObjectTarefa();
		objectTarefa.setDataFim(tarefa.getDataFim().getTime());
		objectTarefa.setDataInicio(tarefa.getDataInicio().getTime());
		objectTarefa.setDataPrevistaFim(tarefa.getDataPrevistaFim().getTime());
		objectTarefa.setIdTarefa(tarefa.getIdTarefa());
		objectTarefa.setImportancia(tarefa.getImportancia());
		objectTarefa.setTitulo(tarefa.getTitulo());
		objectTarefa.setUsuario(tarefa.getUsuario());
		return objectTarefa;
	}

	@Override
	public Tarefa preencherTarefa(ObjectTarefa objTarefa) {
		Tarefa tarefa = new Tarefa();
		tarefa.setDataFim(new Date(objTarefa.getDataFim()));
		tarefa.setDataInicio(new Date(objTarefa.getDataInicio()));
		tarefa.setDataPrevistaFim(new Date(objTarefa.getDataPrevistaFim()));
		tarefa.setIdTarefa(objTarefa.getIdTarefa());
		tarefa.setImportancia(objTarefa.getImportancia());
		tarefa.setTitulo(objTarefa.getTitulo());
		tarefa.setUsuario(objTarefa.getUsuario());
		return tarefa;
	}

}
