import java.util.Scanner;
import java.util.ArrayList;

public class Onibus {
    static Scanner sc = new Scanner(System.in);
	static ArrayList<Oni> listaOnibus = new ArrayList<Oni>();

    public static void addOnibus(){
        Oni onibus;
        Data data_fabri;

        // Inicializa objetos
        onibus = new Oni();
        data_fabri = new Data();

        // Recebe os dados
        System.out.print("Digite ID: ");
		onibus.setID(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite marca: ");
		onibus.setMarca(sc.nextLine());
		
		System.out.print("Digite modelo: ");
		onibus.setModelo(sc.nextLine());
		
		System.out.print("Digite quilometragem: ");
		onibus.setQuilometragem(Double.parseDouble(sc.nextLine()));
		
		System.out.print("Digite data de fabricacao - dia: ");
		data_fabri.setDia(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de fabricacao - mes: ");
		data_fabri.setMes(Integer.parseInt(sc.nextLine()));
		
		System.out.print("Digite data de fabricacao - ano: ");
		data_fabri.setAno(Integer.parseInt(sc.nextLine()));

		onibus.setDataFabri(data_fabri);

        // Adiciona motorista
        onibus = addMotorista(onibus);

		System.out.println();

		// Adiciona onibus na lista Onibus
		listaOnibus.add(onibus);

        System.out.print("Onibus cadastrado com sucesso.\n");
    }

    public static Oni addMotorista(Oni onibus){
        int i;
        Motorista aux1, aux2;
        Oni novo = onibus;

        // Inicializa objetos
        aux1 = new Motorista();

        System.out.print("Digite CNH do motorista:");
        aux1.setNumCarta(sc.nextLine());

        for(i=0; i<Motoristas.listaMotoristas.size(); i++){
            aux2 = Motoristas.listaMotoristas.get(i);
            if(aux1.getNumCarta().equals(aux2.getNumCarta())){
                    novo.setMotorista(aux2);
                    System.out.print("Motorista associado com sucesso.");
            }else
                System.out.print("\nErro: CNH inválida.\n");
        }
        return novo;
    }


    public static void attQuilometragem(){
        int i;
        Oni aux1, aux2;

        // Inicializa objetos
        aux1 = new Oni();
        aux2 = new Oni();

        System.out.print("Digite ID do onibus:");
        aux1.setID(Integer.parseInt(sc.nextLine()));

        for(i=0; i<listaOnibus.size(); i++){
            aux2 = listaOnibus.get(i);
            if(aux1.getID() == aux2.getID()){
                // Atualiza a quilometragem
                System.out.print("Digite nova quilometragem: ");
                double km = Double.parseDouble(sc.nextLine());
                listaOnibus.get(i).setQuilometragem(km);
                System.out.print("Quilometragem atualizada com sucesso.");
            }else
                System.out.print("\nErro: ID invalido.\n");
        }
    }

    public static void imprimeOnibus(){
        // Verifica lista vazia
		if(listaOnibus.isEmpty()){
			System.out.print("Nao existem onibus cadastrados, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime listaOnibus
			System.out.println(listaOnibus.toString());
            System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
        }
    }

    public static void dadosOnibus(){
        int op = 1;

        while (op != 0){
			System.out.println("_______________________");
			System.out.println("(1) Cadastrar onibus");
			System.out.println("(2) Atualizar quilometragem");
            System.out.println("(3) Imprimir lista onibus");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

			switch (op) {
                case 1:
                    addOnibus();
                    break;

                case 2:
                    attQuilometragem();
                    break;

                case 3:
                    imprimeOnibus();
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