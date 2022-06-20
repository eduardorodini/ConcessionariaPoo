public class Moto extends Veiculos { 
    private static final long serialVersionUID = 1L;
    private int cc;

public Moto(String cor, int ano, int preco, String montadora, String modelo, int cc){
    super(cor, ano, preco, montadora, modelo);
    this.tipoV = "Moto";
    this.cc = cc;
}

    @Override
    public String toString() {
    return  "\n=======" + this.tipoV + "=======" + 
            "\nCor: " + this.cor + 
            "\nAno: " + this.ano + 
            "\nPreco: " + this.preco +
            "\nMontadora: " + this.montadora +
            "\nModelo: " + this.modelo +
            "\nCilindradas: " + this.cc;
    }
    

public void setCc(int cc){
this.cc = cc;
}
public int getCc(){
    return cc;
}

}


