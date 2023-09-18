package equation;

public 
class InvalidSecondDegreeException 
extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public InvalidSecondDegreeException(String msg)
	{
		super(msg);
	}
}
