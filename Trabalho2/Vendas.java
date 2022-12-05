import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Vendas {
    static Scanner sc = new Scanner(System.in);
	static ArrayList<Venda> listaVendas = new ArrayList<Venda>();

    public static void leituraVenda() {
        try {
			FileReader arq = new FileReader("vendas.txt");
			BufferedReader leitor = new BufferedReader(arq);
			while (leitor.ready()) {
				String linha = leitor.readLine();
				String[] dadoSeparado = linha.split(" ");

				// Lê os dados do arquivo
				int novoID = Integer.parseInt(dadoSeparado[0]);
				String novoVend = dadoSeparado[1];
                String novoRG = dadoSeparado[2];
				String novoCli = dadoSeparado[3];
				String novoCPF = dadoSeparado[4];
                int novoChassi = Integer.parseInt(dadoSeparado[5]);
                String novaClasse = dadoSeparado[7];
                double novoValor = Double.parseDouble(dadoSeparado[8]);
                int novoDia = Integer.parseInt(dadoSeparado[9]);
                int novoMes = Integer.parseInt(dadoSeparado[10]);
                int novoAno = Integer.parseInt(dadoSeparado[11]);
                int novaHora = Integer.parseInt(dadoSeparado[12]);
                int novoMin = Integer.parseInt(dadoSeparado[13]);

                Venda novaVenda = new Venda();
				Vendedor novoVendedor = new Vendedor();
                Cliente novoCliente = new Cliente();
                Carro novoCarro = new Carro();
                Motocicleta novaMoto = new Motocicleta();
				Data novaData = new Data();

				// Adiciona os parâmetros em novaVenda
				novaVenda.setID(novoID);
                novoVendedor.setNome(novoVend);
                novoVendedor.setRG(novoRG);
                novaVenda.setVendedor(novoVendedor);
                novoCliente.setNome(novoCli);
                novoCliente.setCPF(novoCPF);
                novaVenda.setCliente(novoCliente);
                
                if (novaClasse.equals("Carro")){
                    novoCarro.setN_chassi(novoChassi);
                    novaVenda.setVeiculo(novoCarro);
                }else{
                    novaMoto.setN_chassi(novoChassi);
                    novaVenda.setVeiculo(novaMoto);
                }

                novaVenda.setValor(novoValor);
                novaData.setDia(novoDia);
				novaData.setMes(novoMes);
				novaData.setAno(novoAno);
                novaData.setHora(novaHora);
                novaData.setMin(novoMin);
                novaVenda.setData_venda(novaData);

				// Adiciona no ArrayList listaVendas
				listaVendas.add(novaVenda);
			}
			leitor.close();

		} catch (IOException e) {

		}
    }

    public static void addVenda() {
        Venda venda = new Venda();
        Data data_venda = new Data();

        System.out.print("Digite ID: ");
		venda.setID(Integer.parseInt(sc.nextLine()));

        addVendedor(venda);

        addCliente(venda);

        addVeiculo(venda);

        System.out.print("Digite data venda - dia: ");
		data_venda.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data venda - mes: ");
		data_venda.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data venda - ano: ");
		data_venda.setAno(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite data venda - hora: ");
		data_venda.setHora(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data venda - minuto: ");
		data_venda.setMin(Integer.parseInt(sc.nextLine()));

		venda.setData_venda(data_venda);

        System.out.print("Digite valor: ");
		venda.setValor(Double.parseDouble(sc.nextLine()));

        // Adiciona venda na lista vendas
        listaVendas.add(venda);

        System.out.print("Venda cadastrada com sucesso.\n");
    }

    public static Venda addVendedor(Venda venda){
        // Verifica se o vendedor é válido e associa a venda

        int i;
        Vendedor aux1, aux2;
        Venda novo = venda;

        // Inicializa objetos
        aux1 = new Vendedor();

        System.out.print("Digite RG do vendedor:");
        aux1.setRG(sc.nextLine());

        for(i=0; i<Vendedores.listaVendedores.size(); i++){
            aux2 = Vendedores.listaVendedores.get(i);
            if(aux1.getRG().equals(aux2.getRG())){
                novo.setVendedor(aux2);
                System.out.print("Vendedor associado com sucesso.\n");
                return novo;
            }      
        }
        System.out.print("\nErro: RG inválido.\n");  
        return null;
    }

    public static Venda addCliente(Venda venda){
        // Verifica se o cliente é válido e associa a venda
        
        int i;
        Cliente aux1, aux2;
        Venda novo = venda;

        // Inicializa objetos
        aux1 = new Cliente();

        System.out.print("Digite CPF do cliente:");
        aux1.setCPF(sc.nextLine());

        for(i=0; i<Clientes.listaClientes.size(); i++){
            aux2 = Clientes.listaClientes.get(i);
            if(aux1.getCPF().equals(aux2.getCPF())){
                novo.setCliente(aux2);
                System.out.print("Cliente associado com sucesso.\n");
                return novo;
            }        
        }    
        System.out.print("\nErro: CPF inválido.\n");
        return null;
    }

    public static Venda addVeiculo(Venda venda){
        // Verifica se o veículo é um carro ou uma moto válida, marca como vendido

        int i = 0, j = 0, chassi;
        Veiculo aux1, aux2;
        Venda novo = venda;

        // Inicializa objetos
        aux1 = new Veiculo();
        aux2 = new Veiculo();

        System.out.print("Digite numero do chassi:");
        chassi = (Integer.parseInt(sc.nextLine()));
        aux1 = Carros.listaCarros.get(i);
        aux2 = Motocicletas.listaMotos.get(j);

        while ((i <= Carros.listaCarros.size()) || (j <= Motocicletas.listaMotos.size())){
            aux1 = Carros.listaCarros.get(i);
            aux2 = Motocicletas.listaMotos.get(j);
            if (chassi == aux1.getN_chassi()){
                aux1.setVendido(true);
                novo.setVeiculo(aux1);
                System.out.print("Carro associado com sucesso.\n");
                return novo;
            }else if (chassi == aux2.getN_chassi()){
                aux2.setVendido(true);
                novo.setVeiculo(aux2);
                System.out.print("Motocicleta associado com sucesso.\n");
                return novo;
            }else{
                i++;
                j++;
            }
        }

        System.out.print("\nErro: Numero de chassi inválido.\n");
        return null;
    }

    public static void salvaVendas() {
        // Escreve listaVendas no arquivo "vendas.txt", cada linhas corresponde a uma venda, separado " "

		Venda aux = new Venda();
		Data data_venda = new Data();
		Vendedor aux2 = new Vendedor();
        Cliente aux3 = new Cliente();
        Veiculo aux4 = new Veiculo();

		// Salva os vendedas no arquivo
		String nomeArquivo = "vendas.txt";
		try {
			File arq = new File(nomeArquivo);
			FileWriter escritor = new FileWriter(arq, false);
			for(int i = 0; i < listaVendas.size(); i++){
				aux = listaVendas.get(i);
				data_venda = aux.getData_venda();
				aux2 = aux.getVendedor();
                aux3 = aux.getCliente();
                aux4 = aux.getVeiculo();

                // Formato da linha do arquivo
                // ID nome_vendedor RG_vendedor nome_cliente CPF_cliente n_chassi classe_veiculo valor_venda data_venda
				escritor.write(aux.getID() + " " + aux2.getNome() + " " + aux2.getRG() + " " + 
                aux3.getNome() + " " + aux3.getCPF() + " " + aux4.getN_chassi() + " " + aux4.getClass() + " " +
                aux.getValor() + " " + data_venda.getDia() + " " + data_venda.getMes() + " " + data_venda.getAno() + " " +
				data_venda.getHora() + " " + data_venda.getMin() + "\n");
			}
			escritor.close();
		} catch (IOException e) {
			System.out.println("Erro!");
			System.out.println(e);
		}
	}

    public static void imprimeVendas(){ // Imprime listaVendas
		// Verifica lista vazia
		if(listaVendas.isEmpty()){
			System.out.print("Nao existem vendas cadastradas, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime lista Vendas
			System.out.println(listaVendas.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

    public static void relatorio(){ // Imprime um relatório simples de vendas
        int vendas_carros = 0, vendas_motos = 0, n_vendas = 0;
        Venda aux = new Venda();
        Veiculo aux1 = new Veiculo();

        for(int i = 0; i < listaVendas.size(); i++){
            aux = listaVendas.get(i);
            aux1 = aux.getVeiculo();
            if(aux1 instanceof Carro){
                vendas_carros += 1;
            }else if(aux1 instanceof Motocicleta){
                vendas_motos += 1;
            }
        }

        n_vendas = vendas_carros + vendas_motos;
        System.out.println("Total vendas: " + n_vendas);
        System.out.println("Vendas de carros: " + vendas_carros);
        System.out.println("Vendas de motos: " + vendas_motos);

    }

    public static void dadosVendas(){ // Menu para chamada dos métodos
		int op = 1;
		
		while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Registra venda");
			System.out.println("(2) Imprimir vendas");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addVenda();
                    break;

                case 2:
                    imprimeVendas();
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
