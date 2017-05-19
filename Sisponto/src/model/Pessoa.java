package model;

import exception.SalarioInvalidoException;

public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String matricula;

	public Pessoa(){
		super();
	}
	
	public Pessoa(String nome, String cpf, String matricula) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Nome=" + nome + ", CPF=" + cpf + ", Matricula=" + matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public abstract Pessoa cadastro();

	public void validSalario(Double salario) throws SalarioInvalidoException{
		if (salario < 0 )
			throw new SalarioInvalidoException();
	}
	
	
}
