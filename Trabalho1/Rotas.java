import java.util.Scanner;
import java.util.ArrayList;

public class Rotas {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Rota> listaRotas = new ArrayList<>();

    public static void addRota(){
        Rota rota;
        Data saida;
        Data chegada;

        // Inicializa objetos
        rota = new Rota();
        saida = new Data();
        chegada = new Data();

        System.out.print("Digite ID: ");
        rota.setID(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite origem: ");
        rota.setOrigem(sc.nextLine());

        System.out.print("Digite parada: ");
        rota.setParada(sc.nextLine());

        System.out.print("Digite destino: ");
        rota.setDetino(sc.nextLine());

        System.out.print("Digite data de saida - dia: ");
		saida.setDia(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite data de saida - mes: ");
		saida.setMes(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite data de saida - ano: ");
		saida.setAno(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite saida - hora: ");
		saida.setHora(sc.nextLine());

		System.out.print("Digite saida - minuto: ");
		saida.setMin(sc.nextLine());

        rota.setSaida(saida);

        System.out.print("Digite data de chegada - dia: ");
		chegada.setDia(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite data de chegada - mes: ");
		chegada.setMes(Integer.parseInt(sc.nextLine()));

		System.out.print("Digite data de chegada - ano: ");
		chegada.setAno(Integer.parseInt(sc.nextLine()));

        System.out.print("Digite chegada - hora: ");
		chegada.setHora(sc.nextLine());

		System.out.print("Digite chegada - minuto: ");
		chegada.setMin(sc.nextLine());

        rota.setChegada(chegada);

        // Associa um onibus a rota
        rota = addOnibus(rota);

        // Adiciona rota a lista  Rotas
        listaRotas.add(rota);

        System.out.print(" Rota adiciona da com sucesso.\n");
    }

    public static Rota addOnibus(Rota rota){
        int i;
        Oni aux1, aux2;
        Rota novo = rota;

        // Inicializa objetos
        aux1 = new Oni();

        System.out.print("Digite ID do onibus: ");
        aux1.setID(Integer.parseInt(sc.nextLine()));

        for(i=0; i<Onibus.listaOnibus.size(); i++){
            aux2 = Onibus.listaOnibus.get(i);
            if(aux1.getID() == aux2.getID()){
                novo.setOnibus(aux2);
                System.out.print("Onibus associado com sucesso.");
            }else
                System.out.print("\nErro: ID invalido.\n");
        }

        return novo;
    }

    public static void removeRota(){
        int i;
        Rota aux1, aux2;

        // Inicializa objetos
        aux1 = new Rota();

        System.out.print("Digite ID da rota: ");
        aux1.setID(Integer.parseInt(sc.nextLine()));

        for(i=0; i<listaRotas.size(); i++){
            aux2 = listaRotas.get(i);
            if(aux1.getID() == aux2.getID()){
                listaRotas.remove(i);
            }else
                System.out.print("\nErro: ID invalido.\n");
        }
    }

    public static void pesquisaRotas(){
        Rota  aux1 = new Rota();

	    String origem;
	    String destino; 
	    int cont = 0;
	    System.out.println("\nInforme o ponto de partida: ");
	    origem = sc.nextLine();
	    System.out.println("Informe o ponto de chegada: ");
	    destino = sc.nextLine();
	    for (int i = 0; i<listaRotas.size(); i++){
            aux1 = listaRotas.get(i);
		    if(origem.equals(aux1.getOrigem()) && destino.equals(aux1.getDestino())){
			    System.out.println(aux1.toString());				//Imprimir todas rotas com os mesmos pontos de chegadas e partidas e com os detalhes das mesmas ou a gente pode filtrar tbm
                cont++;
            }
	    }
	    if (cont==0){
		    System.out.println("Nao existem rotas cadastradas com esses pontos de partida e chegada");
		    sc.nextLine();
	    }
    }


    public static void imprimeRotas(){
        // Verifica lista vazia
		if(listaRotas.isEmpty()){
			System.out.print("Nao existem rotas cadastradas, pressione uma tecla para continuar!");
			sc.nextLine();
		}else{
			// Imprime listaRotas
			System.out.println(listaRotas.toString());
            System.out.print("Pressione uma tecla para continuar!");
			sc.nextLine();
        }
    }

    public static void dadosRotas(){
        int op = 1;

        while(op != 0){
            System.out.println("_______________________");
            System.out.println("(1) Cadastrar rota");
			System.out.println("(2) Remover rota");
            System.out.println("(3) Imprimir rotas cadastradas");
			System.out.println("(0) Voltar");
			System.out.println("_______________________");
            System.out.print("Digite aqui sua opcao: ");
			op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    addRota();
                    break;

                case 2:
                    removeRota();
                    break;

                case 3:
                    imprimeRotas();
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
