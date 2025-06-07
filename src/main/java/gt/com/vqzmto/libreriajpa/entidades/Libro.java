/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.vqzmto.libreriajpa.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Esta clase representa la entidad "Libro".
 * Se mapeará a una tabla en la base de datos.
 */

// @Entity: Marca esta clase como una entidad que JPA debe gestionar.
@Entity

/**
 *
 * @author Vqzmt
 */
public class Libro implements Serializable {
    @Id
  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos propios de la clase Libro.
    private String titulo;
    
    // Se usa "año" con "ñ" para mejor visualización pero no es recomedable.
    // Aunque puede funcionar, no es una práctica recomendada en programación
    // por posibles problemas de compatibilidad. La convención sería usar "anio".
    private int año;

    // - Relación con la entidad Autor -
    // @ManyToOne: Define una relación de "Muchos a Uno".
    // Esto significa que muchos libros pueden estar asociados a un autor.
    // En la base de datos, esto creará una columna "autor_id" en la tabla "libro".
    
    // CascadeType.PERSIST: Esto es una regla en cascada. Significa que si guardamos
    // un libro que tiene un autor nuevo (que no existe en la BD), JPA guardará
    // también al autor automáticamente.
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Autor autor;

    // - Constructores -
    
    // Constructor vacío: Requerido por JPA.
    public Libro() {
    }

    // Constructor con parámetros: Esto para facilitar la creación de nuevos libros.
    public Libro(String titulo, int año, Autor autor) {
        this.titulo = titulo;
        this.año = año;
        this.autor = autor;
    }

    // - Getters y Setters -

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}

