import java.util.Scanner;

public class ShapeAreaCalculator
{
	public void RectangleArea()
	{
		Scanner scanner = new Scanner(System.in);
		float width, height, area;
		System.out.print("Digite o valor do primeiro lado: ");
	   width = Math.abs(scanner.nextFloat()); //garante Lado1 com valor positivo
	   System.out.print("Digite o valor do segundo lado: ");
	   height = Math.abs(scanner.nextFloat());//garante Lado2 com valor positivo
	   scanner.close();
	   System.out.println(""); //salta uma linha
	   area = width*height;
	   System.out.printf("\nÁrea: %5.2f", area);
	}
	
	public void ParallelogramArea()
	{
		//Calcula a área de um paralelogramo.
		//--------------------------------------------------
		Scanner scanner = new Scanner(System.in);
		float B, h, Area;
		System.out.print("Digite o valor da base: ");
		B = Math.abs(scanner.nextFloat()); //garante base positiva
	   System.out.print("Digite o valor da altura: ");
	   h = Math.abs(scanner.nextFloat()); //garante altura positiva
	   Area = B*h; //fórmula da área do paralelogramo
	   System.out.println("");
	   System.out.printf("\nÁrea do paralelogramo: %f", Area);
	}
	
	public void TrapeziumArea()
	{
		//Calcula a área de um trapézio.
		//--------------------------------------------------------
		float B1,B2, h, L1, L2, Area;
		do{ //valida as bases
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite o valor da base menor: ");
			B1 = scanner.nextFloat();
			B1 = Math.abs(B1); //garante base menor positiva
			System.out.println("Digite o valor da base maior: ");
			B2 = scanner.nextFloat();
			B2 = Math.abs(B2); //garante base maior positiva
		} while ((B1==0) || (B2==0) || (B2<B1));
		do{ //valida a altura
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite o valor da altura: ");
			h = scanner.nextFloat();
			h = Math.abs(h); //garante altura positiva
		}while(!(h>0));
		Area = ((B1+B2)*h)/2; //fórmula da área do trapézio
		System.out.println("");
		System.out.printf("\nÁrea do trapézio:%f", Area);
	}
	
	public static void main(String args[])
	{
		ShapeAreaCalculator s = new ShapeAreaCalculator();
		s.RectangleArea();
		s.ParallelogramArea();
		s.TrapeziumArea();
	}
}
