package strings;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

    public static void main(String[] args) {
        String str = "+-+++-++";
        List<String> list = generatePossibleNextMoves(str);
        list.forEach((x) -> System.out.println(x));
    }

    private static List<String> generatePossibleNextMoves(String str) {
        List<String> possibleStates = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int nextMove = (i == 0 ? str.indexOf("++") : str.indexOf("++",i));
            if(nextMove == -1){
                return possibleStates;
            }

            String nextState = str.substring(0,nextMove) + "--" + str.substring(nextMove + 2);
            possibleStates.add(nextState);
            i = nextMove + 1;
        }
        return possibleStates;
    }
}
