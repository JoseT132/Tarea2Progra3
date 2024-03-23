
package proyecto.pkgfinal;

import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarJuego extends JFrame{
    private JTextField SKUText;
    private JButton boton;
    
    public EliminarJuego() {
        setTitle("Eliminar Juego");
        setSize(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JLabel SKUL = new JLabel("SKU del videojuego a eliminar");
        SKUText = new JTextField();

        boton = new JButton("Eliminar Videojuego");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        });

        // Componentes de la ventana
        setLayout(new GridLayout(2, 2));
        add(SKUL);
        add(SKUText);
        add(boton);

        setVisible(true);
    }

    public void eliminar() {
        String SKU = SKUText.getText();

        if (SKU.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el SKU del videojuego a eliminar");
            return;
        }

        try (Connection connection = ConexionMariaDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM catalogoj WHERE SKU = ?")) {

            preparedStatement.setString(1, SKU);

            // Ejecutar la consulta
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Videojuego eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el videojuego con el SKU proporcionado");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos del inventario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
