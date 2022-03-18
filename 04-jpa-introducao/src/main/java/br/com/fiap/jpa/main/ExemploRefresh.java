package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;

public class ExemploRefresh {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		Cliente cliente = em.find(Cliente.class, 1);
		System.out.println(cliente.getNome());
		cliente.setNome("Marcos");
		System.out.println(cliente.getNome());
		em.refresh(cliente);
		System.out.println(cliente.getNome());

		em.close();
		fabrica.close();

	}

}
