package application.model;
public class Sala {
	private int codigo;
	private String tipoSala;
	private int numeroDeLugares;

	public Sala(){
		
	}
	public Sala(int codigo, String tipoSala, int numeroDeLugares){
		this.codigo = codigo;
		this.tipoSala = tipoSala;
		this.numeroDeLugares = numeroDeLugares;
	}


	public int getNumeroDeLugares() {
		return this.numeroDeLugares;
	}


	public int getCodigo() {
		return this.codigo;
	}

}