package Banco;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 484, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tudo de Bom");
		lblNewLabel.setBounds(162, 70, 161, 34);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 29));
		
		JButton Clientela = new JButton("Cliente");
		Clientela.setBounds(189, 277, 85, 21);
		Clientela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormularioCliente tela = new FormularioCliente();
				tela.setVisible(true);
				dispose();
			}
		});
		panel.add(Clientela);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(159, 115, 147, 119);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jamna\\OneDrive\\Área de Trabalho\\download.png"));
		panel.add(btnNewButton);
	}
}
