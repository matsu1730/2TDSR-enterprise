package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;

public class ExemploPesquisa {

	public static void main(String[] args) {
		//Obter a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar o cliente pela PK
		Cliente cliente = em.find(Cliente.class, 1);
		
		//Exibir o nome do cliente
		System.out.print(cliente.getNome());
		
		//Alterar nome do cliente
		cliente.setNome("Marcos");
		
		//Fechar
		em.close();
		fabrica.close();
	}
}
