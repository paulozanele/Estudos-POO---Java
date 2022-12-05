import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Carros {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Carro> listaCarros = new ArrayList<Carro>(); // ArrayList listaCarros

	public static void leituraCarro() {
		try {
			FileReader arq = new FileReader("carros.txt");
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
				Double novaPotencia = Double.parseDouble(dadoSeparado[7]);
				int novoCilindrados = Integer.parseInt(dadoSeparado[8]);
				int novoQtdLugares = Integer.parseInt(dadoSeparado[9]);
				String novoTipo = dadoSeparado[10];
				Double novaAltura = Double.parseDouble(dadoSeparado[11]);
				Double novaLargura = Double.parseDouble(dadoSeparado[12]);
				Double novoComprimento = Double.parseDouble(dadoSeparado[13]);
				boolean novoVendido = Boolean.parseBoolean(dadoSeparado[14]);

				Carro novoCarro = new Carro();
				Data novaData = new Data();

				// Adiciona os parâmetros em novoCarro
				novoCarro.setN_chassi(novoChassi);
				novoCarro.setMarca(novaMarca);
				novoCarro.setModelo(novoModelo);
				novaData.setAno(novoAno);
				novoCarro.setKm(novaQuilometragem);
				novoCarro.setCombustivel(novoCombustivel);
				novoCarro.setPeso(novoPeso);
				novoCarro.setPotencia(novaPotencia);
				novoCarro.setCilindros(novoCilindrados);
				novoCarro.setN_lugares(novoQtdLugares);
				novoCarro.setTipo(novoTipo);
				novoCarro.setAltura(novaAltura);
				novoCarro.setLargura(novaLargura);
				novoCarro.setComprimento(novoComprimento);
				novoCarro.setVendido(novoVendido);
				novoCarro.setAno(novaData);

				// Adiciona no ArrayList listaCarros
				listaCarros.add(novoCarro);
			}
			leitor.close();

		} catch (IOException e) {

		}
	}
	
    public static void addCarro() {
        Carro carro = new Carro();;
        Data ano = new Data();;

        // Recebe os dados
        System.out.print("Digite chassi: ");
		carro.setN_chassi(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite marca: ");
		carro.setMarca(sc.nextLine());

        System.out.print("Digite modelo: ");
		carro.setModelo(sc.nextLine());

        System.out.print("Digite ano: ");
		ano.setAno(Integer.parseInt(sc.nextLine()));

        carro.setAno(ano);

        System.out.print("Digite quilometragem: ");
		carro.setKm(Double.parseDouble(sc.nextLine()));

        System.out.print("Digite tipo de combustivel: ");
		carro.setCombustivel(sc.nextLine());

        System.out.print("Digite peso: ");
		carro.setPeso(Double.parseDouble(sc.nextLine()));

        System.out.print("Digite potencia: ");
		carro.setPotencia(Double.parseDouble(sc.nextLine()));

        System.out.print("Digite numero de cilindros: ");
		carro.setCilindros(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite numero de lugares: ");
		carro.setN_lugares(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite tipo (utilt, pickup, sedan, hatch, esportivo): ");
		carro.setTipo(sc.nextLine());

        System.out.print("Digite altura: ");
		carro.setAltura(Double.parseDouble(sc.nextLine()));

        System.out.print("Digite largura: ");
		carro.setLargura(Double.parseDouble(sc.nextLine()));

        System.out.print("Digite comprimento: ");
		carro.setComprimento(Double.parseDouble(sc.nextLine()));

        carro.setVendido(false);

        // Adiciona na lista Carros
        listaCarros.add(carro);
        System.out.print("Carro cadastrado com sucesso.\n");
    }

    public static void salvaCarros() { 
		// Escreve listaCarros no arquivo "carros.txt", cada linha corresponde a um carro, separador " "
		
		Carro aux = new Carro();
		Data ano = new Data();

		// Salva os carros no arquivo
		String nomeArquivo = "carros.txt";
		try {
			File arq = new File(nomeArquivo);
			FileWriter escritor = new FileWriter(arq, false);
			for(int i = 0; i < listaCarros.size(); i++){
				aux = listaCarros.get(i);
				ano = aux.getAno();
				escritor.write(aux.getN_chassi() + " " + aux.getMarca() + " " + aux.getModelo() + " " +
				ano.getAno() + " " + aux.getKm() + " " + aux.getCombustivel() + " " + aux.getPeso() + " " +
				aux.getPotencia() + " " + aux.getCilindros() + " " + aux.getN_lugares() + " " + aux.getTipo() + " " +
				aux.getAltura() + " " + aux.getLargura() + " " + aux.getComprimento() + " " + aux.isVendido() + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
	}

    public static void imprimeCarros() { // Imprime listaCarros
		// Verifica lista
		if (listaCarros.isEmpty()) {
			System.out.print("Nao existem carros cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		} else {
			// Imprime lista Carros
			System.out.println(listaCarros.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

    public static void alteraKm() { // Altera quilometragem
		Carro aux1 = new Carro();
        double km;

		int chassi;
		System.out.print("Informe numero do chassi para alterar quilometragem: ");
		chassi = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < listaCarros.size(); i++) {
			aux1 = listaCarros.get(i);
			// Verifica se o chassi corresponde a algum carro presente na listaCarros
			if (chassi == aux1.getN_chassi()) {
				System.out.print("Digite nova quilometragem: ");
                km = Double.parseDouble(sc.nextLine());
                aux1.setKm(km);
			    System.out.print("Alteracao realizada com sucesso.\n");
			} else {
				System.out.print("O chassi nao corresponde a nenhum carro cadastrado.");
				break;
			}
		}
	}

    public static void dadosCarros() { // Menu para chamada dos métodos
		int op = 1;

		while (op != 0) {
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar carro");
			System.out.println("(2) Imprimir carros cadastrados");
			System.out.println("(3) Altera quilometragem");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
				case 1:
					addCarro();
					break;

				case 2:
					imprimeCarros();
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
