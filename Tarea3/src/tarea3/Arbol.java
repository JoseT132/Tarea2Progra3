
package tarea3;
import java.util.*;

public class Arbol {
   NodoA root;
   int t;
   
   // constructor
   public Arbol (int t){
       this.t =t;
       root= new Arbol(t);
   }
}
