package application;

import java.util.Scanner;

import application.utils.Funcoes;

public class Main {

	public static void main(String[] args) {
		int varControle = 0;
        Funcoes f = new Funcoes();
        Scanner entrada = new Scanner(System.in);

        while (varControle != 6){
        	f.exibeMenu();
            varControle = Integer.parseInt(entrada.nextLine());
            switch (varControle){
                case 1:
                	System.out.println("Compra de ingresso:");
                	f.compraIngresso();                   					
                break;
				case 2:
					System.out.println("Gerenciamento de filmes:");
					System.out.println();
					System.out.println("1-Listar filmes");
					System.out.println("2-Cadastrar filmes");
					System.out.println("3-Deletar filmes");
					System.out.println("4-Editar filmes");

					int escolhaFilme = Integer.parseInt(entrada.nextLine());
					switch (escolhaFilme) {
						case 1:
							System.out.println("Listar filmes");
							f.exibeFilme();
							break;
						case 2:
							System.out.println("Cadastrar filmes");
							f.cadastraFilme();	
							break;
						case 3:
							System.out.println("Deletar filmes");
							f.apagaFilme();
							break;
						case 4:
							System.out.println("4-Editar filmes");
							f.exibeFilme();							
							f.editaFilme();
							break;
						default:
							break;
					}
					break;
				case 3:
					System.out.println("Gerenciamento de salas:");
					System.out.println("1-Listar salas");
					System.out.println("2-Cadastrar sala");
					int escolhaSala = Integer.parseInt(entrada.nextLine());
					switch (escolhaSala) {
						case 1:
							System.out.println("Listar sala");
							f.exibeSalas();
							break;
						case 2:
							System.out.println("Cadastrar sala");
							f.cadastraSala();	
							break;
						default:
							break;
					}
				break;
				case 4:
					System.out.println("Gerenciamento de atendente:");
					System.out.println("1-Listar atendente");
					System.out.println("2-Cadastrar atendente");
					int escolhaAtendente = Integer.parseInt(entrada.nextLine());
					switch (escolhaAtendente) {
						case 1:
							System.out.println("Listar atendente");
							f.exibeAtendentes();
							break;
						case 2:
							System.out.println("Cadastrar atendente");
							f.cadastraAtendente();	
							break;
						default:
							break;
					}
				break;
				case 5:
					System.out.println("Financeiro:");
					f.calculaRendimento();
				break;
				
            }
            System.out.println("Vamos retornar o menu, se desejar sair, pressione 6");
        }
	}

}
