import java.util.ArrayList;
import java.util.Scanner;

public class Motoristas {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Motorista> listaMotoristas = new ArrayList<>();

    public static void addMotorista(){
        Motorista motorista;
        Data dataAdmissao;

        // Inicializa objetos
		motorista = new Motorista();
		dataAdmissao = new Data();

		// Recebe os dados
		System.out.print("Digite nome: ");
		motorista.setNomeMotorista(sc.nextLine());

		System.out.print("Digite CNH: ");
		motorista.setNumCarta(sc.nextLine());

		System.out.print("Digite data de admissao - dia: ");
		dataAdmissao.setDia(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite data de admissao - mes: ");
		dataAdmissao.setMes(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite data de admissao - ano: ");
		dataAdmissao.setAno(Integer.parseInt(sc.nextLine()));

		motorista.setDataAdmissao(dataAdmissao);

		System.out.println();
		
		// Adiciona motorista na listaMotoristas
		listaMotoristas.add(motorista);

        System.out.print("Motorista cadastrado com sucesso.\n");
    }

    public static void removeMotorista(){
        int i, j, x;
        Motorista novo, aux1, aux2, aux5;
        Rota aux3;
        Oni aux4;

        // Inicializa objetos
        novo = new Motorista();
        aux1 = new Motorista();
        aux2 = new Motorista();
        aux3 = new Rota();
        aux4 = new Oni();
        aux5 = new Motorista();
        
        System.out.print("Digite CNH: ");
        aux1.setNumCarta(sc.nextLine());

        for(i=0; i<listaMotoristas.size(); i++){
            aux2 = listaMotoristas.get(i);
            if(aux1.getNumCarta().equals(aux2.getNumCarta())){
                // Procura motorista do onibus na lista Rotas
                for(j=0; j<Rotas.listaRotas.size(); j++){
                    aux3 = Rotas.listaRotas.get(j);
                    aux4 = aux3.getOnibus();
                    aux2 = aux4.getMotorista();
                    if(aux1.getNumCarta().equals(aux2.getNumCarta())){
                        // Atualiza motorista do onibus da rota para null, da lista Onibus
                        for(x=0; x<Onibus.listaOnibus.size(); x++){
                            aux4 = Onibus.listaOnibus.get(x);
                            aux5 = aux4.getMotorista();
                            if(aux1.getNumCarta().equals(aux5.getNumCarta())){
                                Onibus.listaOnibus.get(x).setMotorista(novo);
                            }
                        }
                    }
                }
                // Remove Motorista da lista Motoristas
                listaMotoristas.remove(i);
                System.out.print("Motorista removido com sucesso.");
            }else
                System.out.print("\nErro: CNH invalida.\n");
        }
    }
    

    public static void imprimeMotoristas(){
        // Verifica lista vazia
		if(listaMotoristas.isEmpty()){
			System.out.print("Nao existem motoristas cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime listaMotoristas
			System.out.println(listaMotoristas.toString());
            System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
        }
    }

    public static void dadosMotoristas(){
        int op = 1;

        while(op != 0){
            System.out.println("_______________________");
            System.out.println("(1) Cadastrar motorista");
			System.out.println("(2) Remover motorista");
            System.out.println("(3) Imprimir motoristas cadastrados");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
            System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    addMotorista();
                    break;

                case 2:
                    removeMotorista();
                    break;

                case 3:
                    imprimeMotoristas();
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