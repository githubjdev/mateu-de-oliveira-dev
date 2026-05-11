package mat.dev.sprinboot.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
@SequenceGenerator(name = "seq_categoria",
                   sequenceName = "seq_categoria",
                   allocationSize = 1,
                   initialValue = 1)
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
	private Long id;

	@Column(unique = true)
	private String nome;
	
	/*Uma Categoria para muitos produtos*/
	@OneToMany(mappedBy = "categoria", 
			  fetch = FetchType.LAZY, 
			  orphanRemoval = false,
			  cascade = CascadeType.MERGE)
	private List<Produto> produtos = new ArrayList<Produto>();
	
	
	public Categoria() {
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
