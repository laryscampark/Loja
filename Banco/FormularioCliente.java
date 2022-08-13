package Banco;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormularioCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField TextCPF;
	private JTextField textContato;
	private JButton btnNewButton_1;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(41, 41, 46, 14);
		contentPane.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setBounds(97, 38, 196, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(41, 87, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(97, 84, 196, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(41, 132, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		TextCPF = new JTextField();
		TextCPF.setBounds(97, 129, 196, 20);
		contentPane.add(TextCPF);
		TextCPF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Contato");
		lblNewLabel_3.setBounds(41, 175, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textContato = new JTextField();
		textContato.setBounds(97, 172, 196, 20);
		contentPane.add(textContato);
		textContato.setColumns(10);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// enviardados inserir = 
			}
		});
		btnNewButton.setBounds(151, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(295, 215, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
