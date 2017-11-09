package com.fuctura.modulo3.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.fuctura.modulo3.model.Produto;

@ManagedBean
@SessionScoped
public class ProdutoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Double preco;
	private Collection<Produto> produtos = buscarTodos();

	public String salvar() {

		/*Código para Inserir no ArrayList
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produtos.add(produto);
		
		*/
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(produto);
		tx.commit();
		JpaUtil.close();
		
		

		return "/produto/listar.xhtml";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Collection<Produto> getProdutos() {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "select p from Produto p";
		Query query = em.createQuery(jpql);
		return query.getResultList();
		//return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	
	/*public Collection<Produto> buscarTodos() {
		EntityManager em = JpaUtil.getEntityManager();
		String jpql = "select p from Produto p";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	*/
	public String excluirProdutoPorId(Produto produto, Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		produto = em.find(Produto.class, id);
		em.remove(produto);
		tx.commit();
		JpaUtil.close();
		return "/produto/listar.xhtml";
	}
	
	
	
	
}
