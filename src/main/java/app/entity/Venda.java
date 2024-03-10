package app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String enderecoEntrega;
    @NotNull(message = "Informe o Valor Total!")
    private double valorTotal;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @NotNull(message = "Venda sem cliente associado!")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    @NotNull(message = "Venda sem funcionário associado!")
    private Funcionario funcionario;
    
    @ManyToMany
    @JoinTable
    (
        name = "venda_produto",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    @NotNull(message = "Venda sem produtos adicionados!")
    private List<Produto> produtos;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}
	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}