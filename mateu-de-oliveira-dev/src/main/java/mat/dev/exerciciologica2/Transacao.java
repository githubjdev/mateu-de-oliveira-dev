package mat.dev.exerciciologica2;

import java.util.Date;
import java.util.Objects;

public class Transacao {

	private Long id;
	private double valor;
	private ContaCorrente contaCorrenteOrigem;
	private ContaCorrente contaCorrenteDestino;
	private String status;
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public ContaCorrente getContaCorrenteOrigem() {
		return contaCorrenteOrigem;
	}

	public void setContaCorrenteOrigem(ContaCorrente contaCorrenteOrigem) {
		this.contaCorrenteOrigem = contaCorrenteOrigem;
	}

	public ContaCorrente getContaCorrenteDestino() {
		return contaCorrenteDestino;
	}

	public void setContaCorrenteDestino(ContaCorrente contaCorrenteDestino) {
		this.contaCorrenteDestino = contaCorrenteDestino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contaCorrenteDestino, contaCorrenteOrigem, data, id, status, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(contaCorrenteDestino, other.contaCorrenteDestino)
				&& Objects.equals(contaCorrenteOrigem, other.contaCorrenteOrigem) && Objects.equals(data, other.data)
				&& Objects.equals(id, other.id) && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

}
