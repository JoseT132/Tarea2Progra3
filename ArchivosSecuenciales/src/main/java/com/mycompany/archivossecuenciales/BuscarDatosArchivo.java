
package com.mycompany.archivossecuenciales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuscarDatosArchivo {
    try {
    file f = new file ("Datos.txt");
    if(f.exist()){
    FileReader fr= new FileReader (f);
    BufferedReader br= new BufferedReader (fr);
    String linea;
    Boolean bln Encontrado=false;
    While((linea=br.readLine())!=null){
        String [] arreglo=linea.split("%");
        if(arreglo [0].equalsIgnoreCase());
        Persona persona = new  persona (arreglo[0], arreglo [1],arreglo [2],arreglo [3],arreglo [4],arreglo [5]);
             System.out.println("Persona encontrada");
             br.close();
             fr.close();
      }
    }else {
        if(bln Encontrado){
        System.out.println("No existe coincidencia");
    }
    }
  }catch (IOException e){
            System.out.println("Error de E/S"+e);
      }
  public void main (String []args){
      Archivo archivo=new Archivo ();
      Scanner entrada= new Scanner (System.in);
      int salida=0;
      int opcion=0;
      while (salida !=1){
          
      }
  }
  public static void menu (){
      System.out.println("Menu de manejo de archivos de texto");
      System.out.println("1.Ingreso de Personas");
      System.out.println("2. Mostrar datos del archivo");
      System.out.println("3. Buscar nombre y apellido");
      
      switch (opcion){
          case 1:
              System.out.println("Ingrese el primer nombre");
              entrada.nextln();
              break;
          case 2:
              archivo.MostrarDatosArchivos
              break;
          case 3:
                  System.out.println("Ingrese el primer nombre a busar ");
                  String Primernom=entrada.nextline();
                  System.out.println("Ingrese el primer apellido a busar ");
                  String primerApe=entrada.nextline();
                  archivo.buscarEnArchivo(Primernom, PrimerApe);
      }
  }
}
