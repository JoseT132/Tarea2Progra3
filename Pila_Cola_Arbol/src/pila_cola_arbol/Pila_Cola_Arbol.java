
package pila_cola_arbol;
import java.util.Stack;
import java.util.*;
//Desarrollo del menu 
public class Pila_Cola_Arbol {

    public static void main(String[] args) {
     //Instanciar clase piala 
     Pila pila= new Pila ();
 
        
        
        //Pido la seleccion al usuario
    System.out.println("Seleccione una opcion");
    System.out.println("1. Pilas");
    //tres opciones por metodo 
    System.out.println("2. Colas");
      //tres opciones por metodo
    System.out.println("3. Arbol Binario");
      //tres opciones por metodo
    // Creo un scanner que almacene la seleccion
    Scanner seleccion= new Scanner (System.in);
    int opcion=seleccion.nextInt();
    //creacion del objeto pilas
  
    switch (opcion){
        case 1: 
            // Menu de Pilas
            System.out.println("Seleccione una opcion");
            System.out.println("1.Realizar una busqueda en la Pila");
            System.out.println ("2.Agregar contenido a la Pila");
            System.out.println("3.Eliminar contenido de la Pila");
            //Leer opcion de las pilas 
            int opcionP= seleccion.nextInt();
            //nuevo switch
            switch(opcionP){
                case 1:
                pila.buscarValor();
                break;
                case 2:   
                pila.agregarElemento();
                break;
                case 3:
                pila.buscarValor();
                break;
                default:
            System.out.println("Opcion no valida");        
                            
        }
        break;
        //Menu de las Colas 
        case 2:
            System.out.println("Seleccione una opcion");
            System.out.println("1.Realizar una busqueda en la Cola");
            System.out.println ("2.Agregar contenido a la Cola");
            System.out.println("3.Eliminar contenido de la Cola");
            
            //Leer opcion de las Colas 
            int opcionC= seleccion.nextInt();
            //nuevo switch
            switch(opcionC){
                //agregar clase al switch
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                default:
            System.out.println("Opcion no valida");        
            }                
        break;
        case 3:
            //Seleccion del recorrido del arbol 
            System.out.println("Seleccione una opcion");
            System.out.println("Realizar un recorrido Pre Orden");
            System.out.println ("Realizar un recorrido In Orden");
            System.out.println("Realizr un recorrido Post orden");
        break;
        default:
            System.out.println("Opcion no valida");
    }
    }


}
