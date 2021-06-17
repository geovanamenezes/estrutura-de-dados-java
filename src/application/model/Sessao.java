package application.model;

import java.time.LocalTime;

public class Sessao {
	private Sala sala;
	private Filme filme;
	private LocalTime horario;
	private boolean[][] lugares;
	private int codigo;
	private int quantidadeLugares;
	private int lugaresPreenchidos = 0;

	

	public Sessao(int codigo, Sala sala, Filme filme, LocalTime horario) {
		this.codigo = codigo;
		this.sala = sala;
		this.filme = filme;
		this.horario = horario;
		
		if (sala.getCodigo() == 1) {
			this.lugares = new boolean[10][20];
			preencheSala1();
			this.quantidadeLugares = 200;

		}
		if (sala.getCodigo() == 2)
			this.lugares = new boolean[8][20];
			preencheSala2();
			this.quantidadeLugares = 160;

	}

	private void preencheSala1() {
		for (int l = 0; l < 20; l++) {
			for (int c = 0; c < 10; c++) {
				this.lugares[c][l] = false;
			}
		}
	}

	private void preencheSala2() {
		for (int l = 0; l < 20; l++) {
			for (int c = 0; c < 8; c++) {
				this.lugares[c][l] = false;
			}
		}
	}
	
	public boolean verificaSeTemLugar() {
		if(this.lugaresPreenchidos == this.quantidadeLugares) {
			return false;
		}
		return true;
	}
	
	public void adicionaLugar() {
		this.lugaresPreenchidos = this.lugaresPreenchidos+1;
	}
	
	public Filme getFilme() {
		return this.filme;
	}

	public boolean[][] getLugares() {
		return lugares;
	}

	public void setLugares(boolean[][] lugares) {
		this.lugares = lugares;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalTime getHorario() {
		return this.horario;
	}

	public Sala getSala() {
		return this.sala;
	}

	public int getCodigo() {
		return this.codigo;
	}
}
