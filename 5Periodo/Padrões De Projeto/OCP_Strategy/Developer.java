package codeSmell_SOLID.OCP_Strategy;

public class Developer
{
	float hourlyRate = 40;
	
	public float calculateSalary(float hours)
	{
		return hours * hourlyRate;
	}

}
