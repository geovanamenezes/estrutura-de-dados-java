package application.model;

public class Atendente {
    private int codigoAtendente;
    private String nome;
    private String cpf;

    public Atendente(int codAtendente,String nome,String cpf){
        this.codigoAtendente=codAtendente;
        this.nome=nome;
        this.cpf=cpf;
    }
    
	public int getCodigoAtendente() {
        return codigoAtendente;
    }

    public void setCodigo(int codigoAtendente){
        this.codigoAtendente=codigoAtendente;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(String nome){
        this.nome=nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf=cpf;
    }






}
