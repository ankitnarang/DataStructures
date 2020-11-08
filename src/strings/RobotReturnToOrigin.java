package strings;

public class RobotReturnToOrigin {

    public static void main(String[] args) {
        String str = "UDLRRL";
        System.out.println("Is Robit returning to Origin? " + judgeCircle(str));
    }

    private static boolean judgeCircle(String str) {
        int UD = 0;
        int LR = 0;

        for(int i  = 0; i < str.length(); i++){
            char currentMove = str.charAt(i);
            if(currentMove == 'L'){
                LR++;
            } else if(currentMove == 'R'){
                LR--;
            } else if(currentMove == 'U') {
                UD++;
            } else if(currentMove == 'D'){
                UD--;
            }
        }

        return UD == 0 && LR == 0;

    }

}
