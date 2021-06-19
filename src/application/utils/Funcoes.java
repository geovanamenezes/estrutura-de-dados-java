package application.utils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import application.model.Atendente;
import application.model.Filme;
import application.model.Filmes;
import application.model.Pedido;
import application.model.Sala;
import application.model.Salas;
import application.model.Sessao;

public class Funcoes {
	
	Scanner entrada = new Scanner(System.in);
	Salas salas = new Salas();
	Filme[] filmes = new Filme[4];
	Filmes listafilmes = new Filmes();
	
	Integer contadorFilmes = 0;
	Integer codigoSala = 1;
	Integer codigoFilme = 1;
	Integer codigoAtendente = 1;
	Float soma = 0f;

	
	ArrayList<Sala> listaSalas = new ArrayList<Sala>();
	ArrayList<Pedido> pedido = new ArrayList<Pedido>();
	ArrayList<Atendente> atendentes = new ArrayList<Atendente>();
	ArrayList<Sessao> sessoes = new ArrayList<Sessao>();

	public void exibeMenu() {
		System.out.println("Opções:");
		System.out.println("1. Vendas de ingressos");
		System.out.println("2. Gerenciamento de filmes");
		System.out.println("3. Gerenciamento de salas");
		System.out.println("4. Gerenciamento de atendentes");
		System.out.println("5. Financeiro");
		System.out.println("6. Sair");
	}

