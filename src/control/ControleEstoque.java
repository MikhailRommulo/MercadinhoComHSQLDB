package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ItemEstoque;
import model.dao.ItensEstoqueDAO;

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
		if(ie.getQuantidade() == 0) {
			ItensEstoqueDAO ied = new ItensEstoqueDAO();
			try {
				ied.delete(ie);
				JOptionPane.showMessageDialog(null, "Item excluído!");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null,"Produto para ser excluído precisa estar com a quantidade igual a zero!");
		}
		
	}
	
	public void aumentarQuantidade(ItemEstoque ie, int quantidade) {
		ie.setQuantidade(ie.getQuantidade()+quantidade);
		ItensEstoqueDAO ied = new ItensEstoqueDAO();
		try {
			ied.update(ie);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void diminuirQuantidade(ItemEstoque ie, int quantidade) {
		if(ie.getQuantidade() >= quantidade) {
			ie.setQuantidade(ie.getQuantidade()-quantidade);
			ItensEstoqueDAO ied = new ItensEstoqueDAO();
			try {
				ied.update(ie);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Quantidade para subtrair maior que a quantidade no produto selecionado!");
		}		
	}
	
	public void zerarQuantidade(ItemEstoque ie) {
		ie.setQuantidade(0);
		ItensEstoqueDAO ied = new ItensEstoqueDAO();
		try {
			ied.update(ie);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editarQuantidade(ItemEstoque ie, int quantidade) {
		if(quantidade >= 0) {
			ie.setQuantidade(quantidade);
			ItensEstoqueDAO ied = new ItensEstoqueDAO();
			try {
				ied.update(ie);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null,"Quantidade não pode ser menor que zero!");
		}
		
	}
	
}
