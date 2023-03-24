package codeSmell_SOLID.OCP_Strategy;

public class TeamLeader
{
	float hourlyRate = 35;

	public float calculateTeamLeaderSalary(float hours)
	{
		return hours * hourlyRate;
	}

}
