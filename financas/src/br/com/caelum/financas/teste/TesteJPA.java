package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPA {

	
	
	
	public static void main(String[] args) {
		
		double inicio = System.currentTimeMillis();
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Felipe Bento");
		conta.setBanco("Santander");
		conta.setNumero("131313");
		conta.setAgencia("325");
		
		manager.getTransaction().begin();
		
		manager.persist(conta);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		double fim = System.currentTimeMillis();
		
		System.out.println("Executando em: " + (fim-inicio)/1000 + "s");
		
	}
	
}
