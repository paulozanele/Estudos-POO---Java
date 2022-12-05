// Nomes: Gustavo Kenji Kuroda de Oliveira
//        Paulo Vitor de Queiroz Zanele


import java.util.Scanner;

public class Projeto1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 1;
        int opc = 1;
        while (op != 0){
            System.out.println("_______________________");
            System.out.println(" (1) Administrador");
            System.out.println(" (2) Cliente");
            System.out.println(" (0) Sair do programa");
            System.out.println("_______________________");
            System.out.print("Digite aqui sua opcao: ");
            op = Integer.parseInt(sc.nextLine());
            if (op == 1){
                System.out.println("_______________________");
                System.out.println(" (1) Rotas");
                System.out.println(" (2) Onibus");
                System.out.println(" (3) Motorista");
                System.out.println(" (4) Passageiro");
                System.out.println(" (0) Voltar");
                System.out.println("_______________________");
                System.out.print("Digite aqui sua opcao: ");
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 1:
                        Rotas.dadosRotas();
                        break;

                    case 2:
                        Onibus.dadosOnibus();
                        break;

                    case 3:
                        Motoristas.dadosMotoristas();
                        break;

                    case 4:
                        Passageiros.dadosPassageiros();
                        break;
                    
                    case 0:
                        break;

                    default:
                        System.out.print("Opcao invalida! Pressione uma tecla para continuar.");
					    sc.nextLine();
                        break;
                }
            }else if (op == 2){
                System.out.println("_______________________");
                System.out.println("AREA DO CLIENTE");
                System.out.println("_______________________");
                Passageiros.verificaIDPassageiro();
                Rotas.pesquisaRotas();
                System.out.print("Digite ID do onibus:");
                int id = Integer.parseInt(sc.nextLine());
                Passageiros.reservaAssento(id);
            }
        }
        sc.close();
    }
}