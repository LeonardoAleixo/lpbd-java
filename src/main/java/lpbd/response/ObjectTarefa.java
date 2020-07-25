package lpbd.response;

import com.google.gson.Gson;

public class ObjectTarefa {
	private Integer idTarefa;
	private Long dataFim;
	private Integer usuario;
	private Integer importancia;
	private Long dataPrevistaFim;
	private String titulo;
	private Long dataInicio;

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Long dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Long getDataFim() {
		return dataFim;
	}

	public void setDataFim(Long dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getImportancia() {
		return importancia;
	}

	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}

	public Long getDataPrevistaFim() {
		return dataPrevistaFim;
	}

	public void setDataPrevistaFim(Long dataPrevistaFim) {
		this.dataPrevistaFim = dataPrevistaFim;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
