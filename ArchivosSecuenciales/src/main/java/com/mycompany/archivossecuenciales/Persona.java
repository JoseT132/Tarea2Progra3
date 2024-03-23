
package com.mycompany.archivossecuenciales;
import java.io.*;
import java.util.*;

public class Persona {
    //Atributos
   private String pimernombre;
   private String segundonombre;
   private String pimerapellido;
   private String segundoapellido;
   private String CUI;
   private  String numerotelefono;
    //Metodos
   public void setPersona (String primernombre, String segundonombre, String primerapellido, String segundoapellido,
           String CUI, String numerotelefono){
       this.pimernombre=primernombre;
       this.segundonombre=segundonombre;
       this.pimerapellido=primerapellido;
       this.segundoapellido=segundoapellido;
       this.CUI=CUI;
       this.numerotelefono=numerotelefono;      
   }
   public String GetprimerNombre(){
   return pimernombre;
 }
   public String GetsegundoNombre(){
   return segundonombre;
   }
   public String GetpimerApellido(){
       return pimerapellido;
   }
   public String GetsegundoApellido(){
     return segundoapellido;
   }
   public String GetCui(){
       return CUI;
   }
   public String GetnumeroTelefono(){
       return numerotelefono;
   
   }
   public String toString(){
       return "Persona [Primer Nombre"+pimernombre+"Segundo Nombre"+segundonombre+"Primer Apellido"+
               pimerapellido+"Segundo Apellido"+segundoapellido+"CUI"+CUI+"Numero de Telefono"+numerotelefono+"]";
   }
  }
     
     

