import java.util.Scanner;

public class TextInterface {

    private final Scanner scanner = new Scanner(System.in);
    private float promptAndReadFloatGreaterZero(String promptMessage){
       float number;
       do {
        System.out.println(promptMessage);
        number = scanner.nextFloat();
       }while(number < 0);
        return number;
    };

    public void printArea(,float area){

    }    
}
