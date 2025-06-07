/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 * Clase principal que inicia la aplicación.
 */
package gt.com.vqzmto.libreriajpa;
// Esto le dice a esta clase dónde encontrar la VentanaPrincipal.
import gt.com.vqzmto.libreriajpa.gui.VentanaPrincipal;
/**
 *
 * @author Vqzmt
 */
public class LibreriaJPA {

 public static void main(String[] args) {
        // Creamos una instancia de nuestra ventana.
        VentanaPrincipal ventana = new VentanaPrincipal();
        // La centramos en la pantalla.
        ventana.setLocationRelativeTo(null);
        // La hacemos visible para el usuario.
        ventana.setVisible(true);
    }
}
