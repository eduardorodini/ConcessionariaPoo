import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Concessionaria {
	private ArrayList<Veiculos> veiculos;

	public Concessionaria() {
		this.veiculos = new ArrayList<Veiculos>();
	}
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

public Moto leMoto (){

    String [] valores = new String [5];
    String [] nomeVal = {"Cor", "Ano", "Preco", "Montadora", "Modelo", "Cc"};
    valores = leValores (nomeVal);

    int ano = this.retornaInteiro(valores[1]);
    int preco = this.retornaInteiro(valores[2]);
    int cc = this.retornaInteiro(valores[5]);

    Moto moto = new Moto (valores[0], ano, preco, valores[3], valores[4], cc);
    return moto;
}

public Carro leCarro (){

    String [] valores = new String [5];
    String [] nomeVal = {"Cor", "Ano", "Preco", "Montadora", "Modelo", "Cavalos", "Lugares"};
    valores = leValores (nomeVal);

    int ano = this.retornaInteiro(valores[1]);
    int preco = this.retornaInteiro(valores[2]);
    int hp = this.retornaInteiro(valores[5]);
    int lugares = this.retornaInteiro(valores[6]);

    Carro carro = new Carro (valores[0], ano, preco, valores[3], valores[4], hp, lugares);
    return carro;
}

public Caminhao leCaminhao (){

    String [] valores = new String [5];
    String [] nomeVal = {"Cor", "Ano", "Preco", "Montadora", "Modelo", "Cavalos"};
    valores = leValores (nomeVal);

    int ano = this.retornaInteiro(valores[1]);
    int preco = this.retornaInteiro(valores[2]);
    int hp = this.retornaInteiro(valores[5]);

    Caminhao caminhao = new Caminhao (valores[0], ano, preco, valores[3], valores[4], hp);
    return caminhao;
}

private boolean intValido(String s) {
    try {
        Integer.parseInt(s); 
        return true;
    } catch (NumberFormatException e) { 
        return false;
    }
}

public int retornaInteiro(String entrada) { 

    while (!this.intValido(entrada)) {
        entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um numero inteiro.");
    }
    return Integer.parseInt(entrada);
}

public void salvaVeiculos (ArrayList<Veiculos> veiculos){
    ObjectOutputStream outputStream = null;
    try {
        outputStream = new ObjectOutputStream 
                (new FileOutputStream("c:\\temp\\Concessionaria.dados"));
        for (int i=0; i < veiculos.size(); i++)
            outputStream.writeObject(veiculos.get(i));
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null,"Impossivel criar arquivo!");
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally { 
        try {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

public ArrayList<Veiculos> recuperaVeiculos (){
    ArrayList<Veiculos> VeiculosTemp = new ArrayList<Veiculos>();

    ObjectInputStream inputStream = null;

    try {	
        inputStream = new ObjectInputStream
                (new FileInputStream("C:\\Windows\\Temp\\concessionaria.dados"));
        Object obj = null;
        while ((obj = inputStream.readObject()) != null) {
            if (obj instanceof Veiculos) {
                VeiculosTemp.add((Veiculos) obj);
            }   
        }          
    } catch (EOFException ex) { 
        System.out.println("Fim de arquivo");
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } catch (FileNotFoundException ex) {
        JOptionPane.showMessageDialog(null,
                            "===================================           \n" +
                            "       O arquivo com veiculos nao existe!\n" + 
                            "===================================\n");
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
        return VeiculosTemp;
}

public void menuConcessionaria (){

    String menu = "";
    String entrada;
    int    opc1, opc2;

    do {
        menu = "Controle Concessionaria\n" +
                "Opcoes:\n" + 
                "1. Entrar Veiculos\n" +
                "2. Exibir Veiculos\n" +
                "3. Limpar Veiculos\n" +
                "4. Gravar Veiculos\n" +
                "5. Recuperar Veiculos\n" +
                "9. Sair";
        entrada = JOptionPane.showInputDialog (menu + "\n\n");
        opc1 = this.retornaInteiro(entrada);

        switch (opc1) {
        case 1:
            menu = "Entrada de Veiculos\n" +
                    "Opcoes:\n" + 
                    "1. Moto\n" +
                    "2. Carro\n" +
                    "3. Caminhao\n";

            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            opc2 = this.retornaInteiro(entrada);

            switch (opc2){
            case 1: veiculos.add((Veiculos)leMoto());
            break;
            case 2: veiculos.add((Veiculos)leCarro());
            break;
            case 3: veiculos.add((Veiculos)leCaminhao());
            break;
            default: 
                JOptionPane.showMessageDialog(null,"Veiculo para entrada NAO escolhido!");
            }

            break;
        case 2: 
            if (veiculos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Entre com veiculos primeiramente");
                break;
            }
            String dados = "";
            for (int i=0; i < veiculos.size(); i++)	{
                dados += veiculos.get(i).toString() + "---------------\n";
            }
            JOptionPane.showMessageDialog(null,dados);
            break;
        case 3: 
            if (veiculos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Entre com veiculos primeiramente");
                break;
            }
            veiculos.clear();
            JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
            break;
        case 4:
            if (veiculos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Entre com veiculos primeiramente");
                break;
            }
            salvaVeiculos(veiculos);
            JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
            break;
        case 5:
            veiculos = recuperaVeiculos();
            if (veiculos.size() == 0) {
                JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                break;
            }
            JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
            break;
        case 9:
            JOptionPane.showMessageDialog(null,"Fim do aplicativo Concessionaria");
            break;
        }
    } while (opc1 != 9);
}

public static void main (String [] args){

    Concessionaria pet = new Concessionaria ();
    pet.menuConcessionaria();

}
}
