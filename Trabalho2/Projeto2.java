// Nomes: Gustavo Kenji Kuroda de Oliveira
// Paulo Vitor de Queiroz Zanele

import java.util.Scanner;

public class Projeto2 {

    public static void imprimeMenu() {
        System.out.println(" (1) Cadastrar");
        System.out.println(" (2) Excluir");
        System.out.println(" (3) Alterar");
        System.out.println("_______________________");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 1;
        String aux, senha = "coxinha123";

        // Carrega dados dos arquivos
        Carros.leituraCarro();
        Clientes.leituraCliente();
        Gerentes.leituraGerente();
        Motocicletas.leituraMotocicleta();
        Vendedores.leituraVendedor();
        Vendas.leituraVenda();

        while (opc != 0) {
            System.out.println("_______________________");
            System.out.println(" (1) Gerente");
            System.out.println(" (2) Vendedor");
            System.out.println(" (0) Sair do programa");
            System.out.println("_______________________");
            System.out.print("Digite aqui sua opcao: ");
            opc = Integer.parseInt(sc.nextLine());
            if (opc == 1) {
                System.out.print("Digite senha: ");
                aux = sc.nextLine();
                if (aux.equals(senha)){
                    System.out.println("_______________________");
                    System.out.println("AREA DO GERENTE");
                    System.out.println(" (1) Clientes");
                    System.out.println(" (2) Vendedores");
                    System.out.println(" (3) Gerentes");
                    System.out.println(" (4) Veiculos");
                    System.out.println(" (5) Vendas");
                    System.out.println("_______________________");
                    System.out.print("Digite aqui sua opcao: ");
                    opc = Integer.parseInt(sc.nextLine());
                    if (opc == 1) {
                        System.out.println("_______________________");
                        System.out.println("AREA DO GERENTE - Clientes");
                        Clientes.dadosClientes();
                    }
                    else if (opc == 2) {
                        System.out.println("_______________________");
                        System.out.println("AREA DO GERENTE - Vendedores");
                        Vendedores.dadosVendedores();
                    }
                    else if (opc == 3) {
                        System.out.println("_______________________");
                        System.out.println("AREA DO GERENTE - Gerentes");
                        Gerentes.dadosGerentes();
                    }else if (opc == 4){
                        System.out.println("_______________________");
                        System.out.println("AREA DO GERENTE - Veiculos");
                        System.out.println(" (1) Carros");
                        System.out.println(" (2) Motocicletas");
                        System.out.println("_______________________");
                        System.out.print("Digite aqui sua opcao: ");
                        opc = Integer.parseInt(sc.nextLine());
                        if (opc == 1){
                            Carros.dadosCarros();
                        }else if (opc == 2){
                            Motocicletas.dadosMotos();
                        }else{
                            System.out.print("Opcao invalida! Pressione uma tecla para continuar.");
                            sc.nextLine();
                            break;
                        }
                    }else if (opc == 5){
                        Vendas.relatorio();
                        Vendas.dadosVendas();
                    }
                }else{
                    System.out.println("Senha incorreta! Pressione uma tecla para continuar.");
                    sc.nextLine();
                }
            } else if (opc == 2) {
                System.out.println("_______________________");
                System.out.println("AREA DO VENDEDOR");
                System.out.println(" (1) Clientes");
                System.out.println(" (2) Veiculos");
                System.out.println(" (3) Vendas");
                System.out.println("_______________________");
                System.out.print("Digite aqui sua opcao: ");
                opc = Integer.parseInt(sc.nextLine());
                if (opc == 1) {
                    System.out.println("_______________________");
                    System.out.println("AREA DO VENDEDOR - Clientes");
                    Clientes.dadosClientes();
                }else if (opc == 2){
                    System.out.println("_______________________");
                    System.out.println("AREA DO VENDEDOR - Veiculos");
                    System.out.println(" (1) Carros");
                    System.out.println(" (2) Motocicletas");
                    System.out.println("_______________________");
                    System.out.print("Digite aqui sua opcao: ");
                    opc = Integer.parseInt(sc.nextLine());
                    if (opc == 1){
                        Carros.dadosCarros();
                    }else if (opc == 2){
                        Motocicletas.dadosMotos();
                    }else{
                        System.out.print("Opcao invalida! Pressione uma tecla para continuar.");
                        sc.nextLine();
                        break;
                    }
                }else if (opc == 3){
                    Vendas.dadosVendas();
                }else{
                    System.out.println("Senha incorreta! Pressione uma tecla para continuar.");
                    sc.nextLine();
                } 
            }
        }
        sc.close();

        // Salva os dados
        Clientes.salvaClientes();
        Gerentes.salvaGerentes();
        Vendedores.salvaVendedores();
        Carros.salvaCarros();
        Motocicletas.salvaMotos();
        Vendas.salvaVendas();
    }
}

/*
 * switch (opc) {
 * case 1:
 * // Rotas.dadosRotas();
 * break;
 * 
 * case 2:
 * //Onibus.dadosOnibus();
 * break;
 * 
 * case 3:
 * //Motoristas.dadosMotoristas();
 * break;
 * 
 * case 4:
 * Passageiros.dadosPassageiros();
 * break;
 * 
 * case 0:
 * break;
 * 
 * default:
 * System.out.print("Opcao invalida! Pressione uma tecla para continuar.");
 * sc.nextLine();
 * break;
 * }
 */
