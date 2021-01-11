package challenges.challenge4;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class challenge4 {

    @Test()
    public void writeOutFibonacci() {
        ArrayList<Integer> sequence = fibonacci.getFibonacciUpTo(47);
        for (Integer item : sequence) {
            String writtenItem = writtenNumber(item);
            System.out.println(item + " - " + writtenItem);
        }
    }

    public String writtenNumber(Integer inputNumber) {
        HashMap<Integer, String> singleDigits = new HashMap<>();
        HashMap<Integer, String> doubleDigits = new HashMap<>();
        HashMap<Integer, String> teens = new HashMap<>();
        HashMap<Integer, String> magnitude = new HashMap<>();
        singleDigits.put(0, "");
        singleDigits.put(1, " one");
        singleDigits.put(2, " two");
        singleDigits.put(3, " three");
        singleDigits.put(4, " four");
        singleDigits.put(5, " five");
        singleDigits.put(6, " six");
        singleDigits.put(7, " seven");
        singleDigits.put(8, " eight");
        singleDigits.put(9, " nine");
        teens.put(10, " ten");
        teens.put(11, " eleven");
        teens.put(12, " twelve");
        teens.put(13, " thirteen");
        teens.put(14, " fourteen");
        teens.put(15, " fifteen");
        teens.put(16, " sixteen");
        teens.put(17, " seventeen");
        teens.put(18, " eighteen");
        teens.put(19, " nineteen");
        doubleDigits.put(0, "");
        doubleDigits.put(2, " twenty");
        doubleDigits.put(3, " thirty");
        doubleDigits.put(4, " forty");
        doubleDigits.put(5, " fifty");
        doubleDigits.put(6, " sixty");
        doubleDigits.put(7, " seventy");
        doubleDigits.put(8, " eighty");
        doubleDigits.put(9, " ninety");
        magnitude.put(0, "");
        magnitude.put(1, " thousand");
        magnitude.put(2, " million");
        magnitude.put(3, " billion");
        magnitude.put(4, " trillion");

        String numberString = inputNumber.toString();
        List<Integer> digitsList = new ArrayList<>();
        for (char digit : numberString.toCharArray()) {
            digitsList.add(Integer.parseInt(String.valueOf(digit)));
        }
        int length = digitsList.size();

        switch(length){
            case 1:
                return singleDigits.get(inputNumber);
            case 2:
                if (digitsList.get(0) == 1) {
                    return teens.get(inputNumber);
                } else {
                    return doubleDigits.get(digitsList.get(0)) + singleDigits.get(digitsList.get(1));
                }
            case 3:
                return singleDigits.get(digitsList.get(0)) + " hundred" + writtenNumber(Integer.parseInt(numberString.substring(1)));
            default:
                List<Integer> reverseMagnitudeList = splitNumber(numberString);
                StringBuilder finalString = new StringBuilder();
                for (int i = 0; i < reverseMagnitudeList.size(); i++) {
                    finalString.insert(0, writtenNumber(reverseMagnitudeList.get(i)) + magnitude.get(i));
                }
                return finalString.toString();
        }
    }

    public List<Integer> splitNumber(String numberString){
        List<Integer> magnitudeList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberString);
        stringBuilder.reverse();

        for(String substring : Splitter.fixedLength(3).split(stringBuilder)){
            StringBuilder substringBuilder = new StringBuilder();
            substringBuilder.append(substring);
            substringBuilder.reverse();
            magnitudeList.add(Integer.parseInt(substringBuilder.toString()));
        }
        return magnitudeList;
    }
}
