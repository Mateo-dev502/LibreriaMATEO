/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.com.vqzmto.libreriajpa.gui;

import gt.com.vqzmto.libreriajpa.entidades.Autor;
import gt.com.vqzmto.libreriajpa.entidades.Libro;
import gt.com.vqzmto.libreriajpa.persistencia.JPAController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta es la ventana principal de la aplicación.
 * Desde aquí el usuario puede registrar y ver libros.
 */

/**
 *
 * @author Vqzmt
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    // Esta línea habla con la base de datos.
    private final JPAController controller;
    // El modelo para manejar los datos de nuestra tabla.
    private DefaultTableModel modeloTabla;

    // Esto se ejecuta apenas se abre la ventana.
    public VentanaPrincipal() {
        this.controller = new JPAController();
        initComponents(); // Dibuja los botones, campos de texto, etc.
        configurarTabla(); // Le pone los títulos a las columnas de la tabla.
        cargarLibrosEnTabla(); // Rellena la tabla con los datos que ya existen.
    }

    // Prepara la tabla para que se vea chido.
    private void configurarTabla() {
        // Los títulos de las columnas.
        String[] columnas = {"ID", "Título", "Año", "Autor", "Nacionalidad"};
        // Creamos el modelo de la tabla.
        modeloTabla = new DefaultTableModel(columnas, 0) {
            // Hacemos que no se pueda escribir en las celdas.
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        // Le ponemos el modelo a la tabla que diseñamos.
        tblLibros.setModel(modeloTabla);
    }

    // Agarra los libros de la base de datos y los pone en la tabla.
    private void cargarLibrosEnTabla() {
        // Limpia la tabla por si tenía algo antes.
        modeloTabla.setRowCount(0);
        // Le pide todos los libros al controlador.
        List<Libro> libros = controller.listarLibros();

        // Pasa por cada libro de la lista.
        for (Libro libro : libros) {
            // Crea una fila con los datos del libro.
            Object[] fila = {
                libro.getId(),
                libro.getTitulo(),
                libro.getAño(),
                libro.getAutor().getNombre(),
                libro.getAutor().getNacionalidad()
            };
            // Agrega la fila a la tabla.
            modeloTabla.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelRegistro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAutorNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAutorNacionalidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        panelLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Registro de Libros");

        panelRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Nuevo Libro"));

        jLabel1.setText("Título del Libro:");

        jLabel2.setText("Año de Publicación:");

        jLabel3.setText("Nombre del Autor:");

        jLabel4.setText("Nacionalidad del Autor:");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo)
                            .addComponent(txtAutorNombre))
                        .addGap(18, 18, 18)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAño, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(txtAutorNacionalidad))))
                .addContainerGap())
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAutorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtAutorNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLista.setBorder(javax.swing.BorderFactory.createTitledBorder("Libros Registrados"));

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblLibros);

        javax.swing.GroupLayout panelListaLayout = new javax.swing.GroupLayout(panelLista);
        panelLista.setLayout(panelListaLayout);
        panelListaLayout.setHorizontalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelListaLayout.setVerticalGroup(
            panelListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>   
    

    // Esto se ejecuta cuando damos clic al botón "Guardar".
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Agarra lo que el usuario escribió en los campos.
        String titulo = txtTitulo.getText();
        String anioStr = txtAño.getText();
        String autorNombre = txtAutorNombre.getText();
        String autorNacionalidad = txtAutorNacionalidad.getText();

        // Revisa que no haya dejado algún campo vacío.
        if (titulo.isEmpty() || anioStr.isEmpty() || autorNombre.isEmpty() || autorNacionalidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Si falta algo, se detiene aquí.
        }

        int año;
        try {
            // Intenta convertir el texto del año a un número.
            año = Integer.parseInt(anioStr);
        } catch (NumberFormatException e) {
            // Si no se puede, muestra un error.
            JOptionPane.showMessageDialog(this, "El año tiene que ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Y se detiene.
        }

        // Crea los objetos con los datos que el usuario escribia.
        Autor autor = new Autor(autorNombre, autorNacionalidad);
        Libro libro = new Libro(titulo, año, autor);

        // Le pasa el libro al controlador para que lo guarde en la BD.
        controller.guardarLibro(libro);

        // Muestra un mensaje de que todo salió bien.
        JOptionPane.showMessageDialog(this, "¡Libro guardado!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Limpia los campos para que se pueda agregar otro libro.
        txtTitulo.setText("");
        txtAño.setText("");
        txtAutorNombre.setText("");
        txtAutorNacionalidad.setText("");
        
        // Vuelve a cargar la tabla para que se vea el libro nuevo.
        cargarLibrosEnTabla();
    }                                          
                   
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelLista;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtAutorNacionalidad;
    private javax.swing.JTextField txtAutorNombre;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtTitulo;
                    
}