package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
	
	private String nome;
	private int horas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	@Override
	public String toString() {
		return '\t' + "Curso: " + nome + '\t' + "Horas=" + horas;
	}

	public ArrayList<Curso> inputCursos(String tipo){
		
		ArrayList<Curso> listaCursos = new ArrayList<Curso>();
		
		int opcao = 0;
		Scanner input = new Scanner(System.in);

		while (true){
			
			System.out.println("Selecione [1] para inserir um curso para o " + tipo + " ou [0] para finalizar");
			opcao = input.nextInt();
			
			if (opcao == 1){
			
				System.out.println("*** Cursos ***");
				
				Scanner inputCurso = new Scanner(System.in);
				Scanner inputHoras = new Scanner(System.in);
				
				System.out.println("Informe o nome do curso:");
				String nome = (String) inputCurso.next();
				
				System.out.println("Informe a carga horária do curso: ");
				int horas = inputHoras.nextInt();
				
				Curso curso = new Curso();
				curso.setNome(nome);
				curso.setHoras(horas);
				
				listaCursos.add(curso);
			} else if (opcao == 0)
				break;
			else
				System.out.println('\t' + "Opção inválida!!");			
		}
		
		return listaCursos;
	}

	
}
