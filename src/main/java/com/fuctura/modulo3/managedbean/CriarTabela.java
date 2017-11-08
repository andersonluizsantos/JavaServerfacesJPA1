package com.fuctura.modulo3.managedbean;

import javax.persistence.Persistence;

public class CriarTabela {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("fucturaPU");
	}

}
