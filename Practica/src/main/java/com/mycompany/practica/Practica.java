

package com.mycompany.practica;
import java.io.*;

public class Practica {

    public static void main(String[] args) {
        
      File f;
      f = new File ("Texto.txt");
    
      try {
      
      if(f.createNewFile()){
          System.out.println("Se ha creado un archivo ");
      }
      
      }catch(Exception e){
          System.out.println("Error de E/S"+e);
          
      }
    }
  public static void escribirArchivo(Persona persona){
     try {
         File f =new File ("Texto.txt");
         if(f.exists()&&(f.length()!=0)){
             FileWriter fw= new FileWriter (f);
             BufferedWriter bw= new BufferedWriter (fw);
             bw.newLine();
             bw.write("%");
             bw.write(persona.Getprimernombre());
             bw.write("%");
             bw.write(persona.Getsegundonombre());
             bw.write("%");
             bw.write(persona.Getprimerapellido());
             bw.write("%");
             bw.write(persona.Getsegundoapellido());
             bw.write("%");
             bw.write(persona.GetCUI());
             bw.write("%");
             bw.write(persona.Getnumerotelefono());
             bw.write("%");
             
             bw.close();
             fw.close();
         }else {
             FileWriter fw =new FileWriter (f,true);
         }
     }catch (Exception e){
         System.out.println("Error de E/S"+e);
         
     }   
  }
  public void MostrarDatos(Persona persona){
      try{
         File f= new File ("Texto.txt");
         FileReader fr= new FileReader(f);
         BufferedReader br= new BufferedReader (fr);
         String linea;
         while ((linea=br.readLine())!=null){
             String []arreglo=linea.split("%");
    
             System.out.println(persona.toString());
         }
      }catch(Exception e){
       System.out.println("Error de E/S"+e);
      }
  }  
  public void buscarDatosArchivos ( String nombreBuscar){
      try{
          
      }catch(Exception e){
          System.out.println();
      }
  }
}




