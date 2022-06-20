public class Carro extends Veiculos { 
    private static final long serialVersionUID = 1L;
    private int hp;
    private int lugares;

public Carro(String cor, int ano, int preco, String montadora, String modelo, int hp, int lugares){
    super(cor, ano, preco, montadora, modelo);
    this.tipoV = "Carro";
}

@Override
public String toString() {
return  "\n=======" + this.tipoV + "=======" + 
        "\nCor: " + this.cor + 
        "\nAno: " + this.ano + 
        "\nPreco: " + this.preco +
        "\nMontadora: " + this.montadora +
        "\nModelo: " + this.modelo +
        "\nCavalos: " + this.hp +
        "\nLugares: " + this.lugares;
}

public void setHp(int hp){
    this.hp = hp;
}
public int getHp(){
    return hp;
}

public void setLugares(int lugares){
    this.lugares = lugares;
}
public int getLugares(){
    return lugares;
}

}