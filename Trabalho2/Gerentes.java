import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Gerentes {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Gerente> listaGerentes = new ArrayList<Gerente>(); // ArrayList listaGerentes

	public static void leituraGerente() {
		try {
			FileReader arq = new FileReader("gerentes.txt");
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
				Double novoSalario = Double.parseDouble(dadoSeparado[8]);
				int novoAnosExp = Integer.parseInt(dadoSeparado[9]);

				Gerente novoGerente = new Gerente();
				Data novaDataNas = new Data();
				Data novaDataAdmi = new Data();

				// Adiciona os parâmetros em novoGerente
				novoGerente.setRG(novoRG);
				novoGerente.setNome(novoNome);
				novaDataNas.setDia(novaDataNasDia);
				novaDataNas.setMes(novaDataNasMes);
				novaDataNas.setAno(novaDataNasAno);
				novaDataAdmi.setDia(novaDataAdmiDia);
				novaDataAdmi.setMes(novaDataAdmiMes);
				novaDataAdmi.setAno(novaDataAdmiAno);
				novoGerente.setSalario(novoSalario);
				novoGerente.setAnos_xp(novoAnosExp);
				novoGerente.setData_nasc(novaDataNas);
				novoGerente.setData_adm(novaDataAdmi);

				// Adiciona no ArrayList listaGerentes
				listaGerentes.add(novoGerente);
			}
			leitor.close();

		} catch (IOException e) {

		}
	}

	public static void addGerente(){
		Gerente gerente;
		Data data_nasc, data_adm;

		// Inicializa objetos
		gerente = new Gerente();
		data_nasc = new Data();
        data_adm = new Data();
		
		// Recebe os dados
		System.out.print("Digite RG: ");
		gerente.setRG(sc.nextLine());
		
		System.out.print("Digite nome: ");
		gerente.setNome(sc.nextLine());
		
		System.out.print("Digite data de nascimento - dia: ");
		data_nasc.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - mes: ");
		data_nasc.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - ano: ");
		data_nasc.setAno(Integer.parseInt(sc.nextLine()));

		gerente.setData_nasc(data_nasc);

        System.out.print("Digite data de admissao - dia: ");
		data_adm.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - mes: ");
		data_adm.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de admissao - ano: ");
		data_adm.setAno(Integer.parseInt(sc.nextLine()));

        gerente.setData_adm(data_adm);

        System.out.print("Digite salario: ");
		gerente.setSalario(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite anos de experiencia: ");
		gerente.setAnos_xp(Integer.parseInt(sc.nextLine()));

		System.out.println();

		// Adiciona gerente na lista Gerentes
		listaGerentes.add(gerente);

		System.out.print("Gerente cadastrado com sucesso.\n");
	}

	public static void salvaGerentes() {
		// Escreve listaGerentes no arquivo "gerentes.txt", cada linha corresponde a um gerente, separador " "

		Gerente aux = new Gerente();
		Data data_nasc = new Data();
		Data data_adm = new Data();

		// Salva os gerentes no arquivo
		String nomeArquivo = "gerentes.txt";
		try {
			File arq = new File(nomeArquivo);
			FileWriter escritor = new FileWriter(arq, false);
			for(int i = 0; i < listaGerentes.size(); i++){
				aux = listaGerentes.get(i);
				data_nasc = aux.getData_nasc();
				data_adm = aux.getData_adm();
				escritor.write(aux.getRG() + " " + 
				aux.getNome() + " " + 
				data_nasc.getDia() + " " + data_nasc.getMes() + " " + data_nasc.getAno() + " " +
				data_adm.getDia() + " " + data_adm.getMes() + " " + data_adm.getAno() + " " +
				aux.getSalario() + " " + aux.getAnos_xp() + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
	}

	public static void alteraSalario() { // Altera salário
		Gerente aux1 = new Gerente();

		String verifica;
		System.out.print("Informe o RG do gerente para alteracao: ");
		verifica = sc.nextLine();
		for (int i = 0; i < listaGerentes.size(); i++) {
			aux1 = listaGerentes.get(i);
			// Verifica se o RG corresponde a algum gerenete presente na lista de gerentes
			if (verifica.equals(aux1.getRG())) { // Verificar sintaxe
				System.out.print("Digite novo salario: ");
				aux1.setSalario(Double.parseDouble(sc.nextLine()));

			System.out.print("Alteracao realizada com sucesso.\n");
			} else {
				System.out.print("O RG nao corresponde a nenhum gerente cadastrado.");
				break;
			}
		}
	}

	public static void imprimeGerentes(){ // Imprime listaGerentes
		// Verifica lista vazia
		if(listaGerentes.isEmpty()){
			System.out.print("Nao existem gerentes cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime lista Gerentes
			System.out.println(listaGerentes.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

	public static void removeGerente(){ 
		// Remove gerente de listaGerente e do campo "resp" dos vendedores que ele é responsável
        int i, j;
        Gerente novo, aux1, aux2;
        Vendedor aux3;

        // Inicializa objetos
        novo = new Gerente();
        aux1 = new Gerente();
        aux2 = new Gerente();
        aux3 = new Vendedor();
        
        System.out.print("Digite RG do gerente: ");
        aux1.setRG(sc.nextLine());

        for(i=0; i<listaGerentes.size(); i++){
            aux2 = listaGerentes.get(i);
            if(aux1.getRG().equals(aux2.getRG())){
                // Procura gerente do vendedor na listaVendedores
                for(j=0; j<Vendedores.listaVendedores.size(); j++){
                    aux3 = Vendedores.listaVendedores.get(j);
                    aux2 = aux3.getResp();
                    if(aux1.getRG().equals(aux2.getRG())){
                        // Atualiza gerente do vendedor para null
                        Vendedores.listaVendedores.get(j).setResp(novo);
                    }
                }
                // Remove gerente da listaGerentes
                listaGerentes.remove(i);
                System.out.print("Gerente removido com sucesso.\n");
            }else
                System.out.print("\nErro: CNH invalida.\n");
        }
    }
	
	public static void verificaGerente(){
		// fazer dps com senha
	}

	public static void dadosGerentes(){ // Menu para chamadas dos métodos
		int op = 1;
		
		while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar gerente");
			System.out.println("(2) Imprimir gerentes cadastrados");
            System.out.println("(3) Altera salario");
			System.out.println("(4) Remove gerente");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addGerente();
                    break;

                case 2:
                    imprimeGerentes();
                    break;

				case 3:
					alteraSalario();
					break;

				case 4:
					removeGerente();
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