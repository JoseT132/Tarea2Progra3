
package com.mycompany.archivossecuenciales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MostrarDatosArchivos {
    public void mostrarDatosArchivo(){
        try{
            File f= new File ("Datos.txt");
            FileReader fr=new FileReader (f);
            BufferedReader br= new BufferedReader (br);
            String linea;
            while((linea=br.readLine())!=null){
             String [] arreglo = linea.split("%");
             Persona persona = new  persona (arreglo[0], arreglo [1],arreglo [2],arreglo [3],arreglo [4],arreglo [5]);
             System.out.println(persona.toString());
            }
             br.close();
             fr.close();
        }catch (IOException e){
            System.out.println("Error de E/S"+e);
           }
    } 
}
