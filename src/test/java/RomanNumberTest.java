import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumberTest {

    @Test
    void countRomanSymbolsTest(){
        assertThat(RomanNumber.countSymbols("IVXM")).isEqualTo(1016);
        assertThat(RomanNumber.countSymbols("MMCCCMM")).isEqualTo(4300);
    }

    @ParameterizedTest
    @CsvSource({"100,2","121,3","1301,4","1412,5","1045,6","1116,7","17,8","18,9","10,10","1A,11","1B,12","1C,13","1D,14","1E,15","1F,16","1G,17","1H,18","1I,19","1J,20"})
    void ToRomanWithRadix(String arabicNum, String rad){
        int radix = Integer.valueOf(rad);
        String romanNum = RomanNumber.toRoman(arabicNum,radix);
        assertThat(RomanNumber.isProperRomanNumber(romanNum)).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"X,2","X,3","X,4","X,5","X,6","X,7","X,8","X,9","X,10","X,11","X,12","X,13","X,14","X,15","X,16"})
    void FromRomanWithRadix(String romanNum, String rad){
        int radix = Integer.valueOf(rad);
        assertThat(RomanNumber.isProperRomanNumber(romanNum)).isEqualTo(true);
        String number = RomanNumber.fromRoman(romanNum,radix);
        assertThat(RomanNumber.toRoman(number,radix)).isEqualTo(romanNum);
    }

    @Test
    void IntToRomanTest(){
        assertThat(RomanNumber.toRoman(1)).isEqualTo("I");
        assertThat(RomanNumber.toRoman(5)).isEqualTo("V");
        assertThat(RomanNumber.toRoman(10)).isEqualTo("X");
        assertThat(RomanNumber.toRoman(50)).isEqualTo("L");
        assertThat(RomanNumber.toRoman(100)).isEqualTo("C");
        assertThat(RomanNumber.toRoman(500)).isEqualTo("D");
        assertThat(RomanNumber.toRoman(1000)).isEqualTo("M");
        assertThat(RomanNumber.toRoman(1016)).isEqualTo("MXVI");
    }

    @Test
    void RomanToIntTest(){
        assertThat(RomanNumber.fromRoman("I")).isEqualTo(1);
        assertThat(RomanNumber.fromRoman("IV")).isEqualTo(4);
        assertThat(RomanNumber.fromRoman("V")).isEqualTo(5);
        assertThat(RomanNumber.fromRoman("X")).isEqualTo(10);
        assertThat(RomanNumber.fromRoman("MXVI")).isEqualTo(1016);
    }

    @ParameterizedTest
    @ValueSource(strings = {"IVXM","MMCCCMM"})
    void isValidTest(String romanNum){
        assertThat(RomanNumber.isValid(romanNum)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCD","XYZ"})
    void isNotValidTest(String romanNum){
        assertThat(RomanNumber.isValid(romanNum)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"XVII","VIII","III","MXVII"})
    void isProperRomanNumberTest(String romanNum){
        int arabicNum = RomanNumber.fromRoman(romanNum);
        assertThat(RomanNumber.isProperRomanNumber(romanNum)).isEqualTo(true);
        assertThat(RomanNumber.toRoman(arabicNum)).isEqualTo(romanNum);
    }

    @ParameterizedTest
    @ValueSource(strings = {"XIXIX","VIIII","MMMMM"})
    void isNotProperRomanNumberTest(String romanNum){
        assertThat(RomanNumber.isProperRomanNumber(romanNum)).isEqualTo(false);
    }
}