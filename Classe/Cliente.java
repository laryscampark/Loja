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
	
	public void insert() {
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
}
