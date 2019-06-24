package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Item;

public class TableModelItem extends AbstractTableModel{
	private ArrayList<Item> listaDeItens;
	private String[] colunas = {"Produto","Preço","Quantidade","Total"};

	public TableModelItem() {
		this.listaDeItens = new ArrayList<>();
	}
	
	public void receberListaDeItens(ArrayList<Item> list) {
		this.listaDeItens = list;
		fireTableDataChanged();
	}
	
	public List<Item> pegarListaDeItens(){
		return this.listaDeItens;
	}
	
	public Item pegarItem(int rowIndex) {
		return this.listaDeItens.get(rowIndex);
	}
	
	public void removerItem(int rowIndex) {
		this.listaDeItens.remove(rowIndex);
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaDeItens.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {			
			case 0:
				return this.listaDeItens.get(rowIndex).getProduto().getDescricao();
			case 1:
				return this.listaDeItens.get(rowIndex).getProduto().getPreco();
			case 2:
				return this.listaDeItens.get(rowIndex).getQuantidade();
			case 3:
				return this.listaDeItens.get(rowIndex).getSubTotal();
			default:
				return this.listaDeItens.get(rowIndex);
		}
		
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

}
