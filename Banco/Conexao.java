package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String user;
	private String url;
	private String psw;
	private String driver;
	
	public Connection con = null;
	
	public Connection conectar() {
		url = "jdbc:mysql://localhost:3306/banco?characterEncoding=utf8&useSSL=false&useUnicode=true";
		user = "root";
		psw = "";
		driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, psw);
			System.out.println("Conectado com sucesso! ");
			
		} catch (ClassNotFoundException Driver) {
			System.out.println("Erro não foi possível achar o driver de conexão."+Driver);
			
		} catch (SQLException erro) {
			System.out.println("Erro não foi possível se conectar com o DB."+erro);
		}
		
		return con;
	}
	
	public static void main (String [] args) {
		
		Conexao conecta = new Conexao();
		conecta.conectar();
	}
}