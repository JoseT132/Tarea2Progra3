
package grafica;

import javax.swing.*;
import java.awt.*;
public class Grafica extends JFrame {

    private Container panel;
    private JButton miboton;
    public static void main(String[] args) {
       
        Grafica v= new Grafica();
    }
  public Grafica (){
      super("Bienvenido");
      panel=getContentPane();
      miboton= new JButton("aceptar");
      panel.add(miboton);
      setLayout (new BorderLayout(5,10));
      
      setSize(200,200);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
}
