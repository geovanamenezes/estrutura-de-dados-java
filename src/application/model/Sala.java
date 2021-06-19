package application.model;

public class Sala {
	private int codigo;
	private String tipoSala;
	private int numeroDeLugares;
	private int fileiras;
	private int colunas;

	public Sala() {

	}

	public Sala(int codigo, String tipoSala, int numeroDeLugares, int fileiras, int colunas) {
		super();
		this.codigo = codigo;
		this.tipoSala = tipoSala;
		this.numeroDeLugares = numeroDeLugares;
		this.fileiras = fileiras;
		this.colunas = colunas;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getFileiras() {
		return fileiras;
	}

	public void setFileiras(int fileiras) {
		this.fileiras = fileiras;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNumeroDeLugares(int numeroDeLugares) {
		this.numeroDeLugares = numeroDeLugares;
	}

	public int getNumeroDeLugares() {
		return this.numeroDeLugares;
	}

	public int getCodigo() {
		return this.codigo;
	}

}