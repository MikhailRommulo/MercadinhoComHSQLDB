package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Produto;
import model.dao.ProdutoDAO;

public class ControleProduto {
	
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
	
	public ArrayList<Produto> pesquisa(String pesquisa, String opcao){
		ProdutoDAO pd = new ProdutoDAO();
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			produtos = pd.read(pesquisa, opcao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produtos;
		
	}
}
