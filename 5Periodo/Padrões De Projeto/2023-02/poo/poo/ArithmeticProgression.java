package poo;
public class ArithmeticProgression
{
	private int firstTerm;
	private int commonDifference;
	
	//--------------------------------------------------------------------
	public ArithmeticProgression(int firstTerm, int commonDifference)
	{
		this.firstTerm = firstTerm;
		this.commonDifference = commonDifference;
	}
	
	//--------------------------------------------------------------------
	public int termOfIndex(int index)
	{
		return firstTerm + (index-1) * commonDifference;
	}
	
	//--------------------------------------------------------------------
	public int sumOfAllTerms(int numberOfTerms)
	{
		int lastTerm = termOfIndex(numberOfTerms);
		
		return ( ((firstTerm + lastTerm) * numberOfTerms) / 2);
	}
}
