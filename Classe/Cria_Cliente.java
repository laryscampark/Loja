/*
 * package Classe; import java.util.Scanner; public class Cria_Cliente {
 * 
 * public static void main(String[] args) {
 * 
 * int i = 1;
 * 
 * int op, id;
 * 
 * String nome, email, whats;
 * 
 * Cliente cli = new Cliente ();
 * 
 * Scanner ler = new Scanner (System.in);
 * 
 * System.out.println("Cadastro do cliente");
 * 
 * while (i == 1) {
 * 
 * System.out.
 * println("\nDigite: \n1-Cadastrar\n2-Consultar\n3-Atualizar\n4-Excluir\n"); op
 * = ler.nextInt();
 * 
 * switch (op) {
 * 
 * case 1:
 * 
 * System.out.println("Nome: "); nome = ler.next(); cli.setNome(nome);
 * 
 * 
 * System.out.println("E-mail: "); email = ler.next(); cli.setEmail(email);
 * 
 * System.out.println("Whats: "); whats = ler.next(); cli.setWhats(whats);
 * 
 * 
 * cli.insert(nome, email, whats);
 * 
 * break;
 * 
 * case 2:
 * 
 * System.out.println("Informe o id: "); id = ler.nextInt(); cli.setId(id);
 * 
 * cli.consultar();
 * 
 * System.out.println("Nome: "+cli.getNome());
 * System.out.println("Email: "+cli.getEmail());
 * System.out.println("Whats: "+cli.getWhats());
 * 
 * 
 * break;
 * 
 * case 3:
 * 
 * System.out.println("Digite o ID que deseja atualizar os dados"); id =
 * ler.nextInt(); cli.setId(id);
 * 
 * System.out.println("Informe o nome: "); nome = ler.next(); cli.setNome(nome);
 * ler.nextLine();
 * 
 * System.out.println("Email: "); email = ler.next(); cli.setEmail(email);
 * ler.nextLine();
 * 
 * System.out.println("Whats: "); whats = ler.nextLine(); cli.setWhats(whats);
 * 
 * System.out.println(nome);
 * 
 * cli.atualizar(nome, email, whats);
 * 
 * case 4:
 * 
 * System.out.println("\nEntre com o Id : "); id = ler.nextInt(); cli.setId(id);
 * cli.excluir();
 * 
 * default:
 * 
 * System.out.println("Opção inválida");
 * 
 * }
 * 
 * System.out.println("\nDigite:\n1-Continuar\n2-Sair\n"); i = ler.nextInt(); }
 * System.out.println("Obrigado pelo cadastro, saindo do sistema.");
 * ler.close();
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 */