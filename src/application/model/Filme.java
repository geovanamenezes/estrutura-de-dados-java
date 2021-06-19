package application.model;

public class Filme {
	private Integer codigo;
	private String titulo;
	private String anoLancamento;
	private String sinopse;
	private String genero;
	private Atendente atendente;
	private int quantidade = 0;

	public Filme(Integer codigo, String titulo, String anoLancamento, String sinopse, String genero, Atendente atendente){
		this.codigo = codigo;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.sinopse = sinopse;
		this.genero = genero;
		this.atendente = atendente;
	}
	
	public Filme(){
	}

	public String getTitulo() {
		return this.titulo;
	}
	public Integer getCodigo(){
		return this.codigo;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	//criar

	//alterar

	//excluir

	//verificar
}

