import java.util.List;
import java.util.Scanner;


public class Aluno {

	static Scanner sc = new Scanner(System.in);
	
	private int matricula;
	private String nome;
	private int curso;
	private int id = 0;
	
    public Aluno(int id, String nome, int matricula, int codigoCurso) {
    	this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = codigoCurso;
    }


	public void Editar(int resp) {	
		
		switch (resp) {
		case 1:
			System.out.print("Digite o novo nome: ");
			this.nome = sc.next();
			sc.nextLine();
			break;
			
		case 2:
			try {
			System.out.print("Digite a nova matrícula: ");
			this.matricula = sc.nextInt();
			sc.nextLine();
			
				if (this.matricula < 10000 || this.matricula > 99999) {
					System.err.println("Matrícula inválida.(Matrícula precisa ser composta por 5 números.)");}
				} catch (Exception e) {
					System.out.println("Caractere inválido!");
				}
			
			break;
			
		case 3:
			try {
				System.out.println();
				System.out.println("1 - Desenvolvimento de Sistemas.");
				System.out.println("2 - Administração.");
				System.out.println("3 - Mecânica.");
				System.out.print("Digite o novo curso: ");
				this.curso = sc.nextInt();
				sc.nextLine();
			
					if (curso > 3 || curso < 1) {
						System.err.println("Opção inválida;");
					}
					
			} catch (Exception e) {
				System.out.println("Caractere inválido!");
			}
			
			break;
			
		default:
			System.err.println("Opção inválida.");
			break;
		}
		
	}
	
	
	
	public void MostrarAlunos(List<Aluno> alunos) {
		for (Aluno aluno : alunos) {
			System.out.println(aluno);
		}
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {

		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String i) {
		this.nome = i;
	}
	
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Aluno " + id + ": Matrícula: " + matricula + ", Nome: " + nome + ", Curso: " + curso + ".";
	}
	
}
