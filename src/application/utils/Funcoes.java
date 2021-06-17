package application.utils;

import java.util.ArrayList;

import application.model.Filme;
import application.model.Sala;
import application.model.Sessao;

public class Funcoes{
	
	public void exibeMenu() {
        System.out.println("Opções:");
        System.out.println("1. Vendas de ingressos");
        System.out.println("2. Gerenciamento de filmes");
        System.out.println("3. Gerenciamento de salas");
        System.out.println("4. Gerenciamento de atendentes");
        System.out.println("5. Financeiro");
        System.out.println("6. Sair");
	}
    public int verificaSeFilmeExiste(Filme[] filmes, String nomeDoFilme){
        int contadorFilmes = 0;
        for (int i=0; i < filmes.length; i++){                      
            if(filmes[i].getTitulo().contains(nomeDoFilme)){
                    exibeInformacoesFilme(filmes[i]);
                    contadorFilmes++;
            }
        }
        return contadorFilmes;
    }

    public void exibeInformacoesFilme(Filme filme){
        System.out.println(filme.getCodigo() + " - " + filme.getTitulo());
    }

    public void verificaSessoes(ArrayList<Sessao> sessoes, int codigoDoFilme){
        if (codigoDoFilme <=3 && codigoDoFilme >= 0){
			sessoes.forEach((sessao)-> {
				if(sessao.getFilme().getCodigo() == codigoDoFilme){
                    System.out.println("---------------------------------------");
					System.out.println("SESSÃO - código " + sessao.getCodigo());
					System.out.println("Sala: " + sessao.getSala().getCodigo() + " Horário: " + sessao.getHorario());                                  							
                }
			});
		}
    }

    public void verificaSalas(Sessao sessao) {
    	Sala sala = sessao.getSala();
    	boolean[][] lugares = sessao.getLugares();
    	
    	if(sala.getCodigo() == 1) {
    		for(int l=0; l < 20; l++ ) {
    			for(int c=0; c < 10; c++ ) {
        			if(lugares[l][c] == true) {
        				System.out.print(" X ");
        			}else {
        				System.out.print(" - ");
        			}
        		}
    			System.out.println("");
    		}
    	}
    	if(sala.getCodigo() == 2) {
    		for(int l=0; l < 20; l++ ) {
    			 for(int c=0; c < 8; c++ ) {      			
        				if(c==2 || c==4 | c==6) {
        					if(lugares[l][c] == true)
                				System.out.print(" X");
        					else 
                				System.out.print(" -");      					
        				}else {
        					if(lugares[l][c] == true) 
                				System.out.print("X");
        					else
                				System.out.print("-");        					
        				}      			
        			}
    			System.out.println("");

        		}
    		}
    	
    	}
    	
    }

