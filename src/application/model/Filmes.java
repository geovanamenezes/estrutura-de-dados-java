package application.model;

public class Filmes {
	private Filme filmes[] = new Filme[4];
	private int quantidade;
	public Filmes() {}
	
	public Filme[] apagaFilme(Filme filme, Filme filmes[]) {
		Filme novosFilmes[] = new Filme[4];
		int cont = 0;
		for(int i=0; i< filmes.length; i++) {
			if(!filme.equals(filmes[i])) {
				novosFilmes[cont] = filmes[i];
				cont++;
			}
		}
		this.quantidade = cont;
		this.filmes = novosFilmes;
		return this.filmes;
	}

	public Filme[] getFilmes() {
		return filmes;
	}
	
	public void adicionaFilme() {
		this.quantidade = this.quantidade + 1; 
	}

	public void setFilmes(Filme[] filmes) {
		this.filmes = filmes;
		this.quantidade = filmes.length; 

	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
