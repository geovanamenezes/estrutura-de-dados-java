package application.model;

public class Filme {
	private int codigo;
	private String titulo;
	private String anoLancamento;
	private String sinopse;
	private String genero;
	private Atendente atendente;
	private int quantidade = 0;

	public Filme(int codigo, String titulo, String anoLancamento, String sinopse, String genero, Atendente atendente){
		this.codigo = codigo;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.genero = genero;
		this.atendente = atendente;
		this.quantidade = this.quantidade + 1; 
	}

	public String getTitulo() {
		return this.titulo;
	}
	public int getCodigo(){
		return this.codigo;
	}

	//criar

	//alterar

	//excluir

	//verificar
}

