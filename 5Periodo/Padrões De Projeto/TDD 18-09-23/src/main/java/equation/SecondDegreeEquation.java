package equation;

import java.util.ArrayList;

public class SecondDegreeEquation
{
	private float a;
	private float b;
	private float c;
	
	//----------------------------------------------------------
	public SecondDegreeEquation(float a, float b, float c) 
	{
		this.a = a;
		this.b = b;
		this.c = c;
		
		if(Math.abs(a) < 0.000_000_000_1)
			throw new InvalidSecondDegreeException("Invalid value (a= "+a+")");
	}
	
	//----------------------------------------------------------
	public float getA()
	{
		return a;
	}

	//----------------------------------------------------------
	public final float getB()
	{
		return b;
	}

	//----------------------------------------------------------
	public final float getC()
	{
		return c;
	}
	
	//----------------------------------------------------------
	private float delta()
	{
		return  (b*b - 4*a*c);
	}
	
	//----------------------------------------------------------
	private float[] RootEquation() 
	{
		float[] roots = new float[2];
		roots[0] = (float)(-b + Math.sqrt(delta()) / (2*a));
		roots[1] = (float)(-b - Math.sqrt(delta()) / (2*a)); 
		return roots;
	}
	
	//----------------------------------------------------------
	public boolean haveRealSolution()
	{
		float delta = this.delta();		
		return delta >= 0;
	}
	
	//----------------------------------------------------------
	public int howManyRealSolutions()
	{
		float delta = this.delta();
		
		if(delta < 0)
			return 0;
		
		if(delta > 0)
			return 2;
		
		return 1;
	}
	
	//----------------------------------------------------------
//	public float[] oldSolurion()
//	{
//		float[] = new float[]
//		
//		if(howManyRealSolutions() > 0)
//			return RootEquation();
//		if(howManyRealSolutions() == 0)
//			
//		return new float[0];
//	}
	
	public ArrayList<Float> getRealSolutions()
	{
		ArrayList<Float> RealRoots = new ArrayList<>();
		float[] roots = RootEquation();
		
		
		if(howManyRealSolutions() == 2)
		{
			RealRoots.add(roots[0]);
			RealRoots.add(roots[1]);
			return RealRoots;
		}
		if(howManyRealSolutions() == 1)
		{
			RealRoots.add(roots[0]);
			return RealRoots;
		}
		return RealRoots;
	}
}
