
package proyecto.pkgfinal;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ActualizarJuego extends JFrame {
    private JTextField SKUText;
    private JTextField nuevoNombreText;
    private JTextField nuevoPrecioText;
    private JTextField nuevaFechaText;
    private JButton botonActualizar;

    public ActualizarJuego() {
        setTitle("Actualizar Juego");
        setSize(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Componentes de la interfaz
        JLabel SKUL = new JLabel("SKU del videojuego a actualizar");
        SKUText = new JTextField();

        JLabel nuevoNombreL = new JLabel("Nuevo nombre del videojuego");
        nuevoNombreText = new JTextField();

        JLabel nuevoPrecioL = new JLabel("Nuevo precio del videojuego");
        nuevoPrecioText = new JTextField();

        JLabel nuevaFechaL = new JLabel("Nueva fecha de lanzamiento del videojuego");
        nuevaFechaText = new JTextField();

        botonActualizar = new JButton("Actualizar Videojuego");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });

        // Componentes de la ventana
        setLayout(new GridLayout(5, 2));
        add(SKUL);
        add(SKUText);
        add(nuevoNombreL);
        add(nuevoNombreText);
        add(nuevoPrecioL);
        add(nuevoPrecioText);
        add(nuevaFechaL);
        add(nuevaFechaText);
        add(botonActualizar);

        setVisible(true);
    }

    public void actualizar() {
    String SKU = SKUText.getText();
    String nuevoNombre = nuevoNombreText.getText();
    String nuevoPrecioStr = nuevoPrecioText.getText();
    String nuevaFechaStr = nuevaFechaText.getText();

    if (SKU.isEmpty() || nuevoNombre.isEmpty() || nuevoPrecioStr.isEmpty() || nuevaFechaStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos");
        return;
    }

    try (Connection connection = ConexionMariaDB.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "UPDATE catalogoj SET Nombre = ?, Precio = ?, Lanzamiento = ? WHERE SKU = ?")) {

        // Validar que el nuevo precio sea un valor numérico
        try {
            Float nuevoPrecio = Float.parseFloat(nuevoPrecioStr);
            preparedStatement.setString(1, nuevoNombre);
            preparedStatement.setFloat(2, nuevoPrecio);

            // Validar y convertir la nueva fecha al formato "aaaa-mm-dd"
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date parsedDate = dateFormat.parse(nuevaFechaStr);
            java.sql.Date nuevaFecha = new java.sql.Date(parsedDate.getTime());
            preparedStatement.setDate(3, nuevaFecha);

            preparedStatement.setString(4, SKU);

            // Ejecutar la consulta
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Videojuego actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró el videojuego con el SKU proporcionado");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el nuevo precio", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException | ParseException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos del inventario: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
}
