package br.com.caelum.financas.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private final EntityManager manager;
	
	public MovimentacaoDao(EntityManager manager) {
			this.manager = manager;
		
	}
	
	public MovimentacaoDao() {
		this(null);
	}
	
	public BigDecimal somaDaConta(Conta conta) {
		TypedQuery<BigDecimal> query = manager
				.createQuery("select sum(m.valor) from Movimentacao m where m.conta=:pConta and m.tipoMovimentacao = :pTipo", BigDecimal.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

		BigDecimal soma = query.getSingleResult();
		return soma;
	}
	
	public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {
		
		TypedQuery<Double> query = manager
				.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta and m.tipoMovimentacao = :pTipo", Double.class);

		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);

		Double media = query.getSingleResult();
		return media;
	}
	
	

	
	
}
