
package com.mycompany.archivossecuenciales;


import java.io.*;
public class Archivo {
   
    public void escribirArchivo(Persona persona){

        try {
          File f = new File ("Datos.txt");
          if(f.exists()&&f.length()!=0){
          FileWriter fw= new FileWriter(f);
          BufferedWriter bw =new BufferedWriter (fw);
          bw.newLine();
          bw.write(persona.GetprimerNombre());
          bw.write("%");
          bw.write(persona.GetsegundoNombre());
          bw.write("%");
          bw.write(persona.GetpimerApellido());
          bw.write("%");
          bw.write(persona.GetsegundoApellido());
          bw.write("%");
          bw.write(persona.GetCui());
          bw.write("%");
          bw.write(persona.GetnumeroTelefono());
          bw.write("%");
          
          bw.close();
          fw.close();
          System.out.println("Registro Ingresado");
          }
        }catch (Exception e){
            System.out.println("Error de E/S"+e);
            
        }
    }
    
}
