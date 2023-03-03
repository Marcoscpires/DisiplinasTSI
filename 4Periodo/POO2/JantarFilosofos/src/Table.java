
public class Table {
	private Fork[] forks ={ new Fork(), new Fork(), new Fork(), new Fork(), new Fork() };

	public Table() {
		super();
		
	}
	public void putFork(int id, Fork fork) {
		forks[id] = fork;
	}
	
	public Fork getFork(int id) {
		Fork forkT = forks[id];
		forks[id] = null;
		return forkT;
	}
	
	
	
}
