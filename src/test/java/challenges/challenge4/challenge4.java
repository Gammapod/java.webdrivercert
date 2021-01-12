package challenges.challenge4;

import com.google.common.base.Splitter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class challenge4 {
    HashMap<Integer, String> singleDigits = new HashMap<>();
    HashMap<Integer, String> doubleDigits = new HashMap<>();
    HashMap<Integer, String> teens = new HashMap<>();
    HashMap<Integer, String> magnitudeWord = new HashMap<>();

    @Test()
    public void writeOutFibonacci() {
        ArrayList<Integer> sequence = fibonacci.getFibonacciUpTo(47);
        for (Integer item : sequence) {
            String writtenItem = writtenNumber(item);
            System.out.println(item + " - " + writtenItem);
        }
    }

    public String writtenNumber(Integer inputNumber) {
        String numberString = inputNumber.toString();
        List<Integer> digitsList = new ArrayList<>();
        for (char digit : numberString.toCharArray()) {
            digitsList.add(Integer.parseInt(String.valueOf(digit)));
        }
        int length = digitsList.size();

        switch (length) {
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
                int leadingDigits = (length % 3 == 0 ? 3 : length % 3);
                Integer magnitude = ((length - leadingDigits) / 3);
                return writtenNumber(Integer.parseInt(numberString.substring(0, leadingDigits)))
                        + magnitudeWord.get(magnitude) +
                        writtenNumber(Integer.parseInt(numberString.substring(leadingDigits)));
        }
    }

    public List<Integer> splitNumber(String numberString) {
        List<Integer> magnitudeList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberString);
        stringBuilder.reverse();

        for (String substring : Splitter.fixedLength(3).split(stringBuilder)) {
            StringBuilder substringBuilder = new StringBuilder();
            substringBuilder.append(substring);
            substringBuilder.reverse();
            magnitudeList.add(Integer.parseInt(substringBuilder.toString()));
        }
        return magnitudeList;
    }

    @BeforeClass
    public void startClass() {
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
        magnitudeWord.put(0, "");
        magnitudeWord.put(1, " thousand");
        magnitudeWord.put(2, " million");
        magnitudeWord.put(3, " billion");
        magnitudeWord.put(4, " trillion");
    }
}
