package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Produto;
import model.dao.ProdutoDAO;
import view.ProdutoEditar;

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
	
	public void receberProduto(Produto p) {
		ProdutoEditar frame = new ProdutoEditar();
		frame.receberDados(p);
		frame.setVisible(true);
	}
	
	public void editar(Produto p) {
		ProdutoDAO pd = new ProdutoDAO();
		try {
			pd.update(p);
			JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(Produto p) {
		ProdutoDAO pd = new ProdutoDAO();
		try {
			pd.delete(p);
			JOptionPane.showMessageDialog(null, "Produto excluído!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
