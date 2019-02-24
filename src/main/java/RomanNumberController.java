import java.util.Scanner;

class RomanNumberController {

    private int inputFormat;
    private int outputFormat;
    private Scanner scanner;

    RomanNumberController() {
        this.inputFormat = 10;
        this.outputFormat = 10;
    }

    private void convertToRoman() {
        System.out.print("Podaj liczbę do zamiany na rzymską: ");
        scanner.nextLine();
        String numString = scanner.nextLine().toUpperCase();

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

    private void convertFromRoman() {
        System.out.print("Podaj liczbę rzymską do zamiany: ");
        scanner.nextLine();
        String romanString = scanner.nextLine().toUpperCase();
        if(RomanNumber.isValid(romanString)){
            System.out.println("Wartość: "+RomanNumber.fromRoman(romanString,outputFormat));
        }else{
            System.out.println("Podany ciąg nie jest cyfrą rzymską");
        }
    }

    private void countSymbols(){
        System.out.print("Podaj ciąg zawierający symbole rzymskie: ");
        scanner.nextLine();
        String romanString = scanner.nextLine().toUpperCase();
        if(RomanNumber.isValid(romanString)){
            System.out.println("Wartość: "+Integer.toString(RomanNumber.countSymbols(romanString),outputFormat));
        }else{
            System.out.println("Podany ciąg nie jest poprawny (musi zawierać wyłącznie symbole liczby rzymskiej)");
        }

    }
    private void changeInputFormat(){
        System.out.print("Podaj nowy format wejścia: ");
        int format = scanner.nextInt();
        System.out.println();
        if(format>=Character.MIN_RADIX&&format<=Character.MAX_RADIX){
            inputFormat=format;
            System.out.println("Zaktualizowano format wejścia");
        }else{
            System.out.println("Format musi mieścić się w zakresie od 2 do 36");
        }
    }
    private void changeOutputFormat(){
        System.out.print("Podaj nowy format wyjścia: ");
        int format = scanner.nextInt();
        System.out.println();
        if(format>=Character.MIN_RADIX&&format<=Character.MAX_RADIX){
            outputFormat=format;
            System.out.println("Zaktualizowano format wyjścia");
        }else{
            System.out.println("Format musi mieścić się w zakresie od 2 do 36");
        }
    }

    void run() {
        scanner = new Scanner(System.in);
        System.out.println("Konwerter liczb rzymskich");
        System.out.println();
        boolean exit = false;
        do {
            System.out.println("Wybierz opcję");
            System.out.println("1: Policz symbole");
            System.out.println("2: Zmień format wejściowy (obecnie " + inputFormat + ")");
            System.out.println("3: Zmień format wyjściowy (obecnie " + outputFormat + ")");
            System.out.println("4: Zamień na rzymską");
            System.out.println("5: Zamień rzymską na dowolną liczbę");
            System.out.println("0: Wyjdź z aplikacji");
            switch (scanner.nextInt()) {
                case 1:
                    countSymbols();
                    break;
                case 2:
                    changeInputFormat();
                    break;
                case 3:
                    changeOutputFormat();
                    break;
                case 4:
                    convertToRoman();
                    break;
                case 5:
                    convertFromRoman();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Podano nieprawidłową opcję.");
                    System.out.println();
            }
        } while (!exit);
        scanner.close();
    }

}
