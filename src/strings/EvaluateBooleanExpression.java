package strings;

public class EvaluateBooleanExpression {
    public static void main(String[] args) {
        String str = "1C1B1B0A1"; //"1C1B1B0A0"; //""1A0B1";
        StringBuilder sb = new StringBuilder(str);
        System.out.println("The result is " + eval(sb));
    }

    private static char eval(StringBuilder sb) {
        char operand1 = 0, operand2 = 0;
        char result = 0;

        for(int i = 0; i < sb.length()-2; i = i + 2){
            char ch = sb.charAt(i+1);
            operand1 = sb.charAt(i);
            operand2 = sb.charAt(i+2);
            if(ch == 'A'){
               if(operand1 == '0' || operand2 == '0'){
                   result = '0';
               } else {
                   result = '1';
               }
            } else if(ch == 'B'){
                if(operand1 == '1' || operand2 == '1'){
                    result = '1';
                } else {
                    result = '0';
                }
            } else if(ch == 'C'){
                if(operand1 == operand2 ){
                    result = '0';
                } else {
                    result = '1';
                }
            }
            sb.setCharAt(i+2,result);
        }

        return sb.charAt(sb.length()-1);
    }
}
