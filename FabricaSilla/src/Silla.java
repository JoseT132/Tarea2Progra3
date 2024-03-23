
public class Silla {
   
    private String material;
    private int cantidadS;
    private String estado;
    
    public Silla ( String material, int cantidadS, String estado){
        this.material= material;
        this.cantidadS=cantidadS;
        this.estado=estado;
        
    }

    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado= estado;
    }
    
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCantidadS() {
        return cantidadS;
    }

    public void setCantidadS(int cantidadS) {
        this.cantidadS = cantidadS;
    }

  
}
