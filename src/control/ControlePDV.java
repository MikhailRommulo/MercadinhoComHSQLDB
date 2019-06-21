package control;

import java.util.ArrayList;

import model.Item;
import model.Produto;
import model.dao.ProdutoDAO;

public class ControlePDV {
	
	private ArrayList<Item> itens = new ArrayList<>();
	
	public void adicionaItem(String codigo) {
		ProdutoDAO buscar = new ProdutoDAO();
		Produto produto  = buscar.buscarProduto(codigo);
		Item item = new Item();
		item.setProduto(produto);
		armazenaItens(item);
	}
	
	public void armazenaItens(Item item) {
		boolean podeEstarNalista = true;
		if(itens.isEmpty()) {			
			this.itens.add(item);		 
		}else {			
			for(Item i: itens) {				
				if(item.getProduto().equals(i.getProduto())) {					
					podeEstarNalista = false;					
					break;
				}
			}
			if(podeEstarNalista) {
				this.itens.add(item);
			}
		}
	}
	
	
	public ArrayList<Item> getItens() {
		return itens;
	}
}
