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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	private JTextField textTotDesconto;
	private JTextField textTotCompra;
	private JTextField textEntradaCodigo;
	private JTextField textCpf;
	private JTextField textResultadoProduto;

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
        
        JPanel panel = new JPanel();
        panel.setBounds(25, 632, 650, 40);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JButton btnR = new JButton("Remover");
        btnR.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		tableModelItem.removerItem(tabPdv.getSelectedRow());
        		ControlePDV controle = new ControlePDV();
        		controle.setItens(tableModelItem.pegarListaDeItens());        		
        	}
        });
        btnR.setBounds(518, 11, 122, 23);
        panel.add(btnR);
        ajustarLarguraColunas();
	}
	
	private void ajustarLarguraColunas() {
		tabPdv.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabPdv.getColumnModel().getColumn(0).setPreferredWidth(380);
        tabPdv.getColumnModel().getColumn(1).setPreferredWidth(60);
        tabPdv.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabPdv.getColumnModel().getColumn(3).setPreferredWidth(60);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		scrollPane.setBounds(25, 25, 650, 606);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setBounds(25, 707, 80, 20);
		lblDesconto.setFont(new Font("Arial", Font.BOLD, 16));
		
		textTotDesconto = new JTextField();
		textTotDesconto.setEditable(false);
		textTotDesconto.setBounds(115, 709, 86, 20);
		textTotDesconto.setFont(new Font("Arial", Font.PLAIN, 16));
		textTotDesconto.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(243, 712, 46, 14);
		lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
		
		textTotCompra = new JTextField();
		textTotCompra.setEditable(false);
		textTotCompra.setBounds(299, 709, 86, 20);
		textTotCompra.setFont(new Font("Arial", Font.PLAIN, 16));
		textTotCompra.setColumns(10);
		
		
		JComboBox<Object> comboBoxLeitor = new JComboBox<Object>();
		comboBoxLeitor.setBounds(700, 28, 28, 22);
		
		JComboBox<Object> comboBoxImpressora = new JComboBox<Object>();
		comboBoxImpressora.setBounds(950, 28, 28, 22);
		
		JButton btnConfirmar = new JButton("Confirmar compra");
		btnConfirmar.setBounds(975, 447, 180, 40);
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 16));
		
		JPanel panelAdicionaProduto = new JPanel();		
		panelAdicionaProduto.setForeground(new Color(0, 0, 0));
		panelAdicionaProduto.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Adicionar Produto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAdicionaProduto.setBounds(685, 139, 489, 109);		
		panelAdicionaProduto.setLayout(null);
		
		textEntradaCodigo = new JTextField();
		textEntradaCodigo.setBounds(10, 25, 176, 30);
		panelAdicionaProduto.add(textEntradaCodigo);
		textEntradaCodigo.setFont(new Font("Arial", Font.BOLD, 20));
		textEntradaCodigo.setColumns(10);
		
		ControlePDV controle = new ControlePDV();
		textEntradaCodigo.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(textEntradaCodigo.getText().length() == 13) {
					controle.adicionaItem(textEntradaCodigo.getText());
					textResultadoProduto.setText(controle.descricaoProduto());
					tableModelItem.receberListaDeItens(controle.getItens());
					textTotCompra.setText(String.valueOf(controle.totalNota()));					
				}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
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
		frame.getContentPane().add(comboBoxLeitor);
		frame.getContentPane().add(comboBoxImpressora);
		frame.getContentPane().add(btnConfirmar);
		frame.getContentPane().add(lblDesconto);
		frame.getContentPane().add(textTotDesconto);
		frame.getContentPane().add(lblTotal);
		frame.getContentPane().add(textTotCompra);
		
		JPanel panelCPF = new JPanel();
		panelCPF.setForeground(new Color(0, 0, 0));
		panelCPF.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CPF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));	
		panelCPF.setBounds(685, 259, 489, 109);
		frame.getContentPane().add(panelCPF);
		panelCPF.setLayout(null);
		
		textCpf = new JTextField();
		textCpf.setBounds(57, 41, 136, 25);
		panelCPF.add(textCpf);
		textCpf.setFont(new Font("Arial", Font.PLAIN, 16));
		textCpf.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(212, 40, 85, 27);
		panelCPF.add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setFont(new Font("Arial", Font.BOLD, 16));
		
	}
}