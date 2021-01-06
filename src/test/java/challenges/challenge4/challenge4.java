package challenges.challenge4;

import challenges.challengeBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class challenge4 {
    public ArrayList<Integer> fibonacci(int order) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        if(order == 1){return result;}
        order--;
        result.add(1);
        if(order == 1){return result;}
        order--;
        for (int i = order; i > 0; i--){
            result.add(result.get(result.size() - 1) + result.get(result.size() - 2));
        }
        return result;
    }
    @Test()
    public void writeOutFibonacci() {
        ArrayList<Integer> sequence = fibonacci(10);
        for(Integer item : sequence){
//          todo: find a way to get the written words of the number. A generalized solution would probably be overkill;
//           a list of the written-out fibonacci numbers makes more sense I think
            String writtenItem = "written item";
            System.out.println(item + " - " + writtenItem);
        }
    }
}