	public int verificaSeFilmeExiste(Filme[] filmes, String nomeDoFilme) {
		int contadorFilmes = 0;
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i].getTitulo().toUpperCase().contains(nomeDoFilme.toUpperCase())) {
				exibeInformacoesFilme(filmes[i]);
				contadorFilmes++;
			}
		}
		return contadorFilmes;
	}

	public void exibeInformacoesFilme(Filme filme) {
		System.out.println(filme.getCodigo() + " - " + filme.getTitulo());
	}

	public void verificaSessoes(ArrayList<Sessao> sessoes, int codigoDoFilme) {
		if (codigoDoFilme <= 3 && codigoDoFilme >= 0) {
			sessoes.forEach((sessao) -> {
				if (sessao.getFilme().getCodigo() == codigoDoFilme) {
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

		if (sala.getCodigo() == 1) {
			for (int l = 0; l < 20; l++) {
				for (int c = 0; c < 10; c++) {
					if (lugares[c][l] == true) {
						System.out.print(" X ");
					} else {
						System.out.print(" - ");
					}
				}
				System.out.println("");
			}
		}
		if (sala.getCodigo() == 2) {
			for (int l = 0; l < 20; l++) {
				for (int c = 0; c < 8; c++) {
					if (c == 2 || c == 4 | c == 6) {
						if (lugares[c][l] == true)
							System.out.print(" X");
						else
							System.out.print(" -");
					} else {
						if (lugares[c][l] == true)
							System.out.print("X");
						else
							System.out.print("-");
					}
				}
				System.out.println("");

			}
		}

	}

	public void reservaLugar(Sessao sessao, int coluna, int fileira) {
		Sala sala = sessao.getSala();
		boolean[][] lugares = sessao.getLugares();
		lugares[coluna - 1][fileira - 1] = true;
		sessao.adicionaLugar();
	}

	public boolean verificaHorarioDisponivel(ArrayList<Sessao> sessoes, Sala sala, LocalTime horario) {
		sessoes.forEach((sessao) -> {
			if (sessao.getSala().equals(sala) && sessao.getHorario().equals(horario)) {
				return;
			}
		});
		return true;
	}

	public void verificaHorariosDisponiveis(ArrayList<Sessao> sessoes, Sala sala) {
		ArrayList<LocalTime> horariosIndisponiveis = new ArrayList<LocalTime>();
		sessoes.forEach((sessao) -> {
			if (sessao.getSala().equals(sala)) {
				horariosIndisponiveis.add(sessao.getHorario());
			}
		});

		ArrayList<LocalTime> horariosDisponiveis = new ArrayList<LocalTime>();
		horariosDisponiveis.add(LocalTime.of(17, 00, 00));
		horariosDisponiveis.add(LocalTime.of(19, 30, 00));
		horariosDisponiveis.add(LocalTime.of(22, 00, 00));

		for (int i = 0; i < horariosDisponiveis.size(); i++) {
			for (int j = 0; j < horariosIndisponiveis.size(); j++) {
				if (horariosDisponiveis.get(i).equals(horariosIndisponiveis.get(j))) {
					horariosDisponiveis.remove(horariosDisponiveis.get(i));
				}
			}
		}
		exibeHorariosDisponiveis(horariosDisponiveis);
	}

	public void exibeHorariosDisponiveis(ArrayList<LocalTime> horariosDisponiveis) {
		horariosDisponiveis.forEach((hD) -> {

			if (hD.equals(LocalTime.of(17, 00, 00))) {
				System.out.println(" 1 para 17h");
			}
			if (hD.equals(LocalTime.of(19, 30, 00))) {
				System.out.println(" 2 para 19h30");
			}
			if (hD.equals(LocalTime.of(22, 00, 00))) {
				System.out.println(" 3 para 22h00");
			}
		});
	}

	public void compraIngresso() {
		System.out.println("Insira o nome do filme: ");
		String nomeDoFilme = entrada.nextLine();
		int cont = verificaSeFilmeExiste(filmes, nomeDoFilme);
		if (cont == 0) {
			System.out.println("Nenhum resultado encontrado.");
		} else {
			Pedido pedido = new Pedido();

			System.out.println("nome cliente:");
			pedido.setNomeCliente(entrada.nextLine());
			System.out.println("preço pago:");
			pedido.setPreco(Float.parseFloat(entrada.nextLine()));
			System.out.println("Qual o código do filme? ");
			Integer codigoDoFilme = Integer.parseInt(entrada.nextLine());
			verificaSessoes(sessoes, codigoDoFilme);

			System.out.println("Qual o código da sessão? ");
			int codigoSessao = Integer.parseInt(entrada.nextLine());
			verificaSalas(sessoes.get(codigoSessao - 1));
			System.out.println("Vamos escolher seu lugar");
			System.out.println(
					"Número da coluna: (ex: se for a 4ª, colocar apenas 4, além disso, se for a sala de poltronas duplas, considere cada poltrona compondo uma coluna)");
			int coluna = Integer.parseInt(entrada.nextLine());
			System.out.println("Número da fileira: (ex: se for a 6ª, colocar apenas 4)");
			int fileira = Integer.parseInt(entrada.nextLine());
			reservaLugar(sessoes.get(codigoSessao - 1), coluna, fileira);
			System.out.println("Comprado!");

		}
	}

	public void exibeFilme() {
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i] != null) {
				System.out.println(filmes[i].getCodigo() + " " + filmes[i].getTitulo());
			}
		}
	}

	public void apagaFilme() {
		System.out.println("Qual o código do filme que você deseja apagar?");
		Integer cdFilme = Integer.parseInt(entrada.nextLine());
		listafilmes.apagaFilme(filmes[cdFilme - 1], filmes);
		System.out.println("apagado!");
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i] != null) {
				System.out.println(filmes[i].getCodigo() + " " + filmes[i].getTitulo());
			}
		}
		apagaSessao(filmes[cdFilme - 1].getCodigo());
	}

	public void editaFilme() {
		System.out.println("Qual o código do filme que você deseja editar?");
		Integer cdFilme = Integer.parseInt(entrada.nextLine());
		listafilmes.apagaFilme(filmes[cdFilme - 1], filmes);
		apagaSessao(filmes[cdFilme - 1].getCodigo());
		cadastraFilme();
	}

	public void cadastraFilme() {
		if (listafilmes.getQuantidade() == 4) {
			System.out
					.println("Já estão cadastrados 4 filmes, se você quiser cadastrar esse, será preciso apagar outro");
		} else {
			Filme filme = new Filme();
			
			filme.setCodigo(codigoFilme);
			System.out.println("título:");
			filme.setTitulo(entrada.nextLine());
			System.out.println("ano de lançamento:");
			filme.setAnoLancamento(entrada.nextLine());
			System.out.println("sinopse:");
			filme.setSinopse(entrada.nextLine());
			System.out.println("genero:");
			String genero = entrada.nextLine();
			;
			System.out.println("Qual atendente está cadastrando?");
			if (Integer.parseInt(entrada.nextLine()) == 1) {
				filme.setAtendente(atendentes.get(0));
			} else {
				filme.setAtendente(atendentes.get(1));
			}
			System.out.println("Vamos cadastrar as sessões: ");
			Integer controle = 0;
			while (controle == 0) {
				Sessao s = new Sessao();
				s.setFilme(filme);
				exibeSalas();
				System.out.println("Sala:");
				s.setSala(listaSalas.get((Integer.parseInt(entrada.nextLine())) - 1));
				verificaHorariosDisponiveis(sessoes, s.getSala());
				if (Integer.parseInt(entrada.nextLine()) == 1) {
					s.setHorario(LocalTime.of(17, 00, 00));
				} else if (Integer.parseInt(entrada.nextLine()) == 2) {
					s.setHorario(LocalTime.of(19, 30, 00));
				} else if (Integer.parseInt(entrada.nextLine()) == 3) {
					s.setHorario(LocalTime.of(22, 00, 00));
				}
				sessoes.add(s);
				filmes[contadorFilmes] = filme;
				contadorFilmes = contadorFilmes++;
				listafilmes.setFilmes(filmes);
				System.out.println(
						"Deseja adicionar mais uma sessão? clique 0 para sim e qualquer outro número para não");
				controle = Integer.parseInt(entrada.nextLine());
			}
		}
		codigoFilme = codigoFilme++;
	}

	public void exibeSalas() {
		listaSalas.forEach((sala) -> {
			System.out.println(" ");
			System.out.print("Código: ");
			System.out.println(sala.getCodigo());
			System.out.print("Tipo Sala (1 para assento único e 2 para duplo): ");
			System.out.println(sala.getTipoSala());
			System.out.print("Fileiras: ");
			System.out.println(sala.getFileiras());
			System.out.print("Colunas: ");
			System.out.println(sala.getColunas());
			System.out.println(sala.getNumeroDeLugares());
		});
	}

	public void cadastraSala() {
		Sala sala = new Sala();
		sala.setCodigo(codigoSala);
		System.out.println("Tipo Sala (1 para assento único e 2 para duplo): ");
		sala.setTipoSala(entrada.nextLine());
		System.out.println("Fileiras: ");
		sala.setFileiras(Integer.parseInt(entrada.nextLine()));
		System.out.println("Colunas: ");
		sala.setColunas(Integer.parseInt(entrada.nextLine()));
		sala.setNumeroDeLugares(sala.getColunas() * sala.getFileiras());
		listaSalas.add(sala);
		salas.setSalas(listaSalas);
		System.out.println("Cadastrado");
		exibeSalas();
		codigoSala = codigoSala++;
	}
	
	public void apagaSessao(int filme) {
		for (int i = 0; i < sessoes.size(); i++) {		
				if ((sessoes.get(i).getFilme().getCodigo()).equals(filme)) {
					sessoes.remove(sessoes.get(i));
				}
			}
		}
	public void exibeAtendentes() {
		atendentes.forEach((a)->{
			System.out.println("");
			System.out.print("Código: ");
			System.out.println(a.getCodigoAtendente());
			System.out.print("Nome: ");
			System.out.println(a.getNome());
			System.out.print("CPF");
			System.out.println(a.getCpf());
		});
	}
	
	public void cadastraAtendente() {
		Atendente a = new Atendente();
		a.setCodigo(codigoAtendente);
		System.out.println("Nome: ");
		a.setNome(entrada.nextLine());
		System.out.println("CPF");
		a.setCpf(entrada.nextLine());
		atendentes.add(a);
		codigoAtendente = codigoAtendente++;
	}
	
	public void calculaRendimento() {
		
		pedido.forEach((p)->{
			soma = soma + p.getPreco();
		});
		System.out.println("Soma: " + soma);
		soma = 0f;
	}
	

}
