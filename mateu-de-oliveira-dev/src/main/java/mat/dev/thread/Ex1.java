package mat.dev.thread;

public class Ex1 {

	public static void main(String[] args) throws InterruptedException {
		
		/*Exemplo de caixa de supermercado*/
		/*200 processos ou seria 200 pessoas para serem atendidas*/
		
		Runnable caixa1 = () -> {
			
			for (int i = 0; i < 50; i++) {
				System.out.println("Caixa 1 atendendo a pessoa: " + i);
				espera();
			}
			
		};
		
		Runnable caixa2 = () -> {
			
			for (int i = 0; i < 50; i++) {
				System.out.println("Caixa 2 atendendo a pessoa: " + i);
				espera();
			}
			
		};
		
		
		Runnable caixa3 = () -> {
			
			for (int i = 0; i < 50; i++) {
				System.out.println("Caixa 3 atendendo a pessoa: " + i);
				espera();
			}
			
		};
		
		
		Runnable caixa4 = () -> {
			
			for (int i = 0; i < 50; i++) {
				System.out.println("Caixa 4 atendendo a pessoa: " + i);
				espera();
			}
			
		};
		
		
		Thread tcai1 =  new Thread(caixa1);
		Thread tcai2 = new Thread(caixa2);
		
		tcai1.start();
		//tcai1.join();
		
		tcai2.start();		
		//tcai2.join();
		
		/*new Thread(caixa3).join();*/
		/*new Thread(caixa4).join();*/
		System.out.println("FIM");
		
		

	}
	
	
	public static void espera() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
