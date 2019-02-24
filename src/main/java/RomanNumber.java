class RomanNumber {

    static String toRoman(String input, int radix) throws NumberFormatException{
        if(radix>=Character.MIN_RADIX&&radix<=Character.MAX_RADIX){
            return ConvertFromInt(Integer.parseInt(input,radix));
        }
        else
            throw new IllegalArgumentException("Radix musi być w przedziale od 2 do 36");
    }

    static String toRoman(int input){
        return ConvertFromInt(input);
    }

    static int fromRoman(String romanNum){
        if(isProperRomanNumber(romanNum))
            return convertFromRoman(romanNum);
        else
            throw new IllegalArgumentException("Niepoprawna rzymska liczba!");
    }

    static String fromRoman(String romanNum, int radix) throws NumberFormatException{
        if(radix>=Character.MIN_RADIX&&radix<=Character.MAX_RADIX){
            if(isProperRomanNumber(romanNum))
                return Integer.toString(fromRoman(romanNum),radix);
            else
                throw new IllegalArgumentException("Niepoprawna rzymska liczba!");
        }else{
            throw new IllegalArgumentException("Radix musi być w przedziale od 2 do 36");
        }
    }

    static int countSymbols(String romanNum){
        int sum = 0;
        for(char symbol : romanNum.toCharArray()){
            sum += symbolValue(symbol);
        }
        return sum;
    }

    private static int convertFromRoman(String romanNum){
        if (romanNum.isEmpty()) return 0;
        if (romanNum.startsWith("M"))  return 1000 + convertFromRoman(romanNum.substring(1));
        else if (romanNum.startsWith("CM")) return 900  + convertFromRoman(romanNum.substring(2));
        else if (romanNum.startsWith("D"))  return 500  + convertFromRoman(romanNum.substring(1));
        else if (romanNum.startsWith("CD")) return 400  + convertFromRoman(romanNum.substring(2));
        else if (romanNum.startsWith("C"))  return 100  + convertFromRoman(romanNum.substring(1));
        else if (romanNum.startsWith("XC")) return 90   + convertFromRoman(romanNum.substring(2));
        else if (romanNum.startsWith("L"))  return 50   + convertFromRoman(romanNum.substring(1));
        else if (romanNum.startsWith("XL")) return 40   + convertFromRoman(romanNum.substring(2));
        else if (romanNum.startsWith("X"))  return 10   + convertFromRoman(romanNum.substring(1));
        else if (romanNum.startsWith("IX")) return 9    + convertFromRoman(romanNum.substring(2));
        else if (romanNum.startsWith("V"))  return 5    + convertFromRoman(romanNum.substring(1));
        else if (romanNum.startsWith("IV")) return 4    + convertFromRoman(romanNum.substring(2));
        else if (romanNum.startsWith("I"))  return 1    + convertFromRoman(romanNum.substring(1));
        throw new IllegalArgumentException("Niewłaściwy symbol");
    }

    private static String ConvertFromInt(int input) {
        if (input < 1 || input > 3999)
            throw new IllegalArgumentException("Wartość powinna być z zakresu od 1 do 3999");
        StringBuilder s = new StringBuilder();
        while (input >= 1000) { s.append("M"); input -= 1000; }
        while (input >= 900) { s.append("CM"); input -= 900; }
        while (input >= 500) { s.append("D"); input -= 500; }
        while (input >= 400) { s.append("CD"); input -= 400; }
        while (input >= 100) { s.append("C"); input -= 100; }
        while (input >= 90) { s.append("XC"); input -= 90; }
        while (input >= 50) { s.append("L"); input -= 50; }
        while (input >= 40) { s.append("XL"); input -= 40; }
        while (input >= 10) { s.append("X"); input -= 10; }
        while (input >= 9) { s.append("IX"); input -= 9; }
        while (input >= 5) { s.append("V"); input -= 5; }
        while (input >= 4) { s.append("IV"); input -= 4; }
        while (input >= 1) { s.append("I"); input -= 1; }
        return s.toString();
    }

    static boolean isProperRomanNumber(String romanNum) {
        String regex = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return romanNum.matches(regex);
    }

    static boolean isValid(String romanNum){
        String regex = "^[IVXLCDM]+$";
        return romanNum.matches(regex);
    }

    private static int symbolValue(char romanSymbol){
        switch(romanSymbol){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
