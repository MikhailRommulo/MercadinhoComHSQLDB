package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPdvpontoDeVenda = new JButton("PDV(Ponto de venda)");
		btnPdvpontoDeVenda.setFont(new Font("Arial", Font.BOLD, 16));
		btnPdvpontoDeVenda.setIcon(new ImageIcon("images.png"));
		btnPdvpontoDeVenda.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPdvpontoDeVenda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPdvpontoDeVenda.setBounds(50, 100, 200, 100);
		frame.getContentPane().add(btnPdvpontoDeVenda);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setFont(new Font("Arial", Font.BOLD, 16));
		btnEstoque.setIcon(new ImageIcon("estoque.PNG"));
		btnEstoque.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEstoque.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEstoque.setBounds(300, 100, 200, 100);
		frame.getContentPane().add(btnEstoque);
		
		JButton btnRelatorios = new JButton("Relat\u00F3rios");
		btnRelatorios.setFont(new Font("Arial", Font.BOLD, 16));
		btnRelatorios.setIcon(new ImageIcon("relatorio.png"));
		btnRelatorios.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnRelatorios.setHorizontalTextPosition(SwingConstants.CENTER);;
		btnRelatorios.setBounds(550, 100, 200, 100);
		frame.getContentPane().add(btnRelatorios);
		
		JButton btnPromocoes = new JButton("Promo\u00E7\u00F5es");
		btnPromocoes.setIcon(new ImageIcon("promocao.png"));
		btnPromocoes.setFont(new Font("Arial", Font.BOLD, 16));
		btnPromocoes.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPromocoes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPromocoes.setBounds(133, 300, 200, 100);
		frame.getContentPane().add(btnPromocoes);
		
		JButton btnEmpresaDados = new JButton("Dados da empresa");
		btnEmpresaDados.setIcon(new ImageIcon("empresa.png"));
		btnEmpresaDados.setFont(new Font("Arial", Font.BOLD, 16));
		btnEmpresaDados.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEmpresaDados.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEmpresaDados.setBounds(466, 300, 200, 100);
		frame.getContentPane().add(btnEmpresaDados);
	}
}