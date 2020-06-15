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
@Table(name = "User")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
		@NamedQuery(name = "User.findByNome", query = "SELECT u FROM User u WHERE u.nome = :nome"),
		@NamedQuery(name = "User.findBySobrenome", query = "SELECT u FROM User u WHERE u.sobrenome = :sobrenome"),
		@NamedQuery(name = "User.findByDataNascimento", query = "SELECT u FROM User u WHERE u.dataNascimento = :dataNascimento"),
		@NamedQuery(name = "User.findByCpf", query = "SELECT u FROM User u WHERE u.cpf = :cpf"),
		@NamedQuery(name = "User.findByTelefone", query = "SELECT u FROM User u WHERE u.telefone = :telefone") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_User")
	private Integer idUser;
	@Column(name = "nome")
	private String nome;
	@Column(name = "sobrenome")
	private String sobrenome;
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "telefone")
	private String telefone;

	public User() {
	}

	public User(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUser != null ? idUser.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.idUser == null && other.idUser != null)
				|| (this.idUser != null && !this.idUser.equals(other.idUser))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "br.com.aleixo.ordem_servico.model.User[ idUser=" + idUser + " ]";
	}

}
