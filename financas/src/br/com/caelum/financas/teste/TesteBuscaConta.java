package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
	
		Conta conta = em.find(Conta.class, 1);	
		conta.setTitular("foda-se");
		conta.setAgencia("241");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		
		
		conta = em2.find(Conta.class, 1);
		
		em2.remove(conta);
		
		em2.getTransaction().commit();
		em2.close();
		
	}
	
}
