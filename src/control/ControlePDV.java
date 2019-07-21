package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemPDV;
import model.Produto;
import model.dao.ProdutoDAO;

public class ControlePDV {
	
	private ArrayList<ItemPDV> itens = new ArrayList<>();
	private Produto produto;
	
	public void setItens(List<ItemPDV> list) {
		this.itens = (ArrayList<ItemPDV>) list;
	}
	
	public void adicionaItem(String codigo) throws SQLException {
		ProdutoDAO buscar = new ProdutoDAO();
		Produto produto  = buscar.buscarProduto(codigo);
		this.produto = produto;
		ItemPDV ItemPDV = new ItemPDV();
		ItemPDV.setProduto(produto);
		if(ItemPDV.getProduto().getCodigo() != null) {
			armazenaItens(ItemPDV);
		}
	}
	
	public String descricaoProduto() {
		return this.produto.getDescricao();
	}
	
	
	private void armazenaItens(ItemPDV ItemPDV) {
		boolean podeEstarNalista = true;
		if(itens.isEmpty()) {
			ItemPDV.setQuantidade(1);
			this.itens.add(ItemPDV);
		}else {			
			for(ItemPDV i: itens) {				
				if(ItemPDV.getProduto().getCodigo().equals(i.getProduto().getCodigo())) {					
					podeEstarNalista = false;
					mudarQuantidade(ItemPDV);
					break;
				}
			}
			if(podeEstarNalista) {
				ItemPDV.setQuantidade(1);
				this.itens.add(ItemPDV);
			}
		}
	}
	
	private void mudarQuantidade(ItemPDV ItemPDV) {
		for(int i = 0; i<itens.size();i++) {
			if(ItemPDV.getProduto().getCodigo().equals(itens.get(i).getProduto().getCodigo())) {
				itens.get(i).setQuantidade(itens.get(i).getQuantidade()+1);
			}
		}
	}
	
	public double totalNota() {
		double total = 0;
		for(int i=0; i<this.itens.size();i++) {
			total+=this.itens.get(i).getSubTotal();
		}
		return total;
	}
	
	public ArrayList<ItemPDV> getItens() {
		return this.itens;
	}
}
