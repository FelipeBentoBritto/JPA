package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();

//		Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
//		Conta conta = manager.find(Conta.class, 2);
//		System.out.println("Titular: " + movimentacao.getConta().getTitular());
//		System.out.println("Número de movimentacoes: " + conta.getMovimentacoes().size());
		
		 Query query =
		 manager.createQuery("select distinct c from Conta c join fetch c.movimentacoes");

		 List<Conta> contas = query.getResultList();

		 for (Conta conta : contas) {
		 System.out.println("Números de movimentações: " +
		 conta.getMovimentacoes().size());
		 }
		
//		Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pId");
//        query.setParameter("pId", 2);
//        Conta conta = (Conta) query.getSingleResult();
//
//        manager.close();
//
//        System.out.println(conta.getMovimentacoes().size()); 

	}

}
