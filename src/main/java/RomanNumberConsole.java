import java.util.Scanner;

public class RomanNumberConsole {

    private static RomanNumberController romanNumberController;

    public static void main(String[] args) {
        romanNumberController = new RomanNumberController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Konwerter liczb rzymskich");
        System.out.println();
        //noinspection StatementWithEmptyBody
        while (showOptions(scanner));
        scanner.close();
    }

    private static boolean showOptions(Scanner scanner){
        System.out.println("Wybierz opcję");
        System.out.println("1: Policz symbole");
        System.out.println("2: Zmień format wejściowy (obecnie "+romanNumberController.getInputFormat()+")");
        System.out.println("3: Zmień format wyjściowy (obecnie "+romanNumberController.getOutputFormat()+")");
        System.out.println("4: Zamień na rzymską");
        System.out.println("5: Zamień rzymską na dowolną liczbę");
        System.out.println("0: Wyjdź z aplikacji");
        switch(scanner.nextInt()){
            case 1: romanNumberController.countSymbols(scanner); break;
            case 2: romanNumberController.changeInputFormat(scanner); break;
            case 3: romanNumberController.changeOutputFormat(scanner); break;
            case 4: romanNumberController.convertToRoman(scanner); break;
            case 5: romanNumberController.convertFromRoman(scanner); break;
            case 0: return false;
            default:
                System.out.println("Podano nieprawidłową opcję.");
                System.out.println();
        }
        return true;
    }

}
