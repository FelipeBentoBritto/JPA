package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

  public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();

		// Testes do capitulo
		
		Conta conta = manager.find(Conta.class, 32);
		
		manager.getTransaction().commit();
		
		conta.setTitular("Felipe Bento");

		manager.getTransaction().begin();
		manager.merge(conta);
		manager.getTransaction().commit();
		
		manager.close();

	}
}