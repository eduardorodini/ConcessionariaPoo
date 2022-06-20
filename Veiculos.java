import java.io.Serializable;

public abstract class Veiculos implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String cor;
	protected int ano;
	protected int preco;
	protected String montadora;
	protected String modelo;
	protected String tipoV;

	public Veiculos(String cor, int ano, int preco, String montadora, String modelo) {
		this.cor = cor;
		this.ano = ano;
		this.preco = preco;
		this.montadora = montadora;
		this.modelo = modelo;
	}
	
	public String getNome() {
		return modelo;
	}
	
	
}
