import java.util.ArrayList;
import java.util.Scanner;

public class Passageiros {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Passageiro> listaPassageiros = new ArrayList<Passageiro>();

	public static void addPassageiro(){
		Passageiro passageiro;
		Data data_nasc;

		// Inicializa objetos
		passageiro = new Passageiro();
		data_nasc = new Data();
		
		// Recebe os dados
		System.out.print("Digite RG: ");
		passageiro.setNumRG(sc.nextLine());
		
		System.out.print("Digite nome: ");
		passageiro.setNome(sc.nextLine());
		
		System.out.print("Digite endereco: ");
		passageiro.setEnd(sc.nextLine());
		
		System.out.print("Digite data de nascimento - dia: ");
		data_nasc.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - mes: ");
		data_nasc.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de nascimento - ano: ");
		data_nasc.setAno(Integer.parseInt(sc.nextLine()));

		passageiro.setData(data_nasc);

		System.out.println();

		// Adiciona passageiro na lista Passageiros
		listaPassageiros.add(passageiro);

		System.out.print("Passageiro cadastrado com sucesso.\n");
	}

	public static void imprimePassageiros(){
		// Verifica lista vazia
		if(listaPassageiros.isEmpty()){
			System.out.print("Nao existem passageiros cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime lista Passageiros
			System.out.println(listaPassageiros.toString());
			System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
		}
	}

	public static void reservaAssento(int ID){
        Oni aux1 = new Oni();
        for (int i=0; i<Onibus.listaOnibus.size(); i++){
			aux1 = Onibus.listaOnibus.get(i);
			if (aux1.getID() == ID){
				System.out.println("Assentos (1-Reservados, 0-Disponiveis)");
				System.out.println("    A B  C D");
				for(int x=0; x<8; x++){
					int j=0;
					System.out.printf("%d - %d %d  %d %d\n", x+1, aux1.getAssento(x, j), aux1.getAssento(x, j+1),
					aux1.getAssento(x, j+2), aux1.getAssento(x, j+3));
				}
				System.out.print("Digite coluna do assento(A = 0, B = 1, C = 2 ou D = 3): ");
				int coluna = Integer.parseInt(sc.nextLine());
				System.out.print("Digite fileira do assento(1-9): ");
				int linha = Integer.parseInt(sc.nextLine());

				if(aux1.getAssento(linha-1, coluna) == 1){
					System.out.print("Assento indisponivel! Pressione uma tecla para continuar.");
					sc.nextLine();
				}else{
					aux1.setAssento(linha-1, coluna);
					System.out.print("Assento reservado com sucesso!\n");
				}
			}else{
				System.out.printf("\nErro: ID inválido.\n");
			}
		}
    }
	
	public static void verificaIDPassageiro(){
		Passageiro aux1 = new Passageiro();

		String verificaID;
		System.out.print("Informe o RG do passageiro para verificação do cadastro: ");
		verificaID = sc.nextLine();
		for (int i = 0; i<listaPassageiros.size(); i++){
			aux1 = listaPassageiros.get(i);
			//Verifica se o ID corresponde a algum passageiro presente na lista de passageiros
			if(verificaID.equals(aux1.getNumRG())){ 				//Verificar sintaxe
			   System.out.print("Confirmação realizada com sucesso.\n");
			}else{
				System.out.print("O RG não corresponde a nenhum passageiro cadastrado.");
				break;
			}   
		}
	}

	public static void dadosPassageiros(){
		int op = 1;
		
		while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar passageiro");
			System.out.println("(2) Imprimir passageiros cadastrados");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addPassageiro();
                    break;

                case 2:
                    imprimePassageiros();
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
