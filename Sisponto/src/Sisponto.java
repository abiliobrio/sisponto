import java.util.ArrayList;
import java.util.Scanner;

import exception.SalarioInvalidoException;
import model.Administrativo;
import model.Aluno;
import model.Pessoa;
import model.Professor;

public class Sisponto {

	public static void main(String[] args) {

		ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		
		int opcao = 0;
		Scanner input = new Scanner(System.in);
		
		do {
			
			menu();
			
			opcao = input.nextInt();

			switch (opcao){
			case 1:
				consulta(listaPessoa);
				break;
			case 2:
				novoAluno(listaPessoa);
				break;
			case 3:
				novoProfessor(listaPessoa);
				break;
			case 4:
				novoAdministrativo(listaPessoa);
				break;
			case 0: 
				System.out.println("Sistema encerrado com sucesso!!!!");
//				exibeDados(listaPessoa);
				break;
			default:
				System.out.println("Opção inválida!!!");
			} 
						
		} while(opcao != 0);
		
	}
	
	public static void menu() {
		
		System.out.println("========================= M E N U =========================");
		
		System.out.println("[1] Consultar dados de uma pessoa");
		System.out.println("[2] Cadastrar novo aluno");
		System.out.println("[3] Cadastrar novo professor");
		System.out.println("[4] Cadastrar novo administrativo");
		System.out.println("[0] Sair");	
		System.out.print("Selecione uma opção:");
	}
	
	public static void consulta(ArrayList<Pessoa> listaPessoa){
		
		System.out.println("*** Consulta de Pessoa ***");
		
		String matricula = new String();
		System.out.println("Informe uma matricula: ");
		
		Scanner input = new Scanner(System.in);
		matricula = input.next();	
		
		for (Pessoa pessoa : listaPessoa) {
			
			if (pessoa.getMatricula().equals(matricula)){
				System.out.println(pessoa.toString());
				break;
			}
		}
		
	}
	
	public static void novoAluno(ArrayList<Pessoa> listaPessoa){
		
		Pessoa aluno = new Aluno().cadastro();
		listaPessoa.add(aluno);
	
	}
	
	public static void novoProfessor(ArrayList<Pessoa> listaPessoa){
	
		Pessoa professor = new Professor().cadastro();
		listaPessoa.add(professor);
	}

	public static void novoAdministrativo(ArrayList<Pessoa> listaPessoa){
		
		Pessoa administrativo = new Administrativo().cadastro();
		listaPessoa.add(administrativo);
	}
	
	public void validSalario(Double salario) throws SalarioInvalidoException{
		if (salario < 0 )
			throw new SalarioInvalidoException();
	}
	
/*	public static void exibeDados(ArrayList<Pessoa> listaPessoa){
	
		for (Pessoa pessoa : listaPessoa) {
			
			System.out.println(pessoa.toString());
		}
	}*/
	
}
