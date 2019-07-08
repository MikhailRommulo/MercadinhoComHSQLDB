package control;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;
import model.dao.ProdutoDAO;

public class ControleProduto {
	
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
