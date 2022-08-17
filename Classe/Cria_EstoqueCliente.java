package Classe;

import java.util.Scanner;

public class Cria_EstoqueCliente {
	public static void main(String[] args) {

		int i = 1;

		int op, id_produto, qtd_produto;
		double valor_produto;
		String nome_produto, md_generico, md_marca;

		EstoqueCliente estoque = new EstoqueCliente();

		Scanner ler = new Scanner(System.in);

		System.out.println("Cadastro do Produto");

		while (i == 1) {

			System.out.println("\nDigite: \n1-Cadastrar\n2-Consultar\n3-Atualizar\n4-Excluir\n");
			op = ler.nextInt();

			switch (op) {

			case 1:

				System.out.println("Nome: ");
				nome_produto = ler.next();
				estoque.setNome_produto(nome_produto);

				System.out.println("Quantidade de Mercadoria: ");
				qtd_produto = ler.nextInt();
				estoque.setQtd_produto(qtd_produto);

				System.out.println("Informe o valor: ");
				valor_produto = ler.nextDouble();
				estoque.setValor_produto(valor_produto);

				System.out.println("O remédio é genérico? ");
				md_generico = ler.next();
				estoque.setMd_generico(md_generico);

				System.out.println("É remédio? ");
				md_marca = ler.next();
				estoque.setMd_marca(md_marca);

				estoque.insert();

				break;

			case 2:

				System.out.println("Informe o id: ");
				id_produto = ler.nextInt();
				estoque.setId_produto(id_produto);

				estoque.consultar();

				System.out.println("Nome: " + estoque.getNome_produto());
				System.out.println("Quantidade de Mercadoria: " + estoque.getQtd_produto());
				System.out.println("Informe o valor: " + estoque.getValor_produto());
				System.out.println("É remédio de marca? " + estoque.getMd_marca());
				System.out.println("Genérico? " + estoque.getMd_generico());

			case 3:

				System.out.println("Digite o ID que deseja atualizar os dados");
				id_produto = ler.nextInt();
				estoque.setId_produto(id_produto);

				System.out.println("Nome: ");
				nome_produto = ler.next();
				estoque.setNome_produto(nome_produto);

				System.out.println("Quantidade de Mercadoria: ");
				qtd_produto = ler.nextInt();
				estoque.setQtd_produto(qtd_produto);

				System.out.println("Informe o valor: ");
				valor_produto = ler.nextDouble();
				estoque.setValor_produto(valor_produto);

				System.out.println("O remédio é genérico? ");
				md_generico = ler.next();
				estoque.setMd_generico(md_generico);

				System.out.println("É remédio? ");
				md_marca = ler.next();
				estoque.setMd_marca(md_marca);

				System.out.println(nome_produto);

				estoque.atualizar(nome_produto, qtd_produto, valor_produto, md_generico, md_marca);

			case 4:

				System.out.println("Entre com o Id : ");
				id_produto = ler.nextInt();
				estoque.setId_produto(id_produto);
				estoque.excluir();

			default:

				System.out.println("Opção inválida");

			}

			System.out.println("\nDigite:\n1-Continuar\n2-Sair\n");
			i = ler.nextInt();
		}
		System.out.println("Obrigado pela preferência, saindo do sistema.");
		ler.close();

	}

}