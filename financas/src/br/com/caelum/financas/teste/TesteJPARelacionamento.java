package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	
	
	
	public static void main(String[] args) {
		
		double inicio = System.currentTimeMillis();
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Felipe Bento");
		conta.setBanco("Santander");
		conta.setNumero("131313");
		conta.setAgencia("325");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("123.9"));
		
		movimentacao.setConta(conta);
		
		manager.persist(conta);
		
		manager.getTransaction().begin();
		
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		double fim = System.currentTimeMillis();
		
		System.out.println("Executando em: " + (fim-inicio)/1000 + "s");
		
	}
	
}
