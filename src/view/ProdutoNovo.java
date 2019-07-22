package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControleProduto;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ProdutoNovo extends JDialog {

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
		setBounds(100, 100, 450, 242);
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
		
		textPreco = new JTextField();
		textPreco.setBounds(86, 132, 174, 20);
		contentPanel.add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setBounds(10, 104, 46, 14);
		contentPanel.add(lblSetor);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setBounds(10, 135, 46, 14);
		contentPanel.add(lblPreco);
		
		JLabel label = new JLabel("/");
		label.setBounds(227, 167, -12, 14);
		contentPanel.add(label);
		
		JLabel lblusePontoPara = new JLabel("(use ponto para os centavos)");
		lblusePontoPara.setBounds(270, 135, 154, 14);
		contentPanel.add(lblusePontoPara);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCadastrar = new JButton("Cadastrar");
				btnCadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Produto produto = new Produto();
						produto.setCodigo(textCodigo.getText());
						produto.setDescricao(textDescricao.getText());
						produto.setMarca(textMarca.getText());
						produto.setSetor(textSetor.getText());
						produto.setPreco(Double.parseDouble(textPreco.getText()));
						
						ControleProduto cp = new ControleProduto();
						cp.novoProduto(produto);
						
					}
				});
				btnCadastrar.setActionCommand("OK");
				buttonPane.add(btnCadastrar);
				getRootPane().setDefaultButton(btnCadastrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
