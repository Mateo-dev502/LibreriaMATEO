/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.vqzmto.libreriajpa.persistencia;
import gt.com.vqzmto.libreriajpa.entidades.Libro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Esta clase maneja todas las operaciones de la base de datos (CRUD)
 * utilizando JPA.

/**
 *
 * @author Vqzmt
 */
public class JPAController {
// EntityManagerFactory: Es una "fábrica" de conexiones a la base de datos.
    // Se crea una sola vez para toda la aplicación y es un objeto pesado.
    // Lee la configuración del archivo "persistence.xml" usando el nombre de la unidad "LibreriaJPA_PU".
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaJPA_PU");

    // EntityManager: Es el objeto que realmente interactúa con la base de datos.
    // Realiza las operaciones como guardar, buscar, etc. Es un objeto "ligero"
    // que se crea y se destruye para cada operación o conjunto de operaciones.
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    // - Métodos de Operación -

    // Método para guardar un libro (y su autor si es nuevo gracias al CascadeType.PERSIST)
    public void guardarLibro(Libro libro) {
        // Obtenemos un EntityManager para esta operación.
        EntityManager em = getEntityManager();
        try {
            // Se inicia una transacción. Todas las operaciones de escritura en la BD deben estar en una.
            em.getTransaction().begin();
            
            // "persist" es la orden para guardar el objeto en la base de datos.
            // JPA convierte el objeto "libro" en una sentencia SQL "INSERT".
            em.persist(libro);
            
            // "commit" confirma la transacción. Si todo salió bien, los datos se guardan permanentemente.
            em.getTransaction().commit();
        } finally {
            // Es crucial cerrar siempre el EntityManager para liberar recursos.
            if (em != null) {
                em.close();
            }
        }
    }
    
    // Método para obtener una lista con todos los libros de la base de datos.
    public List<Libro> listarLibros() {
        // Obtenemos un EntityManager para la consulta.
        EntityManager em = getEntityManager();
        try {
            // Se crea una consulta usando JPQL (Java Persistence Query Language).
            // Se parece a SQL, pero opera sobre las clases de Entidad, no sobre las tablas.
            // "SELECT l FROM Libro l" significa: "Selecciona todos los objetos 'l' que sean de la clase Libro".
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l", Libro.class);
            
            // "getResultList" ejecuta la consulta y devuelve el resultado como una lista de objetos Libro.
            return query.getResultList();
        } finally {
            // Cerramos el EntityManager.
            if (em != null) {
                em.close();
            }
        }
    }
}