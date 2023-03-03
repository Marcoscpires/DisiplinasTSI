package ParteIIBSolucao2;

import java.util.concurrent.atomic.AtomicInteger;

class RecursoCompartilhado implements Runnable {
	private  AtomicInteger qtd = new AtomicInteger();
	
	public RecursoCompartilhado(int n) {
		this.qtd.set(n);
	}
	
	public void run() {
		if (qtd.get() > 0) {
			System.out.println(Thread.currentThread().getName() + " está executando.");
			try {
				Thread.sleep(500);
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			qtd.decrementAndGet();
			System.out.println(Thread.currentThread().getName() + " consumiu.");
			System.out.println("Saldo: " + qtd.get());
		}
		else {
			System.out.println(Thread.currentThread().getName() + " ficou sem recurso.");
		}
	}

}