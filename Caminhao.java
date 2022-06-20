public class Caminhao extends Veiculos { 
    private static final long serialVersionUID = 1L;
    private int hp;
public Caminhao(String cor, int ano, int preco, String montadora, String modelo, int hp){
    super(cor, ano, preco, montadora, modelo);
    this.tipoV = "Caminhao";
    this.hp = hp;
}

@Override
public String toString() {
return  "\n=======" + this.tipoV + "=======" + 
        "\nCor: " + this.cor + 
        "\nAno: " + this.ano + 
        "\nPreco: " + this.preco +
        "\nMontadora: " + this.montadora +
        "\nModelo: " + this.modelo +
        "\nCavalos: " + this.hp;
}
public void setHp(int hp){
    this.hp = hp;
}
public int getHp(){
    return hp;
}

}
