package lpbd.service;

import lpbd.model.Tarefa;
import lpbd.response.ObjectTarefa;


public interface TarefaService{

    public ObjectTarefa encontrarPorUsuario(Integer idUsuario) throws Exception;
    public ObjectTarefa encontrarPorId(Integer idTarefa) throws Exception;
    public ObjectTarefa encontrarPorPeriodo(Date inicio, Date fim) throws Exception;
    public ObjectTarefa salvar(ObjectTarefa) throws Exception;
    public ObjectTarefa preencherObjectTarefa(Tarefa tarefa) throws Exception;
    public ObjectTarefa preencherTarefa(ObjectTarefa objTarefa) throws Exception;

}