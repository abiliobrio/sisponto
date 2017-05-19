package model;

import java.util.ArrayList;
import java.util.Scanner;

import exception.SalarioInvalidoException;

public class Administrativo extends Pessoa {
	
	private double salario;
	
	public Administrativo() {
		super();
	}
	

	public Administrativo(String nome, String cpf, String matricula, double salario) {
		super(nome, cpf, matricula);
		this.salario = salario;
	}


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString(){
		
		String saida = "Administrativo" + '\t' + super.toString() + " " + "Salario: R$ " + String.format( "%.2f",this.salario);
		
		return saida;		
	}


	@Override
	public Administrativo cadastro() {

		System.out.println("*** Novo Administrativo *** ");		
		
		Administrativo administrativo;
		
		String nome = new String();
		String cpf = new String();
		String matricula = new String();
     	ArrayList<Curso> cursos = new ArrayList<Curso>();
		Double salario = 0.0;
	
		Scanner inputNome = new Scanner(System.in);
		Scanner inputCpf = new Scanner(System.in);
		Scanner inputMatricula= new Scanner(System.in);

		System.out.println("Informe o nome: ");
		nome = inputNome.next();
		System.out.println("Informe o CPF: ");
		cpf = inputCpf.next();
		System.out.println("Informe o matricula: ");
		matricula = inputMatricula.next();

		Scanner inputSalario = new Scanner(System.in);
		
		while (true){
			
			System.out.println("Informe o salario: ");
			salario = inputSalario.nextDouble();
			
			administrativo = new Administrativo(nome, cpf, matricula, salario);
			
			try{
			   validSalario(salario);
			   System.out.println(administrativo.toString());
			   
			   break;
				
			} catch (SalarioInvalidoException e){
				System.out.println(e.getMsg());
			}
		}
		return administrativo;
	}

}
