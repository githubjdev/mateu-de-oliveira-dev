package mat.dev.listarraylist;

import java.util.Objects;

public class Pedido {

	public String id;
	public String status;

	public Pedido(String id, String status) {
		this.id = id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", status=" + status + "]";
	}
	
	
	public boolean concluido() {
		return getStatus().equals("Concluido");
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id) && Objects.equals(status, other.status);
	}

}
