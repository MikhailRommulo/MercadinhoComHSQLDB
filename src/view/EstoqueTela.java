package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControleEstoque;
import control.ControleProduto;
import model.ItemEstoque;

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

public class EstoqueTela extends JFrame {

	private JPanel contentPane;
	private JTable tabProdutos;
	private JTextField textPesquisa;
	private TableModelEstoque tableModelEstoque;

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
		this.tableModelEstoque = new TableModelEstoque();
		this.tabProdutos.setModel(tableModelEstoque);
		ajustarLarguraColunas();		
	}
	
	private void ajustarLarguraColunas() {
		tabProdutos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabProdutos.getColumnModel().getColumn(0).setPreferredWidth(110);
        tabProdutos.getColumnModel().getColumn(1).setPreferredWidth(435);
        tabProdutos.getColumnModel().getColumn(2).setPreferredWidth(241);
        tabProdutos.getColumnModel().getColumn(3).setPreferredWidth(225);
        tabProdutos.getColumnModel().getColumn(4).setPreferredWidth(70);
        tabProdutos.getColumnModel().getColumn(4).setPreferredWidth(75);
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
		comboTipoPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Descri\u00E7\u00E3o", "C\u00F3digo", "Marca", "Setor"}));
		comboTipoPesquisa.setBounds(10, 11, 155, 32);
		contentPane.add(comboTipoPesquisa);
		
		textPesquisa = new JTextField();
		textPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				ControleEstoque ce = new ControleEstoque();
				String opcao = (String) comboTipoPesquisa.getSelectedItem();
				tableModelEstoque.receberListaDeItensEstoque(ce.pesquisa(textPesquisa.getText(), opcao));				
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
				ControleEstoque ce = new ControleEstoque();
				ce.excluir(tableModelEstoque.pegarItemEstoque(tabProdutos.getSelectedRow()));
				tableModelEstoque.removerItemEstoque(tabProdutos.getSelectedRow());
			}
		});
		btnExcluirProduto.setBounds(163, 718, 143, 32);
		contentPane.add(btnExcluirProduto);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControleProduto cp = new ControleProduto();
				ItemEstoque ie = tableModelEstoque.pegarItemEstoque(tabProdutos.getSelectedRow());
				cp.receberProduto(ie.getProduto());
			}
		});
		btnNewButton.setBounds(10, 718, 143, 32);
		contentPane.add(btnNewButton);
	}
}
