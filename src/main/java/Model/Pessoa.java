package Model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Dao.PessoaDAO;

@Entity
@Table(name = "TB_PERSON")
public class Pessoa implements Serializable{

	public Pessoa(String nome, String email, String tell ,String cpf,Date data,Sexo sexo, Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.tell = tell;
		this.data = data;
		this.sexo = sexo;
		this.endereco = endereco;
	}
	public Pessoa() {
	}
		
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpf;
	
	@Column(name = "NAME", nullable = false)
	private String nome;
	private String email;
	
	@Column(name = "PHONE")
	private String tell;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDATE")
	private Date data;
	
	@Column(name = "Sex", nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
	@JoinColumn(name = "ADDRESS_FK")
	private Endereco endereco;
	
	public void CadastrarPessoa(Pessoa p) throws Exception {
		new PessoaDAO().Cadastrar(p);
	}
	public void Atualizar(Pessoa p) throws Exception{
		new PessoaDAO().Atualizar(p);
	}
	public void Apagar(Pessoa p) throws Exception {
		new PessoaDAO().Apagar(p);
	}
	public Pessoa BuscarCpf(String cpf) throws Exception {
		return new PessoaDAO().BuscarCpf(cpf);
	}
	public List<Pessoa> BuscarTodos() throws Exception {
		return new PessoaDAO().BuscarTodos();
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
