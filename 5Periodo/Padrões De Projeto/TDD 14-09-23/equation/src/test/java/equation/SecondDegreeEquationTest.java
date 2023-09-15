package equation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SecondDegreeEquationTest
{

	@Test
	void shouldInstantiateCorrectlly()
	{
		//given
		float a = 1;
		float b = 2;
		float c = 3;
		
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

	@Test
	void shouldThrowsExceptionWithAnInvalidEquation()
	{
		float a = 0.0f;
		float b = 2.0f;
		float c = 3.0f;
		
		assertThrows ( InvalidSecondDegreeException.class, ()->
		{
			new SecondDegreeEquation(a,b,c);
		});
	}
	
	//https://www.calculadoraonline.com.br/equacao-2-grau
	
	@Test 
	void shouldReturnTrueAsEquationHaveRealSolution()
	{
		
		//parabola para cima - duas raizes
		float a = 2;
		float b = 2;
		float c = -3;
		
		//act
		SecondDegreeEquation eq = new SecondDegreeEquation(a, b, c);
		boolean result = eq.haveRealSolution();
		//check	
		
		assertTrue(result);
		
	}
	
	@Test
	void shouldReturnZeroAsEquationHaveNoRealSolution()
	{
		//parabola para cima - nenhuma raiz
		float a = 2;
		float b = 1;
		float c = 3;
		
		SecondDegreeEquation eq = new SecondDegreeEquation(a, b, c);
		int obtained = eq.howManyRealSolutions();
		
		int expected = 0;
		assertEquals(expected, obtained);
		
		//parabola para baixo - nenhuma raiz
		a = 2;
		b = 1;
		c = 3;
		
		obtained = eq.howManyRealSolutions();
		
		assertEquals(expected, obtained);
	}
	@Test
	void shouldReturnOneAsEquationHaveNoRealSolution()
	{
		//parabola para cima - uma raiz
		float a = ;
		
		
		//parabola para baixo - uma raiz
	}
	@Test
	void shouldReturnTwoAsEquationHaveNoRealSolution()
	{
		//parabola para cima - duas raiz
		//parabola para baixo - duas raiz
	}
	
	@Test
	void shouldReturnFalseAsEquationHaveNoRealSolution() 
	{
				
	}
}
