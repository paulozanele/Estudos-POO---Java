import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Motocicletas {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Motocicleta> listaMotos = new ArrayList<Motocicleta>(); // ArrayList listaMotos

	public static void leituraMotocicleta() {
		try {
			FileReader arq = new FileReader("motos.txt");
			BufferedReader leitor = new BufferedReader(arq);
			while (leitor.ready()) {
				String linha = leitor.readLine();
				String[] dadoSeparado = linha.split(" ");

				// Lê os dados do arquivo
				int novoChassi = Integer.parseInt(dadoSeparado[0]);
				String novaMarca = dadoSeparado[1];
				String novoModelo = dadoSeparado[2];
				int novoAno = Integer.parseInt(dadoSeparado[3]);
				Double novaQuilometragem = Double.parseDouble(dadoSeparado[4]);
				String novoCombustivel = dadoSeparado[5];
				Double novoPeso = Double.parseDouble(dadoSeparado[6]);
				int novaCilindrada = Integer.parseInt(dadoSeparado[7]);
				String novoTipo = dadoSeparado[8];
				boolean novoVendido = Boolean.parseBoolean(dadoSeparado[9]);

				Motocicleta novaMoto = new Motocicleta();
				Data novaData = new Data();

				// Adiciona os parâmetros em novaMoto
				novaMoto.setN_chassi(novoChassi);
				novaMoto.setMarca(novaMarca);
				novaMoto.setModelo(novoModelo);
				novaData.setAno(novoAno);
				novaMoto.setKm(novaQuilometragem);
				novaMoto.setCombustivel(novoCombustivel);
				novaMoto.setPeso(novoPeso);
				novaMoto.setCilindradas(novaCilindrada);
				novaMoto.setTipo(novoTipo);
				novaMoto.setVendido(novoVendido);
				novaMoto.setAno(novaData);

				// Adiciona no ArrayList listaMotos
				listaMotos.add(novaMoto);
			}
			leitor.close();

		} catch (IOException e) {

		}
	}

    public static void addMoto() {
        Motocicleta moto = new Motocicleta();;
        Data ano = new Data();;

        // Recebe os dados
        System.out.print("Digite chassi: ");
		moto.setN_chassi(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite marca: ");
		moto.setMarca(sc.nextLine());

        System.out.print("Digite modelo: ");
		moto.setModelo(sc.nextLine());

        System.out.print("Digite ano: ");
		ano.setAno(Integer.parseInt(sc.nextLine()));

        moto.setAno(ano);

        System.out.print("Digite quilometragem: ");
		moto.setKm(Double.parseDouble(sc.nextLine()));

        System.out.print("Digite tipo de combustivel: ");
		moto.setCombustivel(sc.nextLine());

        System.out.print("Digite peso: ");
		moto.setPeso(Double.parseDouble(sc.nextLine()));

        System.out.print("Digite cilindradas: ");
		moto.setCilindradas(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite tipo (trail, street, esport, custom): ");
		moto.setTipo(sc.nextLine());

        moto.setVendido(false);

        listaMotos.add(moto);
        System.out.print("Moto cadastrada com sucesso.\n");
    }

    public static void salvaMotos() {
		// Excreve listaMotos no arquivo "motos.txt", cada linha corresponde a uma moto, separador " "

		Motocicleta aux = new Motocicleta();
		Data ano = new Data();

		// Salva o Motos no arquivo
		String nomeArquivo = "motos.txt";
		try {
			File arq = new File(nomeArquivo);
			FileWriter escritor = new FileWriter(arq, false);
			for(int i = 0; i < listaMotos.size(); i++){
				aux = listaMotos.get(i);
				ano = aux.getAno();
				escritor.write(aux.getN_chassi() + " " + aux.getMarca() + " " + aux.getModelo() + " " +
				ano.getAno() + " " + aux.getKm() + " " + aux.getCombustivel() + " " + aux.getPeso() + " " +
				aux.getCilindradas() + " " + aux.getTipo() + " " + aux.isVendido() + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
	}

    public static void imprimeMotos() { // Imprime listaMotos
		// Verifica lista
		if (listaMotos.isEmpty()) {
			System.out.print("Nao existem motos cadastradas, pressione uma tecla para continuar!");
			sc.nextLine();
		} else {
			// Imprime lista Motos
			System.out.println(listaMotos.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

    public static void alteraKm() { // Altera quilometragem
		Motocicleta aux1 = new Motocicleta();
        double km;

		int chassi;
		System.out.print("Informe n chassi para alterar quilometragem: ");
		chassi = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < listaMotos.size(); i++) {
			aux1 = listaMotos.get(i);
			// Verifica se o chassi corresponde a alguma moto presente na listaMotos
			if (chassi == aux1.getN_chassi()) { // Verificar sintaxe
				System.out.print("Digite nova quilometragem: ");
                km = Double.parseDouble(sc.nextLine());
                aux1.setKm(km);
			    System.out.print("Alteracao realizada com sucesso.\n");
			} else {
				System.out.print("O chassi nao corresponde a nenhuma moto cadastrada.");
				break;
			}
		}
	}

    public static void dadosMotos() { // Menu para a chamada dos métodos
		int op = 1;

		while (op != 0) {
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar moto");
			System.out.println("(2) Imprimir motos cadastradas");
			System.out.println("(3) Altera quilometragem");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
				case 1:
					addMoto();
					break;

				case 2:
					imprimeMotos();
					break;

				case 3:
					alteraKm();
					break;

				case 0:
					break;

				default:
					System.out.print("Opcao invalida! Pressione uma tecla para continuar.");
					sc.nextLine();
					break;
			}
		}
	}
}
