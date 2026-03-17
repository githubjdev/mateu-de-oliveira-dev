package mat.dev.exerciciologica2;

import java.util.Calendar;

public class MainContaCorrente {
	
	public static void main(String[] args) {
		
		
		Banco banco = new Banco();
		banco.setId(1l);
		banco.setNome("Itau");
		banco.setCnpj("218752000277");
		banco.setEndereco("Rua logo ali");
		banco.setNumeroRegistro("70090");
		

		Pessoa pessoaMateus = new Pessoa();
		pessoaMateus.setId(1l);
		pessoaMateus.setNome("Mateus");
		pessoaMateus.setCpf("078079045704");
		pessoaMateus.setRg("22457468");
		pessoaMateus.setTelefone("5555555");
		pessoaMateus.setEndereco("Logo ali");

		Pessoa pessoaAlex = new Pessoa();
		pessoaAlex.setId(2l);
		pessoaAlex.setNome("Alex");
		pessoaAlex.setCpf("87985415328");
		pessoaAlex.setRg("98753145");
		pessoaAlex.setTelefone("66666666");
		pessoaAlex.setEndereco("bem na esquina");

		Transacao transacao = new Transacao();
		transacao.setId(3l);
		transacao.setData(Calendar.getInstance().getTime());
		transacao.setStatus("andemento");
		transacao.setValor(1000);


		ContaCorrente contaCorrenteOrigem = new ContaCorrente();
		contaCorrenteOrigem.setId(1l);
		contaCorrenteOrigem.setPessoa(pessoaMateus);
		contaCorrenteOrigem.setNumero("87878787");
		contaCorrenteOrigem.setBanco(banco);
		contaCorrenteOrigem.setAgencia("747474");
		contaCorrenteOrigem.setDigitoVerificar("23");
		contaCorrenteOrigem.debito(transacao.getValor());
		contaCorrenteOrigem.getTransacaos().add(transacao);

		transacao.setContaCorrenteOrigem(contaCorrenteOrigem);

		ContaCorrente contaCorrenteDestino = new ContaCorrente();
		contaCorrenteDestino.setId(2l);
		contaCorrenteDestino.setPessoa(pessoaAlex);
		contaCorrenteDestino.setNumero("87878787");
		contaCorrenteDestino.setBanco(banco);
		contaCorrenteDestino.setAgencia("959595");
		contaCorrenteDestino.setDigitoVerificar("89");
		contaCorrenteDestino.deposito(transacao.getValor());
		contaCorrenteDestino.getTransacaos().add(transacao);

		transacao.setContaCorrenteDestino(contaCorrenteDestino);


		System.out.println("saldo da conta origem " + contaCorrenteOrigem.getSaldo());
		System.out.println("saldo da conta destino " + contaCorrenteDestino.getSaldo());
	}

}
