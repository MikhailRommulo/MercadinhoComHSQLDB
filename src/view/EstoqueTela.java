package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class EstoqueTela extends JFrame {

	private JPanel contentPane;
	private JTextField textPesquisa;	
	private JTable tableProdutos;
	private TableModelEstoque tableItensEstoque;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
			public void run() {
				try {
					EstoqueTela frame = new EstoqueTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EstoqueTela() {
		initialize();
		this.tableItensEstoque = new TableModelEstoque();
		this.tableProdutos.setModel(tableItensEstoque);
		ajustarLarguraColunas();
		
	}
	
	private void ajustarLarguraColunas() {
		tableProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(60);
        tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(60);
        tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(90);
        tableProdutos.getColumnModel().getColumn(3).setPreferredWidth(60);
        tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(90);
        tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(90);
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboTipoDePesquisa = new JComboBox();
		comboTipoDePesquisa.setBounds(5, 5, 220, 31);
		contentPane.add(comboTipoDePesquisa);
		
		textPesquisa = new JTextField();
		textPesquisa.setBounds(235, 6, 939, 30);
		contentPane.add(textPesquisa);
		textPesquisa.setColumns(10);
		
		tableProdutos = new JTable();
		tableProdutos.setRowHeight(30);
		
		JScrollPane scrollPane = new JScrollPane(tableProdutos);
		scrollPane.setBounds(5, 55, 1169, 589);
		contentPane.add(scrollPane);
		
		JButton btnAumentarQuantidade = new JButton("Aumentar quantidade");
		btnAumentarQuantidade.setBounds(20, 657, 171, 23);
		contentPane.add(btnAumentarQuantidade);
		
		JButton btnDiminuirQuantidade = new JButton("Diminuir quantidade");
		btnDiminuirQuantidade.setBounds(20, 691, 171, 23);
		contentPane.add(btnDiminuirQuantidade);
		
		JButton btnEditarItem = new JButton("Editar item");
		btnEditarItem.setBounds(201, 657, 115, 23);
		contentPane.add(btnEditarItem);
		
		JButton btnEntradaDeProdutos = new JButton("Entrada de produtos");
		btnEntradaDeProdutos.setBounds(458, 657, 155, 23);
		contentPane.add(btnEntradaDeProdutos);
	}
}
