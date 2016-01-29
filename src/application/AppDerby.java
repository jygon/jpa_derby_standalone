package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.tbPessoas;
import enums.Cores;
import static enums.Cores.Azul;

/**
 * Hello world!
 *
 */
public class AppDerby
{
    public static void main( String[] args )
    {
    	seleciona();
    	shutdown();
    }
    
    private static void shutdown()
    {
        try
        {
        	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        	Connection conn = DriverManager.getConnection("jdbc:derby:/geral/java/workspaceLuna/jpaDerby/myDB;create=true"); 
            DriverManager.getConnection("jdbc:derby:/geral/java/workspaceLuna/jpaDerby/myDB;create=true;shutdown=true");
            conn.close();
        }
        catch (Exception sqlExcept){
        	//System.err.println(sqlExcept.toString());
        	//System.err.println(sqlExcept.getMessage());
        	//sqlExcept.printStackTrace();
        }
    }
    
    static void seleciona(){
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT p FROM tbPessoas p");
        List<tbPessoas> pessoasList = q.getResultList();
        for (tbPessoas pessoa : pessoasList) {
        	 String olhos = pessoa.getCorOlhos().name();
        	 System.out.println(pessoa.getCorOlhos()==Azul);
        	 System.out.println(olhos);
             System.out.println(pessoa.getId() + " - " + pessoa.getNome() + " - " + pessoa.getCorOlhos());
        }

        
        System.out.println("Size: " + pessoasList.size());

        em.close();
    }
    
    static void insere(){
    	EntityManagerFactory fac = Persistence.createEntityManagerFactory("tarefas");
    	EntityManager entityManager = (EntityManager) fac.createEntityManager(); 
    	entityManager.getTransaction().begin();
    	
    	tbPessoas p = new tbPessoas();
    	p.setId(2);
    	p.setNome("aaaaa");
    	p.setIdade(10);
    	p.setCpf("12221111");
    	p.setCorOlhos(Azul);
    	entityManager.persist(p);
    	entityManager.getTransaction().commit();
    	
    	entityManager.createNativeQuery("shutdown;").executeUpdate();
    	
    	entityManager.close();
    	
        System.out.println( "Hello World!" );
    }
}
