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

}