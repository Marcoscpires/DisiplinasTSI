package equation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondDegreeEquationTest
{
	//------------------------------------------------------------------------
	@Test
	void shouldInstantiateCorrectlly()
	{
		float a, b, c;
		
		//given
		a = 1; b = 2; c = 3;
		
		//do / act
		SecondDegreeEquation equation = new SecondDegreeEquation(a,b,c);
		
		//check
		float obtained;
		
		obtained = equation.getA();
		assertTrue( (Math.abs(a - obtained) < 0.0001) );
		
		obtained = equation.getB();
		assertTrue( (Math.abs(b - obtained) < 0.0001) );
		
		obtained = equation.getC();
		assertTrue( (Math.abs(c - obtained) < 0.0001) );
	}

	//------------------------------------------------------------------------
	@Test
	void shouldThrowsExceptionWithAnInvalidEquation()
	{
		float a,b,c;
		
		a = 0.0f; b = 2.0f; c = 3.0f;
		
		assertThrows ( InvalidSecondDegreeException.class, ()->
		{
			new SecondDegreeEquation(a,b,c);
		});
	}
	
	//------------------------------------------------------------------------
	@Test
	void shouldReturnTrueAsEquationHaveRealSolution()
	{
		float a, b, c;
		
		//parabola para cima - duas raizes
		a = 2; b = 1; c = -3; 
		
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		boolean result = eq.haveRealSolution();
		
		assertTrue(result);
		
		//parabola para cima - uma raiz
		a = 2; b = 4; c = 2;
		
		eq = new SecondDegreeEquation(a,b,c);
		result = eq.haveRealSolution();
		
		assertTrue(result);
		
		//parabola para baixo - duas raizes
		a = -2;  b = 1; c = 3; 
		
		eq = new SecondDegreeEquation(a,b,c);
		result = eq.haveRealSolution();
		
		assertTrue(result);
		
		//parabola para baixo - uma raiz
		a = -2; b = 4; c = -2;
		
		eq = new SecondDegreeEquation(a,b,c);
		result = eq.haveRealSolution();
		
		assertTrue(result);
	}

	//------------------------------------------------------------------------
	@Test
	void shouldReturnFalseAsEquationHaveNoRealSolution()
	{
		float a,b,c;
		
		//parabola para cima - sem raiz
		a = 2; b = 1; c = 3; 
		
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		boolean result = eq.haveRealSolution();
		
		assertFalse(result);
		
		
		//parabola para baixo - sem raiz
		a = -2; b = 1; c = -3;
		
		eq = new SecondDegreeEquation(a,b,c);
		result = eq.haveRealSolution();
		
		assertFalse(result);
	}
	
	//------------------------------------------------------------------------
	@Test
	void shouldReturnZeroAsEquationHaveNoRealSolutions()
	{
		float a, b, c;
		
		//parabola para cima - nenhuma raiz
		a = 2; b = 1; c = 3;
		
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		int obtained = eq.howManyRealSolutions();
		
		int expected = 0;
		assertEquals(expected, obtained);
		
		//parabola para baixo - nenhuma raiz
		a = -2; b =  1; c = -3;
		
		eq = new SecondDegreeEquation(a,b,c);
		obtained = eq.howManyRealSolutions();
		
		assertEquals(expected, obtained);
	}
	
	//------------------------------------------------------------------------
	@Test
	void shouldReturnOneAsEquationHaveOneRealSolutions()
	{
		float a, b, c;
		
		//parabola para cima - uma raiz
		a = 2; b = 4; c = 2;
		
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		int obtained = eq.howManyRealSolutions();
		
		int expected = 1;
		assertEquals(expected, obtained);
		
		//parabola para baixo - uma raiz
		a = -2; b = 4; c = -2;
		
		eq = new SecondDegreeEquation(a,b,c);
		obtained = eq.howManyRealSolutions();
		
		assertEquals(expected, obtained);
		
		
	}
	
	//------------------------------------------------------------------------
	@Test
	void shouldReturnTwoAsEquationHaveTwoRealSolutions()
	{
		float a, b, c;
		
		//parabola para cima - duas raizes
		a = 2; b = 1; c = -3;
		
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		int obtained = eq.howManyRealSolutions();
		
		int expected = 2;
		assertEquals(expected, obtained);
		//parabola para baixo - duas raizes
		a = -2;  b = 1; c = 3;
		
		eq = new SecondDegreeEquation(a,b,c);
		obtained = eq.howManyRealSolutions();
		
		assertEquals(expected, obtained);
	}
	
	//------------------------------------------------------------------------
	@Test
	void shouldReturnEmptyArrayOfRealSolutions()
	{
		float a,b,c;
		int expected = 0;
		
		//parabola para cima - nenhuma raiz
		a = 2; b = 1; c = 3;
	
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		int actual = eq.getRealSolutions().size();
		
		Assertions.assertEquals(expected, actual);
		
		//parabola para baixo - nenhuma raiz
		a = -2; b =  1; c = -3;
		
		eq = new SecondDegreeEquation(a,b,c);
		actual = eq.getRealSolutions().size();
		
		Assertions.assertEquals(expected, actual);
		
	}
	
	//------------------------------------------------------------------------
	@Test
	void shouldReturnAnArrayWithTheUniqueRealSolution()
	{
		float a,b,c;
		int expected = 1;
		
		//parabola para cima - uma raiz
		a = 2; b = 4; c = 2;
	
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		int actual = eq.getRealSolutions().size();
		System.out.println(eq.getRealSolutions());
		
		Assertions.assertEquals(expected, actual);
		
		//parabola para baixo - uma raiz
		a = -2; b = 4; c = -2;
		
		eq = new SecondDegreeEquation(a,b,c);
		actual = eq.getRealSolutions().size();
		
		Assertions.assertEquals(expected, actual);
	}
	
	//------------------------------------------------------------------------
	@Test
	void shouldReturnAnArrayWithTheTwoRealSolution()
	{
		float a,b,c;
		int expected = 2;
		
		//parabola para cima - duas raiz
		a = 2; b = 1; c = -3;
	
		SecondDegreeEquation eq = new SecondDegreeEquation(a,b,c);
		int actual = eq.getRealSolutions().size();
		
		Assertions.assertEquals(expected, actual);
		
		//parabola para baixo - duas raiz
		a = -2;  b = 1; c = 3;;
		
		eq = new SecondDegreeEquation(a,b,c);
		actual = eq.getRealSolutions().size();
		
		Assertions.assertEquals(expected, actual);
	}
}
