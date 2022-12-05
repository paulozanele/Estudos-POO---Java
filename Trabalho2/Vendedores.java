import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Vendedores {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Vendedor> listaVendedores = new ArrayList<Vendedor>(); // ArrayList listaVendedores

	public static void leituraVendedor() {
		try {
			FileReader arq = new FileReader("vendedores.txt");
			BufferedReader leitor = new BufferedReader(arq);
			while (leitor.ready()) {
				String linha = leitor.readLine();
				String[] dadoSeparado = linha.split(" ");

				// Lê os dados do arquivo
				String novoRG = dadoSeparado[0];
				String novoNome = dadoSeparado[1];
				int novaDataNasDia = Integer.parseInt(dadoSeparado[2]);
				int novaDataNasMes = Integer.parseInt(dadoSeparado[3]);
				int novaDataNasAno = Integer.parseInt(dadoSeparado[4]);
				int novaDataAdmiDia = Integer.parseInt(dadoSeparado[5]);
				int novaDataAdmiMes = Integer.parseInt(dadoSeparado[6]);
				int novaDataAdmiAno = Integer.parseInt(dadoSeparado[7]);
				double novoSalario = Double.parseDouble(dadoSeparado[8]);
				int novoTempoTreinRest = Integer.parseInt(dadoSeparado[9]);

				Vendedor novoVendedor = new Vendedor();
				Data novaDataNas = new Data();
				Data novaDataAdmi = new Data();

				// Adiciona os parâmetros em novoVendedor
				novoVendedor.setRG(novoRG);
				novoVendedor.setNome(novoNome);
				novaDataNas.setDia(novaDataNasDia);
				novaDataNas.setMes(novaDataNasMes);
				novaDataNas.setAno(novaDataNasAno);
				novaDataAdmi.setDia(novaDataAdmiDia);
				novaDataAdmi.setMes(novaDataAdmiMes);
				novaDataAdmi.setAno(novaDataAdmiAno);
				novoVendedor.setTempo_trein_rest(novoTempoTreinRest);
				novoVendedor.setSalario(novoSalario);
				novoVendedor.setData_nasc(novaDataNas);
				novoVendedor.setData_adm(novaDataAdmi);

				// Adiciona no ArrayList listaVendedores
				listaVendedores.add(novoVendedor);
			}
			leitor.close();

		} catch (IOException e) {

		}
	}

	public static void addVendedor(){
		Vendedor vendedor;
		Data data_nasc, data_adm;

		// Inicializa objetos
		vendedor = new Vendedor();
		data_nasc = new Data();
        data_adm = new Data();
		
		// Recebe os dados
		System.out.print("Digite RG: ");
		vendedor.setRG(sc.nextLine());
		
		System.out.print("Digite nome: ");
		vendedor.setNome(sc.nextLine());
		
		System.out.print("Digite data de nascimento - dia: ");
		data_nasc.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - mes: ");
		data_nasc.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - ano: ");
		data_nasc.setAno(Integer.parseInt(sc.nextLine()));

		vendedor.setData_nasc(data_nasc);

		System.out.print("Digite data de admissao - dia: ");
		data_adm.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - mes: ");
		data_adm.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - ano: ");
		data_adm.setAno(Integer.parseInt(sc.nextLine()));

		vendedor.setData_adm(data_adm);

		System.out.print("Digite tempo de treinamento restante (dias): ");
		vendedor.setTempo_trein_rest(Integer.parseInt(sc.nextLine()));

		addGerente(vendedor);

		// Adiciona Vendedor na lista Vendedores
		listaVendedores.add(vendedor);

		System.out.print("Vendedor cadastrado com sucesso.\n");
	}

    public static Vendedor addGerente(Vendedor vendedor){
		// Verifica se o gerente é válido e associa ao vendedor como responsável

        int i;
        Gerente aux1, aux2;
        Vendedor novo = vendedor;

        // Inicializa objetos
        aux1 = new Gerente();

        System.out.print("Digite RG do gerente:");
        aux1.setRG(sc.nextLine());

        for(i=0; i<Gerentes.listaGerentes.size(); i++){
            aux2 = Gerentes.listaGerentes.get(i);
            if(aux1.getRG().equals(aux2.getRG())){
                novo.setResp(aux2);
                System.out.print("Gerente associado com sucesso.\n");
            }	
        }
		System.out.print("\nErro: RG inválido.\n");
        return null;
    }

	public static void salvaVendedores() {
		// Escreve listaVendedores no arquivo "vendedores.txt", cada linha corresponde a um vendedor, separador " "

		Vendedor aux = new Vendedor();
		Data data_nasc = new Data();
		Data data_adm = new Data();

		// Salva os vendedores no arquivo
		String nomeArquivo = "vendedores.txt";
		try {
			File arq = new File(nomeArquivo);
			FileWriter escritor = new FileWriter(arq, false);
			for(int i = 0; i < listaVendedores.size(); i++){
				aux = listaVendedores.get(i);
				data_nasc = aux.getData_nasc();
				data_adm = aux.getData_adm();
				escritor.write(aux.getRG() + " " + 
				aux.getNome() + " " + 
				data_nasc.getDia() + " " + data_nasc.getMes() + " " + data_nasc.getAno() + " " +
				data_adm.getDia() + " " + data_adm.getMes() + " " + data_adm.getAno() + " " +
				aux.getSalario() + " " + aux.getTempo_trein_rest() + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
	}

	public static void alteraSalario() { // Altera o salário
		Vendedor aux1 = new Vendedor();

		String verifica;
		System.out.print("Informe o RG do vendedor para alteracao: ");
		verifica = sc.nextLine();
		for (int i = 0; i < listaVendedores.size(); i++) {
			aux1 = listaVendedores.get(i);
			// Verifica se o RG corresponde a algum vendedor presente na lista de vendedores
			if (verifica.equals(aux1.getRG())) { // Verificar sintaxe
				System.out.print("Digite novo salario: ");
				aux1.setSalario(Double.parseDouble(sc.nextLine()));

			System.out.print("Alteracao realizada com sucesso.\n");
			} else {
				System.out.print("O RG nao corresponde a nenhum vendedor cadastrado.");
				break;
			}
		}
	}

	public static void imprimeVendedores(){ // Imprime listaVendedores
		// Verifica lista vazia
		if(listaVendedores.isEmpty()){
			System.out.print("Nao existem vendedores cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime lista Vendedores
			System.out.println(listaVendedores.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

	public static void removeVendedor(){ // Remove vendedor
		Vendedor aux1 = new Vendedor();

		String verifica;
		System.out.print("Informe o RG do vendedor para exclusao: ");
		verifica = sc.nextLine();
		for (int i = 0; i<listaVendedores.size(); i++){
			aux1 = listaVendedores.get(i);
			//Verifica se o RG corresponde a algum vendedor presente na listaVendedores
			if(verifica.equals(aux1.getRG())){
				listaVendedores.remove(i);
			   	System.out.print("Exclusao realizada com sucesso.\n");
			}else{
				System.out.print("O RG não corresponde a nenhum Vendedor cadastrado.");
				break;
			}   
		}
	}

	public static void dadosVendedores(){ // Menu para chamada dos métodos
		int op = 1;
		
		while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar vendedor");
			System.out.println("(2) Imprimir vendedores cadastrados");
            System.out.println("(3) Altera salario");
			System.out.println("(4) Remove vendedor");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addVendedor();
                    break;

                case 2:
                    imprimeVendedores();
                    break;

				case 3:
					alteraSalario();
					break;

				case 4:
					removeVendedor();
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
