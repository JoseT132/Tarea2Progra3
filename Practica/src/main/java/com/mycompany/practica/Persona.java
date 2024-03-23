
package com.mycompany.practica;

import java.util.*;

public class Persona {
    private String primernombre;
    private String segundonombre;
    private String primerapellido;
    private String segundoapellido;
    private String CUI;
    private String numerotelefono;
    
  
    public String Getprimernombre(){
        return primernombre;
    }
    public String Getsegundonombre(){
        return segundonombre;
    }
    public String Getprimerapellido(){
        return primerapellido;
    }
    public String Getsegundoapellido(){
        return segundoapellido;
       
    }
    public String GetCUI(){
        return CUI;
    }
    public String Getnumerotelefono(){
        return numerotelefono;
    }
    public void Setprimernombre(){
        this.primernombre = primernombre;
    }
    public void Setsegundonombre(){
        this.segundonombre = segundonombre;
    }
    public void Setprimerapellido(){
        this.primerapellido= primerapellido;
    }
    public void Setsegundoapellido(){
        this.segundoapellido=segundoapellido;
    }
    public void SetCUI(){
        this.CUI= CUI;
    }
    public void Setnumerotelefono(){
        this.numerotelefono=numerotelefono;
    }
    public String toString(){
        return "Persona [Primer Nombre"+primernombre+"Segundo Nombre"+segundonombre+"Primer Apellido"+primerapellido+"Segundo"
                + "Apellido"+segundoapellido+"CUI"+CUI+"No. telefono"+numerotelefono+"]";
    }
  }
