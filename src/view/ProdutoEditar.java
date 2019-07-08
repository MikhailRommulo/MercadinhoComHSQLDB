package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ProdutoEditar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textDescricao;
	private JTextField textMarca;
	private JTextField textSetor;
	private JTextField textFornecedor;
	private JTextField textPreco;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProdutoEditar dialog = new ProdutoEditar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProdutoEditar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(10, 11, 50, 14);
			contentPanel.add(lblCdigo);
		}
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(80, 8, 178, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(10, 36, 67, 14);
		contentPanel.add(lblDescrio);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(80, 33, 344, 20);
		contentPanel.add(textDescricao);
		textDescricao.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 61, 46, 14);
		contentPanel.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBounds(80, 58, 178, 20);
		contentPanel.add(textMarca);
		textMarca.setColumns(10);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(10, 86, 46, 14);
		contentPanel.add(lblSetor);
		
		textSetor = new JTextField();
		textSetor.setBounds(80, 83, 178, 20);
		contentPanel.add(textSetor);
		textSetor.setColumns(10);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(10, 111, 67, 14);
		contentPanel.add(lblFornecedor);
		
		textFornecedor = new JTextField();
		textFornecedor.setBounds(80, 108, 178, 20);
		contentPanel.add(textFornecedor);
		textFornecedor.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 136, 67, 14);
		contentPanel.add(lblPreo);
		
		textPreco = new JTextField();
		textPreco.setBounds(80, 133, 178, 20);
		contentPanel.add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setBounds(10, 170, 67, 14);
		contentPanel.add(lblValidade);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(80, 170, 24, 14);
		contentPanel.add(lblDia);
		
		textDia = new JTextField();
		textDia.setBounds(114, 167, 30, 20);
		contentPanel.add(textDia);
		textDia.setColumns(10);
		
		JLabel label = new JLabel("/");
		label.setBounds(151, 170, 11, 14);
		contentPanel.add(label);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(172, 170, 24, 14);
		contentPanel.add(lblMs);
		
		textMes = new JTextField();
		textMes.setBounds(206, 167, 30, 20);
		contentPanel.add(textMes);
		textMes.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(246, 170, 11, 14);
		contentPanel.add(label_1);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(267, 170, 24, 14);
		contentPanel.add(lblAno);
		
		textAno = new JTextField();
		textAno.setBounds(292, 167, 30, 20);
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
