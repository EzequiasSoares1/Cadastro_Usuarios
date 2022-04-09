package Controller;

import java.util.Date;
import java.util.List;

import Model.Endereco;
import Model.Pessoa;
import Model.Sexo;

public class Controlador {
	
	public boolean Cadastrar(String nome, String email, String tell ,String cpf, Date data, Sexo sexo,Endereco endereco) throws Exception{
		if(!nome.equals("") && !cpf.equals("")) {
			new Pessoa().CadastrarPessoa(new Pessoa(nome,email,tell,cpf,data,sexo,endereco));
			return true;
		}
		return false;
	}
	
	public boolean Atualizar(String nome, String email, String tell ,String cpf,Date data,Sexo sexo,Endereco endereco) throws Exception{
		if(!nome.equals("") && !cpf.equals("")) {
			new Pessoa().Atualizar(new Pessoa(nome,email,tell,cpf,data,sexo,endereco));
			return true;
		}
		return false;
	}
	
	public Endereco CriarEn(String rua, String numero, String cep,String cidade,String estado,String referencia,String pais) {
		return new Endereco(rua,numero,cep,cidade,estado,referencia,pais);
	}
	
	public Pessoa Buscar(String cpf) throws Exception {
		return new Pessoa().BuscarCpf(cpf);
	}
	
	public List<Pessoa> ListarTodos() throws Exception {
		return new Pessoa().BuscarTodos();
	}
	
	public void Excluir(String cpf) throws Exception {
		new Pessoa().Apagar(Buscar(cpf));
	}
	
}
