package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Genero;

public class ExemploAtualizacao {

	public static void main(String[] args) {
		//Obter uma fabrica
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Obter um entity manager
		
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um cliente com o codigo(detached)
		Cliente cliente = new Cliente(1, "Marcos", "marcos@fiap.com.br", new BigDecimal(1000), 
													LocalDate.of(2000, Month.AUGUST, 15), null, Genero.MASCULINO);
		
		//Atualizar o banco
		//Retorna a copia
		Cliente copia = em.merge(cliente);
		
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		copia.setNome("Rafael");
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();

	}

}
