package Classe;

import java.util.Scanner;

public class Cria_EstoqueCliente {
    public static void main(String[] args) {

        int i = 1;

        int op, id_produto,qtd_merc;
        double valor;
        String nome_mec;
        boolean merc_generico, remedio;

        EstoqueCliente estoque = new EstoqueCliente();

        Scanner ler = new Scanner (System.in);

        System.out.println("Cadastro do Produto");

        while (i == 1) {

            System.out.println("\nDigite: \n1-Cadastrar\n2-Consultar\n3-Atualizar\n4-Excluir\n");
            op = ler.nextInt();

            switch (op) {

                case 1:

                    System.out.println("Nome: ");
                    nome_mec = ler.next();
                    estoque.setNome_mec(nome_mec);

                    System.out.println("Quantidade de Mercadoria: ");
                    qtd_merc = ler.nextInt();
                    estoque.setQtd_merc(qtd_merc);

                    System.out.println("Informe o valor: ");
                    valor = ler.nextDouble();
                    estoque.setValor(valor);

                    System.out.println("O remédio é genérico? ");
                    merc_generico = ler.nextBoolean();
                    estoque.setMerc_generico(merc_generico);

                    System.out.println("É remédio? ");
                    remedio = ler.nextBoolean();
                    estoque.setRemedio(remedio);

                    estoque.insert();

                    break;

                case 2:

                    System.out.println("Informe o id: ");
                    id_produto = ler.nextInt();
                    estoque.setId_produto(id_produto);

                    estoque.consultar();

                    System.out.println("Nome: "+estoque.getNome_mec());
                    System.out.println("Quantidade de Mercadoria: "+estoque.getQtd_merc());
                    System.out.println("Informe o valor: "+estoque.getValor());
                    System.out.println("O remédio é genérioco? "+estoque.getMerc_generico());
                    System.out.println("É remédio? "+estoque.getRemedio());

                    break;

                case 3:

                    System.out.println("Digite o ID que deseja atualizar os dados");
                    id_produto = ler.nextInt();
                    estoque.setId_produto(id_produto);

                    System.out.println("Nome: ");
                    nome_mec = ler.next();
                    estoque.setNome_mec(nome_mec);

                    System.out.println("Quantidade de Mercadoria: ");
                    qtd_merc = ler.nextInt();
                    estoque.setQtd_merc(qtd_merc);

                    System.out.println("Informe o valor: ");
                    valor = ler.nextDouble();
                    estoque.setValor(valor);

                    System.out.println("O remédio é genérico? ");
                    merc_generico = ler.nextBoolean();
                    estoque.setMerc_generico(merc_generico);

                    System.out.println("É remédio? ");
                    remedio = ler.nextBoolean();
                    estoque.setRemedio(remedio);

                    System.out.println(nome_mec);

                    estoque.atualizar(nome_mec, qtd_merc, valor,merc_generico,remedio);

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
        System.out.println("Obrigado pelo cadastro, saindo do sistema.");
        ler.close();

    }

}


