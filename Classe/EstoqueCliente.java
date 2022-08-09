package Classe;

public class EstoqueCliente {
    String medicamentOriginal;
    String medicamentGeneric;
    int id;
    double valor;

    public EstoqueCliente(String medicamentOriginal, String medicamentGeneric, int id, double valor) {
        this.medicamentOriginal = medicamentOriginal;
        this.medicamentGeneric = medicamentGeneric;
        this.id = id;
        this.valor = valor;
    }

    public String getMedicamentOriginal(){
        return medicamentOriginal;
    }

    public String getMedicamentGeneric(){
        return medicamentGeneric;
    }

    public int getId(){
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setMedicamentOriginal(String medicamentOriginal){
        this.medicamentOriginal = medicamentOriginal;
    }

    public void setMedicamentGeneric(String medicamentGeneric){
        this.medicamentGeneric = medicamentGeneric;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void descontomedicamentGeneric (double perc) {
        this.valor += this.valor * perc/100;
    }
}

