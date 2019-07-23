package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frmMercadinho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMercadinho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMercadinho = new JFrame();
		frmMercadinho.setTitle("Mercadinho");
		frmMercadinho.setBounds(100, 100, 529, 179);
		frmMercadinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMercadinho.getContentPane().setLayout(null);
		
		JButton btnPdvpontoDeVenda = new JButton("PDV(Ponto de venda)");
		btnPdvpontoDeVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PDVTela frame = new PDVTela();
				frame.setVisible(true);
			}
		});
		btnPdvpontoDeVenda.setFont(new Font("Arial", Font.BOLD, 16));
		btnPdvpontoDeVenda.setIcon(new ImageIcon("images.png"));
		btnPdvpontoDeVenda.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPdvpontoDeVenda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPdvpontoDeVenda.setBounds(10, 11, 200, 100);
		frmMercadinho.getContentPane().add(btnPdvpontoDeVenda);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstoqueTela frame = new EstoqueTela();
				frame.setVisible(true);
			}
		});
		btnEstoque.setFont(new Font("Arial", Font.BOLD, 16));
		btnEstoque.setIcon(new ImageIcon("estoque.PNG"));
		btnEstoque.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEstoque.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEstoque.setBounds(303, 11, 200, 100);
		frmMercadinho.getContentPane().add(btnEstoque);;
	}
}