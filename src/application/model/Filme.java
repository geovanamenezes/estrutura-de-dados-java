package application.model;

public class Filme {
	private int codigo;
	private String titulo;
	private String anoLancamento;
	private String sinopse;
	private String genero;
	private Atendente atendente;

	public Filme(int codigo, String titulo, String anoLancamento, String sinopse, String genero, Atendente atendente){
		this.codigo = codigo;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.genero = genero;
		this.atendente = atendente;
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

