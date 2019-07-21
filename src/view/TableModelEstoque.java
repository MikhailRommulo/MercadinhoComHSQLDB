package view;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.ItemEstoque;

public class TableModelEstoque extends AbstractTableModel{
	
	private ArrayList<ItemEstoque> listaDeItensEstoque;
	private String[] colunas = {"Código","Produto","Marca","Setor","Preço","Quantidade"};
	
	public TableModelEstoque() {
		this.listaDeItensEstoque = new ArrayList<ItemEstoque>();
	}
	
	public void receberListaDeItensEstoque(ArrayList<ItemEstoque> list) {
		this.listaDeItensEstoque = list;
		fireTableDataChanged();
	}
	
	public ArrayList<ItemEstoque> pegarListaDeItensEstoque(){
		return this.listaDeItensEstoque;
	}
	
	public ItemEstoque pegarItemEstoque(int rowIndex) {
		return this.listaDeItensEstoque.get(rowIndex);
	}
	
	public void removerItemEstoque(int rowIndex) {
		this.listaDeItensEstoque.remove(rowIndex);
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public int getRowCount() {
		return this.listaDeItensEstoque.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				return this.listaDeItensEstoque.get(rowIndex).getProduto().getCodigo();
			case 1:
				return this.listaDeItensEstoque.get(rowIndex).getProduto().getDescricao();
			case 2:
				return this.listaDeItensEstoque.get(rowIndex).getProduto().getMarca();
			case 3:
				return this.listaDeItensEstoque.get(rowIndex).getProduto().getSetor();
			case 4:
				return NumberFormat.getCurrencyInstance().format(this.listaDeItensEstoque.get(rowIndex).getProduto().getPreco());
			case 5:
				return this.listaDeItensEstoque.get(rowIndex).getQuantidade();
			default:
				return this.listaDeItensEstoque.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}
	
	
}
