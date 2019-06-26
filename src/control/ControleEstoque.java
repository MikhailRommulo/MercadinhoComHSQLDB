package control;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Produto;
import model.dao.ProdutoDAO;

public class ControleEstoque {
	
	public void novoProduto(Produto p) {
		ProdutoDAO pd = new ProdutoDAO();
		try {
			pd.create(p);
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
