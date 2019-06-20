package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscalVenda {
	private String numeroVenda;
	private String coo;
	private String extratoSat;
	private String numeroSat;
	private LocalDateTime dataHora;
	private String empresa;
	private Funcionario funcionario;
	private ArrayList<Produto> Produtos;
	private List<Double> subtotais;
	private String modoPagamento;
	private String cpfConsumidor;
	private double total;
	
	public String getNumeroVenda() {
		return numeroVenda;
	}
	public void setNumeroVenda(String numeroVenda) {
		this.numeroVenda = numeroVenda;
	}
	public String getCoo() {
		return coo;
	}
	public void setCoo(String coo) {
		this.coo = coo;
	}
	public String getExtratoSat() {
		return extratoSat;
	}
	public void setExtratoSat(String extratoSat) {
		this.extratoSat = extratoSat;
	}
	public String getNumeroSat() {
		return numeroSat;
	}
	public void setNumeroSat(String numeroSat) {
		this.numeroSat = numeroSat;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public ArrayList<Produto> getProdutos() {
		return Produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		Produtos = produtos;
	}
	public List<Double> getSubtotais() {
		return subtotais;
	}
	public void setSubtotais(List<Double> subtotais) {
		this.subtotais = subtotais;
	}
	public String getModoPagamento() {
		return modoPagamento;
	}
	public void setModoPagamento(String modoPagamento) {
		this.modoPagamento = modoPagamento;
	}
	public String getCpfConsumidor() {
		return cpfConsumidor;
	}
	public void setCpfConsumidor(String cpfConsumidor) {
		this.cpfConsumidor = cpfConsumidor;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
}
