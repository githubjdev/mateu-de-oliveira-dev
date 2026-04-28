package mat.dev.thread;
import javax.swing.JOptionPane;

public class threadd {

	public static void main(String[] args) throws InterruptedException {

		// tread processando em paralelo do envio de email
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();

		// tread processando em paralelo do envio de NOTA FISCAS
		Thread threadNotaFiscal = new Thread(thread2);
		threadNotaFiscal.start();


		// ***********DIVISÃO DAS
		// THREAD****************************

		// tread processando em paralelo do envio de NOTA FISCAS
		new Thread() {

			public void run() {// Execulta oque nos queremos
				// codigo da rotina

				// codigo da rotina que eu quero execultar em paralelo
				for (int i = 0; i < 10; i++) {

					// Quero execultar esse envio a com um tempo de parada, ou com um tempo
					// determinado
					System.out.println("Notas fiscais enviadas");

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // Da um tempo
				}

			};

		}.start();// Start liga a Thread que fica processando paralelamente por trás



		// codigo do sistema do usuario contibua o fluxo de trabalho
		System.out.println("Chegou ao fim do codigo de teste de THREAD");

		// fluxo do sistema,cadastro de venda,alguma coisa do tipo
		JOptionPane.showMessageDialog(null, "Sistema continua execultando para o usuario");
	}


	private static Runnable thread1 = new Runnable() {
		public void run() {

				// codigo da rotina que eu quero execultar em paralelo
				for (int i = 0; i < 10; i++) {

					// Quero execultar esse envio a com um tempo de parada, ou com um tempo
					// determinado
					System.out.println("Emails sendo enviados");

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} // Da um tempo
				}
		}
	};


	private static Runnable thread2 = new Runnable() {
		public void run() {

			// codigo da rotina que eu quero execultar em paralelo
			for (int i = 0; i < 10; i++) {

				// Quero execultar esse envio a com um tempo de parada, ou com um tempo
				// determinado
				System.out.println("Emails sendo enviados");

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} // Da um tempo
			}
		}
	};
	
}
