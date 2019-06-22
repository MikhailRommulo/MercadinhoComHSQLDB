package control;

import java.util.ArrayList;

import model.Item;
import model.Produto;
import model.dao.ProdutoDAO;
import view.PDVTela;

public class ControlePDV {
	
	private ArrayList<Item> itens = new ArrayList<>();
	private Produto produto;
	private double total;
	
	public void adicionaItem(String codigo) {
		ProdutoDAO buscar = new ProdutoDAO();
		Produto produto  = buscar.buscarProduto(codigo);
		this.produto = produto;
		Item item = new Item();
		item.setProduto(produto);
		armazenaItens(item); 
		
	}
	
	public String descricaoProduto() {
		return this.produto.getDescricao();
	}
	
	
	private void armazenaItens(Item item) {
		boolean podeEstarNalista = true;
		if(itens.isEmpty()) {
			item.setQuantidade(1);
			this.itens.add(item);
		}else {			
			for(Item i: itens) {				
				if(item.getProduto().getCodigo().equals(i.getProduto().getCodigo())) {					
					podeEstarNalista = false;
					mudarQuantidade(item);
					break;
				}
			}
			if(podeEstarNalista) {
				item.setQuantidade(1);
				this.itens.add(item);
			}
		}
	}
	
	private void mudarQuantidade(Item item) {
		for(int i = 0; i<itens.size();i++) {
			if(item.getProduto().getCodigo().equals(itens.get(i).getProduto().getCodigo())) {
				itens.get(i).setQuantidade(itens.get(i).getQuantidade()+1);
			}
		}
	}
	
	public ArrayList<Item> getItens() {
		return this.itens;
	}
}
