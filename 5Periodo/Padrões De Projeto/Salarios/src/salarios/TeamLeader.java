package salarios;

public class TeamLeader implements IEmployee
{
	float hourlyRate = 35;

	@Override
	public float calculateSalary(float hours)
	{
		return hours * hourlyRate;
	}

}
