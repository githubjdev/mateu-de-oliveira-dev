package mat.dev.sprinboot.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity // Se torna uma tabela no banco no banco de dados
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto",
                   sequenceName = "seq_produto",
                   allocationSize = 1,
                   initialValue = 1)
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;

	@NotBlank(message = "Nome não pode ser null ou vazio")
	@Column(unique = true)
	private String nome;

	@Positive(message = "Valor do produto deve ser maioo que zero")
	private Double preco;

	@Min(message = "Estoque minimo deve ser 5 unidades", value = 5)
	@Max(message = "Estoque máximo é de 500", value = 500)
	@Positive(message = "Quantidade de estoque deve ser maior que zero")
	private Integer quantidade;
	
	/*Muitos produto para uma categoria*/
	@JoinColumn(name = "categoria_id", 
			    nullable = false, 
			    foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "categoria_fk" ))
	@JsonIgnoreProperties
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
