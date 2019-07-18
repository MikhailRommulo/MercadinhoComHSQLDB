package view;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Produto;

public class TableModelProduto extends AbstractTableModel {
	
	private ArrayList<Produto> listaDeProdutos;
	private String[] colunas = {"Código","Descrição","Marca","Setor","Preço"};
	
	public TableModelProduto() {
		this.listaDeProdutos = new ArrayList<>();
	}
	
	public void receberListaDeProdutos(ArrayList<Produto> list) {
		this.listaDeProdutos = list;
		fireTableDataChanged();
	}
	
	public ArrayList<Produto> pegarListaDeProdutos(){
		return this.listaDeProdutos;
	}
	
	public Produto pegarProduto(int rowIndex) {
		return this.listaDeProdutos.get(rowIndex);
	}
	
	public void removerProduto(int rowIndex) {
		this.listaDeProdutos.remove(rowIndex);
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.listaDeProdutos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0:
				return this.listaDeProdutos.get(rowIndex).getCodigo();
			case 1:
				return this.listaDeProdutos.get(rowIndex).getDescricao();
			case 2:
				return this.listaDeProdutos.get(rowIndex).getMarca();
			case 3:
				return this.listaDeProdutos.get(rowIndex).getSetor();
			case 4:
				return NumberFormat.getCurrencyInstance().format(this.listaDeProdutos.get(rowIndex).getPreco());			
			default:
				return this.listaDeProdutos.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

}
