
package com.mycompany.impinterface;

import java.util.*;

public class Factura implements MetPago {
    private String noFac;
    private Date femision;
    private float totalcancelar;

    public String getNoFac() {
        return noFac;
    }

    public void setNoFac(String noFac) {
        this.noFac = noFac;
    }

    public Date getFemision() {
        return femision;
    }

    public void setFemision(Date femision) {
        this.femision = femision;
    }

    public float getTotalcancelar() {
        return totalcancelar;
    }

    public void setTotalcancelar(float totalcancelar) {
        this.totalcancelar = totalcancelar;
    }
    
    public void pTarjeta (){

        Scanner dato= new Scanner (System.in);
        System.out.println ("Ingrese el numero de tarjeta ");
        String noTarjeta;
        noTarjeta=dato.nextLine();
        System.out.println("Pago realizado exitosamente");
        
       
    }

    @Override
    public void pEfectivo() {
        Scanner dato= new Scanner (System.in);
        System.out.println ("Ingrese la cantidad a pagar ");
        float Cpaga;
        Cpaga= dato.nextFloat();
        float cambio=0;
        System.out.println("Su cambio es:"+cambio);
        System.out.println("Transacción realizada con exito");
        
    }
}
