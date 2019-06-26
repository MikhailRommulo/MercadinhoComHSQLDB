package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.ItemFornecedor;

public class TableModelEstoque extends AbstractTableModel{
	
	private ArrayList<ItemFornecedor> listaDeItensEstoque;
	private String[] colunas = {"Código","Produto","Setor","Validade","Fornecedor","Quantidade"};
	
	public TableModelEstoque() {
		this.listaDeItensEstoque = new ArrayList<ItemFornecedor>();
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
				return this.listaDeItensEstoque.get(rowIndex).getProduto().getSetor();
			case 3:
				return this.listaDeItensEstoque.get(rowIndex).getProduto().getValidade();
			case 4:
				return this.listaDeItensEstoque.get(rowIndex).getFornecedor().getNomeFantasia();
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
