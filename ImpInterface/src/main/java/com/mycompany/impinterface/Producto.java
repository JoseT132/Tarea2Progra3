
package com.mycompany.impinterface;

import java.util.*;

public class Producto {
    
   private String nombre;
   private Date F_caducidad;
   private String coProducto;

    public String getCoProducto() {
        return coProducto;
    }

    public void setCoProducto(String coProducto) {
        this.coProducto = coProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getF_caducidad() {
        return F_caducidad;
    }

    public void setF_caducidad(Date F_caducidad) {
        this.F_caducidad = F_caducidad;
    }

 }

