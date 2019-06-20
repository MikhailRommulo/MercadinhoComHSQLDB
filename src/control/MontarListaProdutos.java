package control;

import java.util.ArrayList;

import model.Produto;

public class MontarListaProdutos {
	
	private ArrayList<Produto> produtos = new ArrayList<>();
	

	public void armazenaProdutos(Produto produto) {
		boolean podeEstarNalista = true;
		if(produtos.isEmpty()) {			
			this.produtos.add(produto);		 
		}else {			
			for(Produto p: produtos) {				
				if(produto.getCodigo().equals(p.getCodigo())) {					
					podeEstarNalista = false;					
					break;
				}
			}
			if(podeEstarNalista) {
				this.produtos.add(produto);
			}
		}
	}
	
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
}
