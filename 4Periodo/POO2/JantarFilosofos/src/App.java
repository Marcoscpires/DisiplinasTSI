

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		PhilosophesDinner pd = new PhilosophesDinner();
		
		pd.go();
		
		Thread.sleep(1200);
		
		pd.stop();
	}

}
