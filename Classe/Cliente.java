package Classe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Banco.Conexao;
import java.sql.SQLException;

public class Cliente {

	int id;
	String nome;
	String email;
	String whats;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhats() {
		return whats;
	}

	public void setWhats(String whats) {
		this.whats = whats;
	}

	Conexao conecta = new Conexao();

	public void insert(String nome, String email, String whats) {
		try {
			conecta.conectar();
			String sql = "insert into clientes (nome, email, whats) values (?,?,?)";
			PreparedStatement stm = conecta.con.prepareStatement(sql);

			stm.setString(1,nome);
			stm.setString(2,email);
			stm.setString(3,whats);

			stm.execute();

			System.out.println("Dados cadastrados com sucesso!");
			stm.close();

		}catch(SQLException erro) {
			System.out.println("Erro, não foi possível cadastrar."+erro);
		}
	}

	public void consultar () {
		try {
			conecta.conectar();
			String sql = "select nome, email, whats, id from clientes where id = ?";

			PreparedStatement stm = conecta.con.prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();

			if (rs.next()) {
				this.setNome(rs.getString("nome"));
				this.setEmail(rs.getString("email"));
				this.setWhats(rs.getString("whats"));
			}
			stm.close();
		} catch (SQLException erro) {
			System.out.println("Não foi possivel encontrar os dados." +erro);
		}
	}

	public void atualizar (String nome, String email, String whats) {
		System.out.println(nome);

		try {
			conecta.conectar();
			String sql = ("UPDATE clientes SET nome= '" +nome+"', email= '"+email+"', whats= '"+whats+"' WHERE id=" +id+ ";");

			PreparedStatement stm = conecta.con.prepareStatement(sql);

			stm.executeUpdate();

			System.out.println("Dados atualizados com sucesso");

		} catch (SQLException erro) {
			System.out.println("Erro não foi possivel atualizar os dados."+erro);
		}
	}

	public void excluir () {
		try{
			conecta.conectar();
			String sql = "delete from clientes where id = ?";

			PreparedStatement stm = conecta.con.prepareStatement(sql);

			stm.setInt(1, id);
			stm.execute();

			System.out.println("Dados excluidos com sucesso");

		} catch (SQLException erro) {
			System.out.println("Erro não foi possivel excluir os dados."+erro);
		}
	}

}
