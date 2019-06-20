package model;

public class Item {
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
		return subTotal;
	}
	public void setSubTotal() {
		this.subTotal = this.produto.getPreco()*this.quantidade;
	}
	
}
