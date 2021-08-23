import java.util.Scanner;

public class EnterData {
    public static int enterInteger(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        }catch (Exception e){
            System.out.println("The input value must be an integer!");
            choice = enterInteger();
        }
        return choice;
    }

    public static float enterFloat(){
        float choice;
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextFloat();
        }catch (Exception e){
            System.out.println("The input value must be a real number!");
            choice = enterFloat();
        }
        return choice;
    }

    public static float enterScore(){
        float score = -1;
        while (true){
            if (score >=0 && score <=10){
                System.out.println("Score invalid");
                break;
            }
            score = enterFloat();
        }
        return score;
    }
}
