package application;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import application.model.Atendente;
import application.model.Filme;
import application.model.Sala;
import application.model.Sessao;
import application.utils.Funcoes;

public class Main {

	public static void main(String[] args) {
		int varControle = 0;
        Funcoes f = new Funcoes();
        Scanner entrada = new Scanner(System.in);
        
        Atendente atendente1 = new Atendente(1, "Maria", "123.456.789-12");
		Atendente atendente2 = new Atendente(2, "Bruna", "223.456.789-12");
		
        Filme[] filmes = new Filme[4];
        filmes[0] = new Filme(1, "Orgulho e preconceito", "2005", "bom", "romance", atendente1 );
        filmes[1] = new Filme(2, "Jogos vorazes", "2014", "mais ou menos", "ação", atendente1 );
        filmes[2] = new Filme(3, "Matrix", "2001", "não entendi", "ação", atendente2 );
        filmes[3] = new Filme(4, "Red", "2010", "bom", "comédia", atendente2 );


        ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
		ArrayList<Atendente> atendentes = new ArrayList<Atendente>();
		Sala sala1 = new Sala(1, "Sala 1", 200);
		Sala sala2 = new Sala(2, "Sala 2", 160);

		
		atendentes.add(atendente1);
		atendentes.add(atendente2);
		
		sessoes.add(new Sessao(1, sala1, filmes[0], LocalTime.now()));
		sessoes.add(new Sessao(2, sala2, filmes[2], LocalTime.now()));

        while (varControle != 6){
        	f.exibeMenu();
            varControle = Integer.parseInt(entrada.nextLine());
            switch (varControle){
                case 1:
                    System.out.println("Insira o nome do filme: ");
                    String nomeDoFilme = entrada.nextLine();
                    int contadorFilmes = f.verificaSeFilmeExiste(filmes, nomeDoFilme);
                    if (contadorFilmes == 0){
                        System.out.println("Nenhum resultado encontrado."); 
                    }else{
						System.out.println("Qual o código do filme? ");
						Integer codigoDoFilme = Integer.parseInt(entrada.nextLine());
                        f.verificaSessoes(sessoes, codigoDoFilme);
                        
                        System.out.println("Qual o código da sessão? ");
                        int codigoSessao = Integer.parseInt(entrada.nextLine());
                        f.verificaSalas(sessoes.get(codigoSessao-1));
                        System.out.println("Vamos escolher seu lugar");
                        System.out.println("Número da coluna: (ex: se for a 4ª, colocar apenas 4)");
                        int coluna = Integer.parseInt(entrada.nextLine());
                        System.out.println("Número da fileira: (ex: se for a 6ª, colocar apenas 4)");
                        int fileira = Integer.parseInt(entrada.nextLine());
                        f.reservaLugar(sessoes.get(codigoSessao-1), coluna, fileira);
                        System.out.println("Comprado!");

                    }
                    					
                break;
				case 2:
					System.out.println("Gerenciamento de filmes:");
					System.out.println();
					System.out.println("1-Listar filmes");
					System.out.println("2-Cadastrar filmes");
					System.out.println("3-Deletar filmes");
					int escolha = Integer.parseInt(entrada.nextLine());
					switch (escolha) {
						case 1:
							for (int i = 0; i < filmes.length; i++){
								System.out.println(filmes[i].getCodigo() + " " + filmes[i].getTitulo());
							}
							break;
						case 2:
							System.out.println("Insira um código:");
							int codigo = Integer.parseInt(entrada.nextLine());
							System.out.println("Insira o título");
							String titulo = entrada.nextLine();
							System.out.println("");
							String anoLancamento = entrada.nextLine();
							System.out.println();
							String sinopse = entrada.nextLine();
							System.out.println();
							String genero = entrada.nextLine();;
							System.out.println();
							Atendente atendente = atendentes.get(1);
							break;
						default:
							break;
					}
					break;
            }
            System.out.println("Vamos retornar o menu, se desejar sair, pressione 6");
        }
	}

}
