package salarios;

public class Developer implements IEmployee
{
	float hourlyRate = 40;
	
	@Override
	public float calculateSalary(float hours)
	{
		return hours * hourlyRate;
	}

}
