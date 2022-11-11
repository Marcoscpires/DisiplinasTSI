
public class Philosopher implements Runnable {
	private String nome;
	private Table mesa;
	private int idForkleft, idForkRight;
	private State estado;
	Fork forkR, forkL;
	private volatile boolean done;
	
	@Override
	public void run() {
		done=false;
		while(!done) {
			try {
				eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			think();
		}
	}
	
	public void eat() throws InterruptedException {
		getForks();
		this.estado= State.EATING;
		Thread.sleep(1000);
		putForks();
		this.estado=State.THINKING;
		
	}
	
	public void getForks() {
		this.estado=State.TAKING_FORKS;
		do{
			forkL=mesa.getFork(idForkleft);
		}while(forkL==null);
		do{
			forkL=mesa.getFork(idForkRight);
		}while(forkR==null);
		
	}
	
	public void putForks() {
		mesa.putFork(idForkleft, forkL);
		mesa.putFork(idForkRight, forkR);
	}
	
	public void think() {
		this.estado=State.THINKING;
	}
	
	
	public Philosopher(String nome, Table mesa, int idForkleft, int idForkRight) {
		super();
		this.setNome(nome);
		this.mesa = mesa;
		this.idForkleft = idForkleft;
		this.idForkRight = idForkRight;
	}



	public static enum State {THINKING, EATING, TAKING_FORKS}

	public void done() {
		this.done=true;
	}
	
	public Table getMesa() {
		return mesa;
	}

	public void setMesa(Table mesa) {
		this.mesa = mesa;
	}

	public int getIdForkleft() {
		return idForkleft;
	}

	public void setIdForkleft(int idForkleft) {
		this.idForkleft = idForkleft;
	}

	public int getIdForkRight() {
		return idForkRight;
	}

	public void setIdForkRight(int idForkRight) {
		this.idForkRight = idForkRight;
	}

	public State getEstado() {
		return estado;
	}

	public void setEstado(State estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
