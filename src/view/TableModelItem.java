package view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ItemPDV;

public class TableModelItem extends AbstractTableModel{
	private ArrayList<ItemPDV> listaDeItens;
	private String[] colunas = {"Produto","Pre�o","Quantidade","Total"};

	public TableModelItem() {
		this.listaDeItens = new ArrayList<>();
	}
	
	public void receberListaDeItens(ArrayList<ItemPDV> list) {
		this.listaDeItens = list;
		fireTableDataChanged();
	}
	
	public List<ItemPDV> pegarListaDeItens(){
		return this.listaDeItens;
	}
	
	public ItemPDV pegarItem(int rowIndex) {
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
				return NumberFormat.getCurrencyInstance().format(this.listaDeItens.get(rowIndex).getProduto().getPreco());
			case 2:
				return this.listaDeItens.get(rowIndex).getQuantidade();
			case 3:
				return NumberFormat.getCurrencyInstance().format(this.listaDeItens.get(rowIndex).getSubTotal());
			default:
				return this.listaDeItens.get(rowIndex);
		}
		
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

}
