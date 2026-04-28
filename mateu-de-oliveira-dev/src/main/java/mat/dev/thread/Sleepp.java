package mat.dev.thread;

import javax.swing.JOptionPane;

public class Sleepp {

	public static void main(String[] args) throws InterruptedException {
		
		Thread threadEmail = new Thread(thread1); // Executa oq nos queremos como um codigo de rotina do dia a dia
		threadEmail.start();

		Thread threadNotaFiscal = new Thread(thread2);
		threadNotaFiscal.start();

		// codigo do sistema do usuario continua o fluxo de trabalho
		System.out.println("Chegou ao fim do codigo de teste da Thread");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuario");


	}
	
	
	private static Runnable thread1 = new Runnable() {
	    @Override
	    public void run() {

	        for (int i = 0; i < 8; i++) {
	            System.out.println("Sistema do email sendo execultado ");

	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	};
	
	
	private static Runnable thread2 = new Runnable() {

		@Override
		public void run() {

			for (int i = 0; i < 8; i++) {
				System.out.println("Sistema de Nota Fiscal sendo execultado ");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	};
	
	
}
	



