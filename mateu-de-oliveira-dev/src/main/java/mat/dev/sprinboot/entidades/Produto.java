package mat.dev.sprinboot.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity // Se torna uma tabela no banco no banco de dados
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String nome;

	private Double preco;

	private Integer quantidade;
	
	/*Muitos produto para uma categoria*/
	@JoinColumn(name = "categoria_id", 
			    nullable = false, 
			    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "categoria_fk" ))
	@ManyToOne
	private Categoria categoria;
	
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Transient /*Para não criar colun ana tabela*/
	public boolean qtdValida() {
		return quantidade > 0;
	}

	@Transient /*Para não criar colun ana tabela*/
	public boolean precoValido() {
		return preco > 0;
	}

}
