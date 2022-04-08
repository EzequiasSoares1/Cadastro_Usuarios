package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import Model.Pessoa;

public class PessoaDAO extends DAO {
	
	public void Cadastrar(Pessoa p) throws Exception{
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(p);
			transaction.commit();
		} catch (PersistenceException pe) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new Exception("Ocorreu algum erro ao tentar salvar o usuário. " + pe);
		} finally {
			em.close();
		}
	}
	
	public Pessoa Atualizar(Pessoa p) throws Exception {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pessoa res = p;
		try {
			res = em.merge(p);
			transaction.commit();
		} catch (PersistenceException pe) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new Exception("Ocorreu algum erro ao tentar atualizar o usuário.", pe);

		} finally {
			em.close();
		}
		return res;
	}
	
	public void Apagar(Pessoa p) throws Exception {
		EntityManager em = getEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			p = em.find(Pessoa.class, p.getCpf());
			em.remove(p);
			transaction.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (transaction.isActive()) {
				transaction.rollback();
			}
			throw new Exception("Ocorreu algum erro ao tentar remover o usuário. ", pe);

		} finally {
			em.close();
		}
	}
	
	public Pessoa BuscarCpf(String cpf) throws Exception {
		EntityManager em = getEntityManager();
		Pessoa resultado = null;
		try {
			resultado = em.find(Pessoa.class, cpf);
		} catch (PersistenceException pe) {
			throw new Exception("Erro ao tentar recuperar o usuário com base no CPF. ", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
	public List<Pessoa> BuscarTodos() throws Exception {
		EntityManager em = getEntityManager();
		List<Pessoa> resultado = null;
		try {
			TypedQuery<Pessoa> query = em.createQuery("SELECT u FROM Pessoa u", Pessoa.class);
			resultado = query.getResultList();
		} catch (PersistenceException pe) {
			throw new Exception("Erro ao tentar recuperar todos os usuários. ", pe);
		} finally {
			em.close();
		}
		return resultado;
	}
	
}
