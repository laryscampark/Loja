package Banco;

import Classe.Cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class FormularioCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField email;
	private JTextField whats;
	private JButton btnNewButton_1;
	
	Conexao conecta = new Conexao();
	
	Cliente cli = new Cliente();
	

	Connection con;
	private JButton delete;
	private JTextField id;
	private JButton Atualizar;
	private JButton Buscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioCliente frame = new FormularioCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioCliente() {
		setTitle("Cadastro ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(134, 104, 46, 14);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setBounds(190, 102, 196, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(134, 135, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(190, 132, 196, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contato");
		lblNewLabel_3.setBounds(134, 179, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		whats = new JTextField();
		whats.setBounds(190, 176, 196, 20);
		contentPane.add(whats);
		whats.setColumns(10);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setBounds(515, 353, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio tela = new Inicio();
				tela.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton inserir = new JButton("");
		inserir.setBackground(Color.WHITE);
		inserir.setIcon(new ImageIcon("C:\\Users\\laryssa.silva\\Downloads\\icons8-adicionar-propriedade-48.png"));
		inserir.setBounds(40, 353, 70, 43);
		inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					conecta.conectar();
					String sql = "insert into clientes (nome, email, whats) values (?,?,?)";
					PreparedStatement stm = conecta.con.prepareStatement(sql);

					stm.setString(1,nome.getText());
					stm.setString(2,email.getText());
					stm.setString(3,whats.getText());


					stm.execute();

					System.out.println("Dados cadastrados com sucesso!");
					stm.close();
					
					dispose();

				}catch(SQLException erro) {
					System.out.println("Erro, não foi possível cadastrar."+erro);
				}
			}
			
			
			
			
		});
		contentPane.add(inserir);
		
		delete = new JButton("Excluir");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					conecta.conectar();
					String sql = "delete from clientes where id = ?";

					PreparedStatement stm = conecta.con.prepareStatement(sql);

					stm.setString(1, id.getText());;
					stm.execute();

					System.out.println("Dados excluidos com sucesso");
					dispose();

				} catch (SQLException erro) {
					System.out.println("Erro não foi possivel excluir os dados."+erro);
				}
			
			}
			
		});
		delete.setBounds(409, 354, 85, 21);
		contentPane.add(delete);
		
		id = new JTextField();
		id.setBounds(218, 60, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(134, 63, 46, 14);
		contentPane.add(lblId);
		
		Atualizar = new JButton("Atualizar");
		Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexao conecta = new Conexao();
				conecta.conectar();
				System.out.println(nome);

				try {
					conecta.conectar();
					String sql = ("UPDATE clientes SET nome= '" +nome+"', email= '"+email+"', whats= '"+whats+"' WHERE id=" +id+ ";");

					PreparedStatement stm = conecta.con.prepareStatement(sql);

					stm.executeUpdate();

					System.out.println("Dados atualizados com sucesso");
					dispose();

				} catch (SQLException erro) {
					System.out.println("Erro não foi possivel atualizar os dados."+erro);
				}
			}
		});
		Atualizar.setBounds(301, 354, 85, 21);
		contentPane.add(Atualizar);
		
		Buscar = new JButton("Buscar");
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Conexao conecta = new Conexao();
					conecta.conectar();
					String sql = "select nome, email, whats, id from clientes where id = ?";

					PreparedStatement stm = conecta.con.prepareStatement(sql);
					stm.setString(1, id.getText());
					ResultSet rs = stm.executeQuery();
					

					if (rs.next()) {
						/*
						 * this.setNome(rs.getString("nome")); this.setEmail(rs.getString("email"));
						 * this.setWhats(rs.getString("whats"));
						 */
						dispose();
					}
					stm.close();
				} catch (SQLException erro) {
					System.out.println("Não foi possivel encontrar os dados." +erro);
				}
			
			}

		});
		Buscar.setBounds(157, 354, 85, 21);
		contentPane.add(Buscar);
}
}

