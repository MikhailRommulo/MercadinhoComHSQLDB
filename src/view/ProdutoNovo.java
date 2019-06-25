package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProdutoNovo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textDescricao;
	private JTextField textMarca;
	private JTextField textSetor;
	private JTextField textFornecedor;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProdutoNovo dialog = new ProdutoNovo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProdutoNovo() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodigo = new JLabel("C\u00F3digo:");
			lblCodigo.setBounds(10, 11, 46, 14);
			contentPanel.add(lblCodigo);
		}
		
		textCodigo = new JTextField();
		textCodigo.setBounds(86, 8, 174, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setBounds(10, 42, 66, 14);
		contentPanel.add(lblDescricao);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(86, 39, 338, 20);
		contentPanel.add(textDescricao);
		textDescricao.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 73, 46, 14);
		contentPanel.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(85, 70, 175, 20);
		contentPanel.add(textMarca);
		textMarca.setColumns(10);
		
		textSetor = new JTextField();
		textSetor.setBounds(86, 101, 174, 20);
		contentPanel.add(textSetor);
		textSetor.setColumns(10);
		
		textFornecedor = new JTextField();
		textFornecedor.setBounds(86, 132, 174, 20);
		contentPanel.add(textFornecedor);
		textFornecedor.setColumns(10);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(10, 104, 46, 14);
		contentPanel.add(lblSetor);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 135, 46, 14);
		contentPanel.add(lblPreco);
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setBounds(10, 167, 66, 14);
		contentPanel.add(lblValidade);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(86, 167, 23, 14);
		contentPanel.add(lblDia);
		
		textDia = new JTextField();
		textDia.setBounds(119, 164, 30, 20);
		contentPanel.add(textDia);
		textDia.setColumns(10);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(184, 167, 33, 14);
		contentPanel.add(lblMs);
		
		textMes = new JTextField();
		textMes.setBounds(217, 163, 30, 20);
		contentPanel.add(textMes);
		textMes.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(227, 167, -12, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(163, 167, 11, 14);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("/");
		label_2.setBounds(257, 167, 11, 14);
		contentPanel.add(label_2);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(278, 167, 23, 14);
		contentPanel.add(lblAno);
		
		textAno = new JTextField();
		textAno.setBounds(311, 164, 56, 20);
		contentPanel.add(textAno);
		textAno.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
