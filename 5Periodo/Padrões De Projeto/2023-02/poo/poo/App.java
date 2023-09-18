package poo;
public class App
{
	public void go()
	{
		TextUserInterface textUserInterface = new TextUserInterface();
		int firstTerm = textUserInterface.readFirstTerm();
		int commonDifference = textUserInterface.readCommonDifference();
		
	}
	
	public void main(String args[])
	{
		App app = new App();
		app.go();
	}
}
