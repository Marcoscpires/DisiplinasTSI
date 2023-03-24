package codeSmell_SOLID.OCP_Strategy;

public class Payroll
{
	public float calculateSalary(String employeeType, float hours)
	{
		if ("developer".equalsIgnoreCase(employeeType)) 
	      return new Developer().calculateSalary(hours);
		
	   if ("teamLeader".equalsIgnoreCase(employeeType)) 
	   	return new TeamLeader().calculateTeamLeaderSalary(hours);
	   
	   if ("recruiter".equalsIgnoreCase(employeeType)) 
	   	return new Recruiter().calculateTotalSalary(hours);
	   
	   return 0.0f;
	}
}
