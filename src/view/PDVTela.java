package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.ControlePDV;
import model.Produto;
import model.connection.ConnectionFactory;
import model.dao.ProdutoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class PDVTela {
	
	private TableModelItem tableModelItem;
	private JFrame frame;
	private JTable tabPdv;
	private JTextField textTotCompra;
	private JTextField textEntradaCodigo;
	private JTextField textResultadoProduto;
	private JTextField textTroco;
	private double total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDVTela window = new PDVTela();
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
	public PDVTela() {
		initialize();
		this.tableModelItem = new TableModelItem();
        this.tabPdv.setModel(tableModelItem);
        
        JButton btnValorRecebido = new JButton("Valor Recebido");
        btnValorRecebido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String valor = JOptionPane.showInputDialog("Valor recebido?");
        		double troco = Double.parseDouble(valor);
        		if(troco >= total) {
        			double resultadoTroco = troco - total;
            		textTroco.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(resultadoTroco)));
        		}else {
        			double pagamentoFaltando = total - troco;
        			JOptionPane.showMessageDialog(null,"Faltam "+NumberFormat.getCurrencyInstance().format(pagamentoFaltando)+" para completar o pagamento!");
        		}
        	}
        });
        btnValorRecebido.setFont(new Font("Arial", Font.BOLD, 16));
        btnValorRecebido.setBounds(804, 687, 180, 40);
        frame.getContentPane().add(btnValorRecebido);
        
        JLabel lblTroco = new JLabel("Troco:");
        lblTroco.setFont(new Font("Arial", Font.BOLD, 16));
        lblTroco.setBounds(20, 725, 63, 25);
        frame.getContentPane().add(lblTroco);
        
        textTroco = new JTextField();
        textTroco.setFont(new Font("Arial", Font.PLAIN, 16));
        textTroco.setEditable(false);
        textTroco.setBounds(76, 723, 130, 25);
        frame.getContentPane().add(textTroco);
        textTroco.setColumns(10);
        ajustarLarguraColunas();
	}
	
	private void ajustarLarguraColunas() {
		tabPdv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabPdv.getColumnModel().getColumn(0).setPreferredWidth(686);
        tabPdv.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabPdv.getColumnModel().getColumn(2).setPreferredWidth(75);
        tabPdv.getColumnModel().getColumn(3).setPreferredWidth(200);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ControlePDV controle = new ControlePDV();
		
		tabPdv = new JTable();
		tabPdv.setBounds(1, 26, 648, 16);
		tabPdv.setFont(new Font("Arial", Font.BOLD, 20));
		tabPdv.setRowMargin(5);		
		tabPdv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Coluna"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});		
		tabPdv.setRowHeight(30);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(tabPdv);
		
		JScrollPane scrollPane = new JScrollPane(tabPdv);
		scrollPane.setBounds(10, 131, 1164, 500);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(20, 690, 46, 14);
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		
		textTotCompra = new JTextField();
		textTotCompra.setEditable(false);
		textTotCompra.setBounds(76, 687, 130, 25);
		textTotCompra.setFont(new Font("Arial", Font.PLAIN, 16));
		textTotCompra.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar compra");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnConfirmar.setBounds(994, 687, 180, 40);
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel panelAdicionaProduto = new JPanel();		
		panelAdicionaProduto.setForeground(new Color(0, 0, 0));
		panelAdicionaProduto.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Adicionar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAdicionaProduto.setBounds(10, 11, 1164, 109);		
		panelAdicionaProduto.setLayout(null);
		
		textEntradaCodigo = new JTextField();
		textEntradaCodigo.setBounds(10, 25, 176, 30);
		panelAdicionaProduto.add(textEntradaCodigo);
		textEntradaCodigo.setFont(new Font("Arial", Font.BOLD, 20));
		textEntradaCodigo.setColumns(10);
		
		textEntradaCodigo.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						controle.adicionaItem(textEntradaCodigo.getText());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textResultadoProduto.setText(controle.descricaoProduto());
					tableModelItem.receberListaDeItens(controle.getItens());
					textTotCompra.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(controle.totalNota())));
					total = controle.totalNota();
					textEntradaCodigo.setText("");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
				String caracteres="0987654321";
			       if((!caracteres.contains(e.getKeyChar()+""))||(textEntradaCodigo.getText().length() >= 13 )){
			              e.consume();
			       }
				
			}
			
			
		});
		frame.getContentPane().add(panelAdicionaProduto);
		
		textResultadoProduto = new JTextField();
		textResultadoProduto.setEditable(false);
		textResultadoProduto.setForeground(new Color(0, 0, 0));
		textResultadoProduto.setBackground(SystemColor.control);
		textResultadoProduto.setBorder(new LineBorder(SystemColor.control));
		textResultadoProduto.setFont(new Font("Arial", Font.BOLD, 20));
		textResultadoProduto.setBounds(10, 66, 469, 32);
		panelAdicionaProduto.add(textResultadoProduto);
		textResultadoProduto.setColumns(10);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(btnConfirmar);
		frame.getContentPane().add(lblTotal);
		frame.getContentPane().add(textTotCompra);
		
		JPanel panelEditarRemover = new JPanel();
        panelEditarRemover.setBorder(new LineBorder(Color.GRAY));
        panelEditarRemover.setBounds(10, 632, 1164, 40);
        frame.getContentPane().add(panelEditarRemover);
        panelEditarRemover.setLayout(null);
        
        JButton btnR = new JButton("Remover");
        btnR.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tableModelItem.removerItem(tabPdv.getSelectedRow());
        		controle.setItens(tableModelItem.pegarListaDeItens());
        		textTotCompra.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(controle.totalNota())));
        		total = controle.totalNota();
        	}
        });
        btnR.setBounds(1032, 11, 122, 23);
        panelEditarRemover.add(btnR);
        
        JButton btnEditarQuantidade = new JButton("Editar quantidade");
        btnEditarQuantidade.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String quantidade = JOptionPane.showInputDialog("Editar quantidade");
        		controle.getItens().get(tabPdv.getSelectedRow()).setQuantidade(Integer.parseInt(quantidade));
        		tableModelItem.receberListaDeItens(controle.getItens());
        		textTotCompra.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(controle.totalNota())));
        		total = controle.totalNota();
        	}
        });
        btnEditarQuantidade.setBounds(848, 11, 174, 23);
        panelEditarRemover.add(btnEditarQuantidade);
		
	}
}