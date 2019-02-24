import java.util.Scanner;

class RomanNumberController {

    private int inputFormat;
    private int outputFormat;

    RomanNumberController() {
        this.inputFormat = 10;
        this.outputFormat = 10;
    }

    int getInputFormat() {
        return inputFormat;
    }

    private void setInputFormat(int inputFormat) {
        this.inputFormat = inputFormat;
    }

    int getOutputFormat() {
        return outputFormat;
    }

    private void setOutputFormat(int outputFormat) {
        this.outputFormat = outputFormat;
    }

    void convertToRoman(Scanner scanner) {
        System.out.print("Podaj liczbę do zamiany na rzymską: ");
        scanner.nextLine();
        String numString = scanner.nextLine().toUpperCase();

        try{
            if(Integer.valueOf(numString,getInputFormat())>0&&Integer.valueOf(numString,getInputFormat())<3999) {
                String romanNum = RomanNumber.toRoman(numString,getInputFormat());
                System.out.println("Wartość: "+romanNum);
            }else {
                System.out.println("Podana liczba musi mieścić się w przedziale od 1 do 3999");
            }
        }catch(NumberFormatException e){
            System.out.println("Format wprowadzonej liczby nie zgadza się z ustawieniem");
        }

    }

    void convertFromRoman(Scanner scanner) {
        System.out.print("Podaj liczbę rzymską do zamiany: ");
        scanner.nextLine();
        String romanString = scanner.nextLine().toUpperCase();
        if(RomanNumber.isValid(romanString)){
            System.out.println("Wartość: "+RomanNumber.fromRoman(romanString,getOutputFormat()));
        }else{
            System.out.println("Podany ciąg nie jest cyfrą rzymską");
        }
    }

    void countSymbols(Scanner scanner){
        System.out.print("Podaj ciąg zawierający symbole rzymskie: ");
        scanner.nextLine();
        String romanString = scanner.nextLine().toUpperCase();
        if(RomanNumber.isValid(romanString)){
            System.out.println("Wartość: "+Integer.toString(RomanNumber.countSymbols(romanString),getOutputFormat()));
        }else{
            System.out.println("Podany ciąg nie jest poprawny (musi zawierać wyłącznie symbole liczby rzymskiej)");
        }

    }
    void changeInputFormat(Scanner scanner){
        System.out.print("Podaj nowy format wejścia: ");
        int format = scanner.nextInt();
        System.out.println();
        if(format>=Character.MIN_RADIX&&format<=Character.MAX_RADIX){
            setInputFormat(format);
            System.out.println("Zaktualizowano format wejścia");
        }else{
            System.out.println("Format musi mieścić się w zakresie od 2 do 36");
        }
    }
    void changeOutputFormat(Scanner scanner){
        System.out.print("Podaj nowy format wyjścia: ");
        int format = scanner.nextInt();
        System.out.println();
        if(format>=Character.MIN_RADIX&&format<=Character.MAX_RADIX){
            setOutputFormat(format);
            System.out.println("Zaktualizowano format wyjścia");
        }else{
            System.out.println("Format musi mieścić się w zakresie od 2 do 36");
        }
    }
}
