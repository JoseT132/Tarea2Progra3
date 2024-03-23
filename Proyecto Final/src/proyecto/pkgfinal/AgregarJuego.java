
package proyecto.pkgfinal;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgregarJuego extends JFrame{
    
   private JTextField nombreText;
   private JTextField SKUText;
   private JTextField Precio;
   private JTextField lanzamientoText;
   private JButton boton;
   
   public AgregarJuego(){
       setTitle("Agregar Juego");
       setSize(500,200);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    //componentes de la interfaz
    JLabel nombreL= new JLabel("Nombre del videojuego");
    nombreText= new JTextField();
    
    JLabel SKUL= new JLabel("SKU del videojuego");
    SKUText= new JTextField();
    
    JLabel precioL= new JLabel("Precio del videojuego");
    Precio= new JTextField();
    
    JLabel lanzamientoL= new JLabel("Fecha de lanzamiento del videojuego");
    lanzamientoText= new JTextField();
    
    boton = new JButton ("Agregar Videojuego");
    boton.addActionListener(new ActionListener (){
   
           @Override
           public void actionPerformed(ActionEvent e) {
           agregar(); 
           }
    });
    
    //componentes de la ventana 
        setLayout(new GridLayout(5, 2));
        add(nombreL);
        add(nombreText);
        add(SKUL);
        add(SKUText);
        add(precioL);
        add(Precio);
        add(lanzamientoL);
        add(lanzamientoText);
        add(boton);
        
        setVisible(true);
   }
   public void agregar(){
   
    String nombre = nombreText.getText();
    String SKU = SKUText.getText();

    // Convertir el texto a float para el campo de precio
    float precio = 0.0f;
    try {
        precio = Float.parseFloat(Precio.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido para el precio.");
        return;
    }

    // Convertir el texto a un objeto Date para el campo de lanzamiento
    Date lanzamiento = null;
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        lanzamiento = dateFormat.parse(lanzamientoText.getText());
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Ingrese una fecha válida en el formato dd-MM-yyyy para el lanzamiento.");
        return;
    }

    if (nombre.isEmpty() || SKU.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, llene los campos obligatorios.");
        return;
    }

    try (Connection connection = ConexionMariaDB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO catalogoj (SKU, Nombre, Precio, Lanzamiento) VALUES (?, ?, ?, ?)")) {

        preparedStatement.setString(1, SKU);
        preparedStatement.setString(2, nombre);
        preparedStatement.setFloat(3, precio);
        preparedStatement.setDate(4, new java.sql.Date(lanzamiento.getTime())); 

    // Ejecutar la consulta
    int filasAfectadas = preparedStatement.executeUpdate();
    if (filasAfectadas > 0) {
        JOptionPane.showMessageDialog(this, "Videojuego agregado exitosamente");
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo agregar el videojuego", "Error", JOptionPane.ERROR_MESSAGE);
    }

    } catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos del inventario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      } 
   }
}
