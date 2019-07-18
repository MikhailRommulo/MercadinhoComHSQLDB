package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControleProduto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProdutoTela extends JFrame {

	private JPanel contentPane;
	private JTable tabProdutos;
	private JTextField textPesquisa;
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
		ajustarLarguraColunas();		
	}
	
	private void ajustarLarguraColunas() {
		tabProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabProdutos.getColumnModel().getColumn(0).setPreferredWidth(110);
        tabProdutos.getColumnModel().getColumn(1).setPreferredWidth(530);
        tabProdutos.getColumnModel().getColumn(2).setPreferredWidth(241);
        tabProdutos.getColumnModel().getColumn(3).setPreferredWidth(225);
        tabProdutos.getColumnModel().getColumn(4).setPreferredWidth(55);
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
		comboTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Descri\u00E7\u00E3o", "Fornecedor", "C\u00F3digo", "Marca", "Setor"}));
		comboTipoPesquisa.setBounds(10, 11, 155, 32);
		contentPane.add(comboTipoPesquisa);
		
		textPesquisa = new JTextField();
		textPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ControleProduto cp = new ControleProduto();
				String opcao = (String) comboTipoPesquisa.getSelectedItem();
				tableModelProduto.receberListaDeProdutos(cp.pesquisa(textPesquisa.getText(), opcao));				
			}
		});
		textPesquisa.setBounds(197, 12, 977, 32);
		contentPane.add(textPesquisa);
		textPesquisa.setColumns(10);
		
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
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ControleProduto cp = new ControleProduto();
				cp.excluir(tableModelProduto.pegarProduto(tabProdutos.getSelectedRow()));
				tableModelProduto.removerProduto(tabProdutos.getSelectedRow());
			}
		});
		btnExcluirProduto.setBounds(163, 718, 143, 32);
		contentPane.add(btnExcluirProduto);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControleProduto cp = new ControleProduto();
				cp.receberProduto(tableModelProduto.pegarProduto(tabProdutos.getSelectedRow()));
			}
		});
		btnNewButton.setBounds(10, 718, 143, 32);
		contentPane.add(btnNewButton);
	}
}
