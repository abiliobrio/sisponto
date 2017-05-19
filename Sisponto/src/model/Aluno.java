package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Pessoa {
	

	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, String matricula, ArrayList<Curso> cursos) {
		super(nome, cpf, matricula);
		this.cursos = cursos;
	}

	private ArrayList<Curso> cursos = new ArrayList<>();
	
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		
		String saida = "Aluno" + '\t' + super.toString();
		
		
		for (Curso curso : this.cursos) {
			saida += '\n' + curso.toString();
		}
	
		return saida;
	}

	@Override
	public Aluno cadastro() {

		System.out.println("*** Novo Aluno ***");
	
		String nome = new String();
		String cpf = new String();
		String matricula = new String();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
	
		Scanner inputNome = new Scanner(System.in);
		Scanner inputCpf = new Scanner(System.in);
		Scanner inputMatricula= new Scanner(System.in);

		System.out.println("Informe o nome: ");
		nome = inputNome.next();
		System.out.println("Informe o CPF: ");
		cpf = inputCpf.next();
		System.out.println("Informe o matricula: ");
		matricula = inputMatricula.next();
		
		Curso curso = new Curso();
		cursos = curso.inputCursos("Aluno");
	
		Aluno aluno = new Aluno(nome,cpf,matricula,cursos);
		
		System.out.println(aluno.toString());
		
		return aluno;
		
	}

}
