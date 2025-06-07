/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.vqzmto.libreriajpa.entidades;
/**
 * Esta clase representa la entidad "Autor".
 * Se mapeará a una tabla en la base de datos.
 * Implementa Serializable para permitir que sus instancias sean convertidas a un flujo de bytes.
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// La anotación @Entity indica que esta clase es una entidad JPA.
// Hibernate la gestionará y la asociará a una tabla en la base de datos.
@Entity

/**
 *
 * @author Vqzmt
 */
public class Autor implements Serializable {
    
    // La anotación @Id designa este campo como la clave primaria de la tabla.
    @Id
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 // @GeneratedValue especifica cómo se genera el valor de la clave primaria.
    // GenerationType.IDENTITY se usa para que la base de datos (ej. MySQL)
    // se encargue de autoincrementar el valor.
    
    // Estos son los atributos de la clase, que se convertirán en columnas de la tabla.
    private String nombre;
    private String nacionalidad;

    // --- Constructores ---
    // JPA requiere un constructor vacío (sin argumentos) para poder crear instancias
    // de la entidad cuando recupera datos de la base de datos.
    public Autor() {
    }
    
    // Este constructor nos permite crear instancias de Autor de forma más cómoda,
    // proveyendo los datos iniciales directamente.
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // --- Getters y Setters ---
    // Son métodos públicos que permiten acceder y modificar los valores de los
    // atributos privados de la clase, siguiendo el principio de encapsulamiento.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
