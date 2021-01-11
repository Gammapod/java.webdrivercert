package challenges.challenge4;

import java.util.ArrayList;

public class fibonacci {
    public static ArrayList<Integer> getFibonacciUpTo(int order) {
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
}
