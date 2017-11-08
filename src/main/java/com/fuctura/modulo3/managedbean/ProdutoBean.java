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
	private Collection<Produto> produtos = new ArrayList<>();

	public String salvar() {

		/*Código para Inserir no ArrayList
		
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		produtos.add(produto);
		
		*/
		
		/*Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fucturaPU");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		manager.persist(produto);
		tx.commit();	

		manager.close();
		factory.close();*/
		
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
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
}
