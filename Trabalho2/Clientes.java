import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Clientes {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); // ArrayList lista Clientes

	public static void leituraCliente() {
		try {
			FileReader arq = new FileReader("clientes.txt");
			BufferedReader leitor = new BufferedReader(arq);
			while (leitor.ready()) {
				String linha = leitor.readLine();
				String[] dadoSeparado = linha.split(" ");

				// Lê os dados do arquivo
				String novoCPF = dadoSeparado[0];
				String novoNome = dadoSeparado[1];
				int novaDataNasDia = Integer.parseInt(dadoSeparado[2]);
				int novaDataNasMes = Integer.parseInt(dadoSeparado[3]);
				int novaDataNasAno = Integer.parseInt(dadoSeparado[4]);
				String novoEndRua = dadoSeparado[5];
				int novoEndNum = Integer.parseInt(dadoSeparado[6]);
				String novoEndBairro = dadoSeparado[7];
				String novoEndCidade = dadoSeparado[8];
				int novoDependentes = Integer.parseInt(dadoSeparado[9]);
				Double novoRenda = Double.parseDouble(dadoSeparado[10]);

				End novoEnd = new End();
				Data novaData_Nasc = new Data();
				Cliente novoCliente = new Cliente();

				// Adiciona os parâmetros em novoCliente
				novoCliente.setCPF(novoCPF);
				novoCliente.setNome(novoNome);
				novaData_Nasc.setDia(novaDataNasDia);
				novaData_Nasc.setMes(novaDataNasMes);
				novaData_Nasc.setAno(novaDataNasAno);
				novoEnd.setRua(novoEndRua);
				novoEnd.setNum(novoEndNum);
				novoEnd.setBairro(novoEndBairro);
				novoEnd.setCidade(novoEndCidade);
				novoCliente.setDependentes(novoDependentes);
				novoCliente.setRenda(novoRenda);
				novoCliente.setData_nasc(novaData_Nasc);
				novoCliente.setEndereco(novoEnd);

				// Adiciona no ArrayList listaClientes
				listaClientes.add(novoCliente);
			}
			leitor.close();

		} catch (IOException e) {

		}
	}

	public static void addCliente() {

		Cliente cliente;
		Data data_nasc;
		End end;

		// Inicializa objetos
		cliente = new Cliente();
		data_nasc = new Data();
		end = new End();

		// Recebe os dados
		System.out.print("Digite CPF: ");
		cliente.setCPF(sc.nextLine());

		System.out.print("Digite nome: ");
		cliente.setNome(sc.nextLine());

		System.out.print("Digite data de nascimento - dia: ");
		data_nasc.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - mes: ");
		data_nasc.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - ano: ");
		data_nasc.setAno(Integer.parseInt(sc.nextLine()));
		
		cliente.setData_nasc(data_nasc);
		
		System.out.print("Digite rua: ");
		end.setRua(sc.nextLine());
		
		System.out.print("Digite numero: ");
		end.setNum(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite bairro: ");
		end.setBairro(sc.nextLine());
		
		System.out.print("Digite cidade: ");
		end.setCidade(sc.nextLine());
		
		cliente.setEndereco(end);

		System.out.print("Digite n de dependentes: ");
		cliente.setDependentes(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite renda: ");
		cliente.setRenda(Double.parseDouble(sc.nextLine()));

		System.out.println();

		// Adiciona Cliente na lista Clientes
		listaClientes.add(cliente);
		System.out.print("Cliente cadastrado com sucesso.\n");
	}

	public static void salvaClientes() {
		// Escreve listaClientes no arquivo "clientes.txt", cada linha corresponde a um cliente, separador " "

		Cliente aux = new Cliente();
		Data data_nasc = new Data();
		End end = new End();

		// Salva o Cliente no arquivo
		String nomeArquivo = "clientes.txt";
		try {
			File arq = new File(nomeArquivo);
			FileWriter escritor = new FileWriter(arq, false);
			for(int i = 0; i < listaClientes.size(); i++){
				aux = listaClientes.get(i);
				data_nasc = aux.getData_nasc();
				end = aux.getEndereco();
				escritor.write(aux.getCPF() + " " + 
				aux.getNome() + " " + 
				data_nasc.getDia() + " " + data_nasc.getMes() + " " + data_nasc.getAno() + " " +
				end.getRua() + " " + end.getNum() + " " + end.getBairro() + " " + end.getCidade() + " " +
				aux.getDependentes() + " " + aux.getRenda() + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
	}

	public static void imprimeClientes() { // Imprime listaClientes
		// Verifica lista
		if (listaClientes.isEmpty()) {
			System.out.print("Nao existem clientes cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		} else {
			// Imprime lista Clientes
			System.out.println(listaClientes.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

	public static void alteraEnd() { // Altera endereço
		Cliente aux1 = new Cliente();
		End end = new End();

		String verifica;
		System.out.print("Informe o CPF do cliente para alterar endereco: ");
		verifica = sc.nextLine();
		for (int i = 0; i < listaClientes.size(); i++) {
			aux1 = listaClientes.get(i);
			// Verifica se o ID corresponde a algum Cliente presente na lista de Clientees
			if (verifica.equals(aux1.getCPF())) { // Verificar sintaxe
				System.out.print("Digite novo endereco: ");
				System.out.print("Digite rua: ");
				end.setRua(sc.nextLine());
				
				System.out.print("Digite numero: ");
				end.setNum(Integer.parseInt(sc.nextLine()));
				
				System.out.print("Digite bairro: ");
				end.setBairro(sc.nextLine());
				
				System.out.print("Digite cidade: ");
				end.setCidade(sc.nextLine());

				aux1.setEndereco(end);

				System.out.print("Alteracao realizada com sucesso.\n");
			} else {
				System.out.print("O CPF nao corresponde a nenhum cliente cadastrado.");
				break;
			}
		}
	}

	public static void alteraRenda() { // Altera renda
		Cliente aux1 = new Cliente();
		String verifica;

		System.out.print("Informe o CPF do cliente para alterar renda: ");
		verifica = sc.nextLine();
		for (int i = 0; i < listaClientes.size(); i++) {
			aux1 = listaClientes.get(i);
			// Verifica se o ID corresponde a algum cliente presente na listaClientes
			if (verifica.equals(aux1.getCPF())) {
				System.out.print("Digite nova renda: ");
				aux1.setRenda(Double.parseDouble(sc.nextLine()));

			System.out.print("Alteracao realizada com sucesso.\n");
			} else {
				System.out.print("O CPF nao corresponde a nenhum cliente cadastrado.");
				break;
			}
		}
	}

	public static void excluiCliente() { // Exclui cliente
		Cliente aux1 = new Cliente();
		String verifica;

		System.out.print("Informe o CPF do cliente para exclusao: ");
		verifica = sc.nextLine();
		for (int i = 0; i < listaClientes.size(); i++) {
			aux1 = listaClientes.get(i);
			// Verifica se o ID corresponde a algum Cliente presente na lista de Clientees
			if (verifica.equals(aux1.getCPF())) {
				listaClientes.remove(i);
				System.out.print("Exclusao realizada com sucesso.\n");
			} else {
				System.out.print("O CPF não corresponde a nenhum cliente cadastrado.");
				break;
			}
		}
	}

	public static void dadosClientes() { // Menu para chamada dos métodos
		int op = 1;

		while (op != 0) {
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar cliente");
			System.out.println("(2) Imprimir clientes cadastrados");
			System.out.println("(3) Altera endereco");
			System.out.println("(4) Altera renda");
			System.out.println("(5) Exclui cliente");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
				case 1:
					addCliente();
					break;

				case 2:
					imprimeClientes();
					break;

				case 3:
					alteraEnd();
					break;

				case 4:
					alteraRenda();
					break;

				case 5:
					excluiCliente();
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
