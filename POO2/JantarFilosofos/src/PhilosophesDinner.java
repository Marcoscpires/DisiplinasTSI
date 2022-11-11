import java.util.Arrays;

public class PhilosophesDinner {
	private Table mesa = new Table();
	private Philosopher[] phils = new Philosopher[5];
	private Thread[] threads= new Thread[5];
	
	public PhilosophesDinner() {
		phils[0] = new Philosopher("Vinicius", mesa, 0, 1);
		phils[1] = new Philosopher("Jean", mesa, 1, 2);
		phils[2] = new Philosopher("Marcos", mesa, 2, 3);
		phils[3] = new Philosopher("Andre", mesa, 3, 4);
		phils[4] = new Philosopher("Lucas", mesa, 4, 0);
		
		threads[0] = new Thread(phils[0]);
		threads[1] = new Thread(phils[1]);
		threads[2] = new Thread(phils[2]);
		threads[3] = new Thread(phils[3]);
		threads[4] = new Thread(phils[4]);
		
	}
	
	public void go() {
		Arrays.stream(threads).forEach(Thread::start);
	}
	
	public void stop() {
		Arrays.stream(phils).forEach(Philosopher::done);
	}
	
	
}
