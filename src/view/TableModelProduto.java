package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Produto;

public class TableModelProduto extends AbstractTableModel {
	
	private ArrayList<Produto> listaDeProdutos;
	private String[] colunas = {"Código","Descrição","Fornecedor","Marca","Preço","Setor","Validade"};
	
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
				return this.listaDeProdutos.get(rowIndex).getFornecedor().getNomeFantasia();
			case 3:
				return this.listaDeProdutos.get(rowIndex).getMarca();
			case 4:
				return this.listaDeProdutos.get(rowIndex).getPreco();
			case 5:
				return this.listaDeProdutos.get(rowIndex).getSetor();
			case 6:
				return this.listaDeProdutos.get(rowIndex).getValidade();
			default:
				return this.listaDeProdutos.get(rowIndex);
		}
	}
	
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

}
