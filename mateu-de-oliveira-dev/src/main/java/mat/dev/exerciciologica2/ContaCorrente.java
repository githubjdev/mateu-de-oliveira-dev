package mat.dev.exerciciologica2;

import java.util.Objects;

public class ContaCorrente {

	private Long id;
	private String numero;
	private String agencia;
	private String digitoVerificar;
	private Banco banco;
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getDigitoVerificar() {
		return digitoVerificar;
	}

	public void setDigitoVerificar(String digitoVerificar) {
		this.digitoVerificar = digitoVerificar;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, banco, digitoVerificar, id, numero, pessoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(banco, other.banco)
				&& Objects.equals(digitoVerificar, other.digitoVerificar) && Objects.equals(id, other.id)
				&& Objects.equals(numero, other.numero) && Objects.equals(pessoa, other.pessoa);
	}

}
