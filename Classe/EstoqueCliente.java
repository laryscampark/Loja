package Classe;

import Banco.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueCliente {
	int id_produto;
	String nome_produto;
	int qtd_produto;
	double valor_produto;
	String md_generico;
	String md_marca;

	private Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset = null;

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public int getQtd_produto() {
		return qtd_produto;
	}

	public void setQtd_produto(int qtd_produto) {
		this.qtd_produto = qtd_produto;
	}

	public double getValor_produto() {
		return valor_produto;
	}

	public void setValor_produto(double valor_produto) {
		this.valor_produto = valor_produto;
	}

	public String getMd_generico() {
		return md_generico;
	}

	public void setMd_generico(String md_generico) {
		this.md_generico = md_generico;
	}

	public String getMd_marca() {
		return md_marca;
	}

	public void setMd_marca(String md_marca) {
		this.md_marca = md_marca;
	}

	public Conexao getConecta() {
		return conecta;
	}

	public void setConecta(Conexao conecta) {
		this.conecta = conecta;
	}

	Conexao conecta = new Conexao();

	public void insert() {
		try {
			conecta.conectar();
			String query = "Insert into produtos";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();

			while (this.resultset.next()) {
				String meuID = resultset.getString("id");
				String meuProduto = resultset.getString("produtos");

				System.out.println("id" + meuID);
				System.out.println("produto" + meuProduto);
			}

		} catch (Exception e) {
			System.out.println("erro" + e.getMessage());
		}

	}

	public void consultar() {
		try {
			conecta.conectar();
			String sql = "select nome_produto, qtd_produto, valor_produto, md_generico, md_marca, id_produto from produtos where id_produto = ?";

			PreparedStatement stm = conecta.con.prepareStatement(sql);
			stm.setInt(1, id_produto);
			ResultSet rs = stm.executeQuery();

			if (rs.next()) {
				this.setNome_produto(rs.getString("nome_produto"));
				this.setQtd_produto(rs.getInt("qtd_produto"));
				this.setValor_produto(rs.getDouble("valor_produto"));
				this.setMd_generico(rs.getString("md_generico"));
				this.setMd_marca(rs.getString("md_marca"));
			}
			stm.close();

		} catch (SQLException erro) {
			System.out.println("Não foi possivel encontrar os dados." + erro);
		}
	}

	public void atualizar(String nome_produto, int qtd_produto, double valor_produto, String md_generico,
			String md_marca) {
		System.out.println(nome_produto);
		try {
			conecta.conectar();
			String sql = ("UPDATE produtos SET nome_produto= '" + nome_produto + "', qtd_produto= '" + qtd_produto
					+ "', valor_produto= '" + valor_produto + "', md_generico= '" + md_generico + "', md_marca= '"
					+ md_marca + "' WHERE id_produto=" + id_produto + ";");

			PreparedStatement stm = conecta.con.prepareStatement(sql);

			stm.executeUpdate();

			System.out.println("Dados atualizados com sucesso");

		} catch (SQLException erro) {
			System.out.println("Erro não foi possivel atualizar os dados." + erro);
		}
	}
	public void listarProdutos() {
		try {
			
			conecta.conectar();
			 String sql = "select * from produto where id_produto = ?" ;
			PreparedStatement stm = conecta.con.prepareStatement(sql);
			stm.setInt(1, id_produto);
			ResultSet rs = stm.executeQuery();

			if (rs.next()) {
				this.setNome_produto(rs.getString("Nome "));
				this.setQtd_produto(rs.getInt("Quantidade de Mercadoria "));
				this.setValor_produto(rs.getDouble("Valor "));
				this.setMd_generico(rs.getString("É remédio génerico? (S/N) "));
				this.setMd_marca(rs.getString("É remédio marca? (S/N) "));
			}
			stm.close();
		} catch (SQLException erro) {
			System.out.println("Não foi possivel encontrar os dados." + erro);
		}
	
	}
	
	public void excluir() {
		try {
			conecta.conectar();
			String sql = "delete from produtos where id_produto = ?";

			PreparedStatement stm = conecta.con.prepareStatement(sql);

			stm.setInt(1, id_produto);
			stm.execute();

			System.out.println("Dados excluidos com sucesso");

		} catch (SQLException erro) {
			System.out.println("Erro não foi possivel excluir os dados." + erro);
		}
	}

}