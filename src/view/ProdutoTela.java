package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutoTela extends JFrame {

	private JPanel contentPane;
	private JTable tabProdutos;
	private JTextField textField;
	private TableModelProduto tableModelProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoTela frame = new ProdutoTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProdutoTela() {
		initialize();
		this.tableModelProduto = new TableModelProduto();
		this.tabProdutos.setModel(tableModelProduto);
		
		JButton btnNovoProduto = new JButton("Novo Produto");
		btnNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoNovo frame = new ProdutoNovo();
				frame.setVisible(true);
			}
		});
		btnNovoProduto.setBounds(1019, 718, 155, 32);
		contentPane.add(btnNovoProduto);
		
		JButton btnExcluirProduto = new JButton("Excluir");
		btnExcluirProduto.setBounds(163, 718, 143, 32);
		contentPane.add(btnExcluirProduto);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setBounds(10, 718, 143, 32);
		contentPane.add(btnNewButton);
		
	}
	
	private void ajustarLarguraColunas() {
		tabProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabProdutos.getColumnModel().getColumn(0).setPreferredWidth(60);
        tabProdutos.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabProdutos.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabProdutos.getColumnModel().getColumn(3).setPreferredWidth(60);
        tabProdutos.getColumnModel().getColumn(4).setPreferredWidth(90);
        tabProdutos.getColumnModel().getColumn(5).setPreferredWidth(90);
        tabProdutos.getColumnModel().getColumn(6).setPreferredWidth(90);
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabProdutos = new JTable();
		tabProdutos.setRowHeight(30);
		
		JScrollPane scrollProdutos = new JScrollPane(tabProdutos);
		scrollProdutos.setBounds(10, 54, 1164, 653);
		contentPane.add(scrollProdutos);		
		
		JComboBox comboTipoPesquisa = new JComboBox();
		comboTipoPesquisa.setBounds(10, 11, 155, 32);
		contentPane.add(comboTipoPesquisa);
		
		textField = new JTextField();
		textField.setBounds(197, 12, 977, 32);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
