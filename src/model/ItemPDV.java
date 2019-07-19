package model;

public class ItemPDV {
	private Produto produto;
	private int quantidade;
	private double subTotal;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getSubTotal() {
		subTotal = this.quantidade*this.produto.getPreco();
		return subTotal;
	}
	
}
