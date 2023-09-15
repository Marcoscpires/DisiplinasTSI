package codeSmell_SOLID.OCP_Strategy;

public class Recruiter
{
	float hourlyRate = 20;
	float hireBonus = 500;
	
	private float calculateBonus(float hours)
	{
		if(hours > 100)
			return hireBonus;
		
		return 0;
	}
	
	public float calculateTotalSalary(float hours)
	{
		return hours * hourlyRate + calculateBonus(hours);
	}

}
