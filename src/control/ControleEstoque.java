package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ItemEstoque;
import model.Produto;
import model.dao.ItensEstoqueDAO;
import view.ProdutoEditar;

public class ControleEstoque {
	
	public ArrayList<ItemEstoque> pesquisa(String pesquisa, String opcao){
		ItensEstoqueDAO ied = new ItensEstoqueDAO();
		ArrayList<ItemEstoque> listaDeItensEstoque = new ArrayList<>();
		try {
			listaDeItensEstoque = ied.read(pesquisa, opcao);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaDeItensEstoque;
	}
	
	public void excluir(ItemEstoque ie) {
		ItensEstoqueDAO ied = new ItensEstoqueDAO();
		try {
			ied.delete(ie);
			JOptionPane.showMessageDialog(null, "Item excluído!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
