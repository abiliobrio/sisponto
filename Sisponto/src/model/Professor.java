package model;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.javafx.css.CalculatedValue;

import exception.SalarioInvalidoException;

public class Professor extends Pessoa{
	
	private ArrayList<Curso> cursos = new ArrayList<>();
	public static int HORA_AULA = 40;

	private Double salario;
	
	public Professor(){
		super();
	}

	public Professor(String nome, String cpf, String matricula, ArrayList<Curso> cursos, Double salario) {
		super(nome, cpf, matricula);
		this.cursos = cursos;
		this.salario = calcSalario();
	}

	public ArrayList<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(ArrayList<Curso> cursos) {
		this.cursos = cursos;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Double calcSalario(){

		int totHoras = 0;		

		for (Curso curso : this.cursos) {
			totHoras += curso.getHoras();
		}

		return (double) (HORA_AULA * totHoras); 
	}

	@Override
	public String toString() {
		
		String saida = "Professor" + '\t' + super.toString() + ", Salario: R$ " + String.format( "%.2f",this.salario);
		
		for (Curso curso : this.cursos) {
			saida += '\n' + curso.toString();
		}
		
		return saida;
	}

	@Override
	public Professor cadastro() {

		System.out.println("*** Novo Professor *** ");
		
		Professor professor;;
		
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

		while (true){
			
			try{
				
				cursos = curso.inputCursos("Professor");

				professor = new Professor(nome, cpf, matricula, cursos,calcSalario()); 

				validSalario(professor.getSalario());

				System.out.println(professor.toString());
				break;
				
			} catch (SalarioInvalidoException e){
				System.out.println(e.getMsg());
			}
   
		}
	
		return professor;
	}


}
