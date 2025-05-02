import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
		static Scanner sc = new Scanner(System.in);
		static List<Aluno> alunos = new ArrayList<>();
		static List<Curso> cursos = Arrays.asList(

            new Curso("1", "Desenvolvimento de Sistemas."),
            new Curso("2", "Administração."),
            new Curso("3", "Mecânica.")
				);
		
		public String NomeCurso(int codcurso) {
			
		    for (Curso curso : cursos) {  	
		        if (Integer.valueOf(curso.getCodigo()) == codcurso) { 
		            return curso.getNome();
		        }
		    }
		    return null; 
		}
		
		public Boolean ExisteID(int id) {
			
		    for (Aluno aluno : alunos) {	 
		        if (aluno.getId() == id) { 
		            return true;
		        }
		    }
		    return false; 
		}
		
		public Boolean ExisteMatricula(int matricula) {	
			
			boolean achou = false;
		    for (Aluno aluno : alunos) {
		        if (aluno.getMatricula() == matricula) { 
		            achou = true;	          
		        }   
		    }
		    return achou; 
		}
		

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			Main main = new Main();
			
			int id = 0;
			int qnt = 0;
			boolean Valido = false;
			
			System.out.println("|------------Sistema de Cadastro de Alunos------------|");
			System.out.println();
			System.out.println("(Considere a matrícula como tendo 5 números).");
			
			while (!Valido) {
				
				try {
				System.out.print("Digite quantos alunos você deseja adicionar: ");
				qnt = sc.nextInt();
				
					if (qnt < 0) {
						System.err.println("O valor não pode ser negativo.");
					
					} else if (qnt >= 0){
						Valido = true;
					}  
				
				} catch (InputMismatchException e) {
					System.err.println("Caractere inválido.");
					sc.nextLine();
				}
			}	
			System.out.println();
	
			for (int i = 0; i < qnt; i++) {
				
				System.out.print("Nome: ");
				String nome = sc.next();
				sc.nextLine();
				
				int matricula;
				int codigoCurso; 
				
				while (true) {
					System.out.print("Matrícula: ");
					matricula = sc.nextInt();		
				
						if (matricula < 10000 || matricula > 99999) {
							System.err.println("Matrícula inválida.(Matrícula precisa ser composta por 5 números.)");
						}
						else {
							if (main.ExisteMatricula(matricula)) {
								System.err.println("Essa matrícula já existe.");
							} else {
								break;
							}
						}
				}
				
				while (true) {
					for (Curso curso : cursos) {
						System.out.println(curso.getCodigo() + " - " + curso.getNome());
					}
					
					System.out.print("Curso: ");
					codigoCurso = sc.nextInt();
					
						if (codigoCurso <1 || codigoCurso > 3) {
							System.err.println("Opção Inválida.");
						}
						else {
							break;
						}
				}
				alunos.add(new Aluno(id, nome, matricula, codigoCurso));
				id = id + 1;
				System.out.println();
			}
			
			
			boolean Verdade = false;
			while (!Verdade) {
				
					System.out.println();
					System.out.println("------------------------------------------------------|");
					System.out.println("Menu:");
					System.out.println("1 - Adicionar aluno(a).");
					System.out.println("2 - Editar aluno(a).");
					System.out.println("3 - Listar alunos.");
					System.out.println("4 - Excluir aluno(a).");
					System.out.println("5 - Sair.");
					System.out.print("Opção: ");
					int opcao = sc.nextInt();
					System.out.println();
					
					switch (opcao) {
					case 1: 
						int matricula;
						int codigoCurso;
						
						System.out.print("Nome: ");
						String nome = sc.next();
						sc.nextLine();
						
						while (true) {
							System.out.print("Matrícula: ");
							matricula = sc.nextInt();		
						
							if (matricula < 10000 || matricula > 99999) {
								System.err.println("Matrícula inválida.(Matrícula precisa ser composta por 5 números.)");
							}
							else {
								if (main.ExisteMatricula(matricula)) {
									System.err.println("Essa matrícula já existe.");	
								} else {
									break;
								}
							}
						}
						
						while (true) {
							for (Curso curso : cursos) {
								System.out.println(curso.getCodigo() + " - " + curso.getNome());
							}
							
							System.out.print("Curso: ");
							codigoCurso = sc.nextInt();
							
								if (codigoCurso <1 || codigoCurso > 3) {
									System.err.println("Código Inválido");
								}
								else {
									break;
								}
						}
						alunos.add(new Aluno(id,nome, matricula, codigoCurso));
						id = id + 1;
						break;
					
					case 2: 
						while (true) {
							System.out.println("Alunos Cadastrados:");
							
								for (Aluno aluno : alunos) {
									System.out.println("ID: " + aluno.getId() + ", Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + ", Curso: " + main.NomeCurso(aluno.getCurso()) );
								}
							
								System.out.println();
								System.out.print("Digite o ID do aluno você deseja editar: ");
								int iD = sc.nextInt();
								sc.nextLine();
							
									if (main.ExisteID(iD)) {
										for (Aluno aluno : alunos) {
											
											if (iD == aluno.getId()) {						
											while (true){
													System.out.println();
													System.out.println("1 - Nome.");
													System.out.println("2 - Matrícula.");
													System.out.println("3 - Curso.");
													System.out.println("4 - Sair.");
													System.out.print("Editar: ");
													int resp = sc.nextInt();
													System.out.println();
													
													if (resp < 4) {
														aluno.Editar(resp);
													}
													else if(resp == 4) {
														break;
													} else if (resp > 4 || resp < 1) {
														System.err.println("Opção inválida.");
													}
												}
											}
										} } else {
										System.err.println("ID não existe.");
										System.out.println();
										}	
							break;
						}
						break;
					
					case 3: 
						System.out.println();
						for (Aluno aluno : alunos) {
							System.out.println("ID: " + aluno.getId() + ", Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + ", Curso: " + main.NomeCurso(aluno.getCurso()) );
						}
						break;
					
					case 4: 
						int ide;
						while (true) {
							System.out.println("Alunos Cadastrados:");
						
							for (Aluno aluno : alunos) {
								System.out.println("ID: " + aluno.getId() + ", Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + ", Curso: " + main.NomeCurso(aluno.getCurso()) );
							}
						
							System.out.println();
							System.out.print("Digite o ID do aluno que você deseja excluir: ");
							ide = sc.nextInt();
							
								if (main.ExisteID(ide)) {
									break;
								}else {
									System.err.println("ID não existe.");
									System.out.println();
								}
						}	
					
						
							try {
								
					        	for (int i = 0; i < alunos.size(); i++) {
					        		
					        		if (alunos.get(i).getId() == ide) {
										System.out.println();
										System.out.println("Tem certeza que deseja excluir? ");
										System.out.print("1 - Sim | 2 - Não: ");
										int resp =sc.nextInt();
												
										if(resp == 1) {
											alunos.remove(i);
											System.out.println("Aluno removido.");
											break;
										}
									}
								}
								
							} catch (InputMismatchException e) {
								System.err.println("ID inválido.");
							}
							break;
						
					case 5: {
						System.out.println("|----------------Programa finalizado------------------|");
						Verdade = true;
						break;
					}	
						
					default:
						System.err.println("Opção inválida!");
						break;	
					} 
				
			}
			sc.close();
	
		}
}


