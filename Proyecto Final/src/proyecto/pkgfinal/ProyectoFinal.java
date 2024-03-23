
package proyecto.pkgfinal;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class ProyectoFinal{

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MiVentana miVentana = new MiVentana();
            miVentana.setVisible(true);
        });
    }

    public static class MiVentana extends JFrame {

        public MiVentana() {
            setTitle ("Administracion de Videojuegos ");
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400,300);
            JLabel texto1= new JLabel ("Seleccione la opcion que desea realizar");
            
            
            JButton agregarButton = new JButton("Agregar Juego");
            JButton eliminarButton = new JButton("Eliminar Juego");
            JButton actualizarButton = new JButton("Actualizar Juego");

            agregarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AgregarJuego();
                }
            });

            eliminarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new EliminarJuego();
                }
            });

            actualizarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ActualizarJuego();
                }
            });

            JPanel panel = new JPanel();
            panel.add(texto1);
            panel.add(agregarButton);
            panel.add(eliminarButton);
            panel.add(actualizarButton);

            add(panel);

            setVisible(true);
        }
    }
}