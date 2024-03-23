
public class Materiales {
   
    private double lb_clavos;
    private double pies_Madera;
    private int ml_barniz;
    private int ml_pegamento;

    public Materiales(double lb_clavos, double pies_Madera, int ml_barniz, int ml_pegamento){
        this.lb_clavos=lb_clavos;
        this.pies_Madera=pies_Madera;
        this.ml_barniz=ml_barniz;
        this.ml_pegamento=ml_pegamento;
                
    }

    public double getLb_clavos() {
        return lb_clavos;
    }

    public void setLb_clavos(double lb_clavos) {
        this.lb_clavos = lb_clavos;
    }

    public double getPies_Madera() {
        return pies_Madera;
    }

    public void setPies_Madera(double pies_Madera) {
        this.pies_Madera = pies_Madera;
    }

    public int getMl_barniz() {
        return ml_barniz;
    }

    public void setMl_barniz(int ml_barniz) {
        this.ml_barniz = ml_barniz;
    }

    public int getMl_pegamento() {
        return ml_pegamento;
    }

    public void setMl_pegamento(int ml_pegamento) {
        this.ml_pegamento = ml_pegamento;
    }
}

