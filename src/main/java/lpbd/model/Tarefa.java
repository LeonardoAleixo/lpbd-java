package lpbd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aleixo
 */
@Entity
@Table(name = "tarefa")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Tarefa.findAll", query = "SELECT t FROM Tarefa t"),
		@NamedQuery(name = "Tarefa.findByIdTarefa", query = "SELECT t FROM Tarefa t WHERE t.idTarefa = :idTarefa"),
		@NamedQuery(name = "Tarefa.findByTitulo", query = "SELECT t FROM Tarefa t WHERE t.titulo = :titulo") })
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_Tarefa")
	private Integer idTarefa;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "data_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Column(name = "data_fim")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFim;

	@Column(name = "usuario")
	private Integer usuario;

	@Column(name = "importancia")
	private Integer importancia;

	@Column(name = "data_prevista_fim")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrevistaFim;

	public Tarefa() {
	}

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
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

	public Date getDataPrevistaFim() {
		return dataPrevistaFim;
	}

	public void setDataPrevistaFim(Date dataPrevistaFim) {
		this.dataPrevistaFim = dataPrevistaFim;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idTarefa != null ? idTarefa.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Tarefa)) {
			return false;
		}
		Tarefa other = (Tarefa) object;
		if ((this.idTarefa == null && other.idTarefa != null)
				|| (this.idTarefa != null && !this.idTarefa.equals(other.idTarefa))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.aleixo.ordem_servico.model.Tarefa[ idTarefa=" + idTarefa + " ]";
	}

}
