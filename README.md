# Loja

A loja fictícia Tudo de Bom está construindo uma nova plataforma e precisa de uma API para gerenciar as transações. Utilize suas novas habilidades com Java e SoftSkills.
O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais, dados para contato e controle de estoque.

ENTREGAS MÍNIMAS

Back-end:

Cadastro de clientes

Listagem de clientes

Atualização de clientes

Deletar clientes

Histórico de transações entre contas

Controle de estoque

Medicamentos genéricos contêm 20% de desconto.

Gerais:

O código deve ser entregue em um repositório no Github.

A API deve conter todos os Métodos GET, PUT, POST, DELETE

Liste os endpoints no README.md

Testes automatizados, podem ser testes unitários ou testes de integração.

 
CRITÉRIOS DE AVALIAÇÃO

 
Documentação da Aplicação;

Endpoints 

Conexão 

public class Conexao {
	private String user;
	private String url;
	private String psw;
	private String driver;
	
	public Connection con = null;
	
	public Connection conectar() {
		url = "jdbc:mysql://localhost:3306/banco?characterEncoding=utf8&useSSL=false&useUnicode=true";
		user = "root";
		psw = "1997";
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

