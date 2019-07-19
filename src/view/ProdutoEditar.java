package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControleProduto;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutoEditar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textDescricao;
	private JTextField textMarca;
	private JTextField textSetor;
	private JTextField textPreco;

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
	
	public void receberDados(Produto p) {
		textCodigo.setText(p.getCodigo());
		textDescricao.setText(p.getDescricao());
		textMarca.setText(p.getMarca());
		textSetor.setText(p.getSetor());
		textPreco.setText(String.valueOf(p.getPreco()));
	}

	/**
	 * Create the dialog.
	 */
	public ProdutoEditar() {
		setBounds(100, 100, 450, 229);
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
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(10, 117, 67, 14);
		contentPanel.add(lblPreo);
		
		textPreco = new JTextField();
		textPreco.setBounds(80, 114, 178, 20);
		contentPanel.add(textPreco);
		textPreco.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Produto produto = new Produto();
						produto.setCodigo(textCodigo.getText());
						produto.setDescricao(textDescricao.getText());
						produto.setMarca(textMarca.getText());
						produto.setSetor(textSetor.getText());
						produto.setPreco(Double.parseDouble(textPreco.getText()));
						
						ControleProduto cp = new ControleProduto();
						cp.editar(produto);
					}
				});
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
