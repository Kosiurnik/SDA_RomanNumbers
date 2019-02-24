import java.util.InputMismatchException;
import java.util.Scanner;

public class RomanNumberConverter {

    private static int inputFormat = 10;
    private static int outputFormat = 10;

    public static void main(String[] args) {
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
        System.out.println("2: Zmień format wejściowy (obecnie "+inputFormat+")");
        System.out.println("3: Zmień format wyjściowy (obecnie "+outputFormat+")");
        System.out.println("4: Zamień na rzymską");
        System.out.println("5: Zamień rzymską na dowolną liczbę");
        System.out.println("0: Wyjdź z aplikacji");
        switch(scanner.nextInt()){
            case 1: doCountSymbols(scanner); break;
            case 2: doChangeInputFormat(scanner); break;
            case 3: doChangeOutputFormat(scanner); break;
            case 4: doConvertToRoman(scanner); break;
            case 5: doConvertFromRoman(scanner); break;
            case 0: return false;
            default:
                System.out.println("Podano nieprawidłową opcję.");
                System.out.println();
        }
        return true;
    }

    private static void doConvertToRoman(Scanner scanner) {
        System.out.print("Podaj liczbę do zamiany na rzymską: ");
        scanner.nextLine();
        String numString = scanner.nextLine();

        try{
            if(Integer.valueOf(numString,inputFormat)>0&&Integer.valueOf(numString,inputFormat)<3999) {
                String romanNum = RomanNumber.toRoman(numString,inputFormat);
                System.out.println("Wartość: "+romanNum);
            }else {
                System.out.println("Podana liczba musi mieścić się w przedziale od 1 do 3999");
            }
        }catch(NumberFormatException e){
            System.out.println("Format wprowadzonej liczby nie zgadza się z ustawieniem");
        }

    }

    private static void doConvertFromRoman(Scanner scanner) {
        System.out.print("Podaj liczbę rzymską do zamiany: ");
        scanner.nextLine();
        String romanString = scanner.nextLine();
        if(RomanNumber.isValid(romanString)){
            System.out.println("Wartość: "+RomanNumber.fromRoman(romanString,outputFormat));
        }else{
            System.out.println("Podany ciąg nie jest cyfrą rzymską");
        }
    }

    private static void doCountSymbols(Scanner scanner){
        System.out.print("Podaj ciąg zawierający symbole rzymskie: ");
        scanner.nextLine();
        String romanString = scanner.nextLine();
        if(RomanNumber.isValid(romanString)){
            System.out.println("Wartość: "+Integer.toString(RomanNumber.countSymbols(romanString),outputFormat));
        }else{
            System.out.println("Podany ciąg nie jest poprawny (musi zawierać wyłącznie symbole liczby rzymskiej)");
        }

    }
    private static void doChangeInputFormat(Scanner scanner){
        System.out.print("Podaj nowy format wejścia: ");
        int format = scanner.nextInt();
        System.out.println();
        if(format>=2&&format<=37){
            inputFormat = format;
            System.out.println("Zaktualizowano format wejścia");
        }else{
            System.out.println("Format musi mieścić się w zakresie od 2 do 37");
        }
    }
    private static void doChangeOutputFormat(Scanner scanner){
        System.out.print("Podaj nowy format wyjścia: ");
        int format = scanner.nextInt();
        System.out.println();
        if(format>=2&&format<=37){
            outputFormat = format;
            System.out.println("Zaktualizowano format wyjścia");
        }else{
            System.out.println("Format musi mieścić się w zakresie od 2 do 37");
        }
    }
}
