package strings;

public class DefangingIPAddress {

    public static void main(String[] args) {
        String ipAddress = "10.255.9.255";
        System.out.println("The defang version of IP Address is " + defangIPAddress(ipAddress));
    }

    private static String defangIPAddress(String ipAddress) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < ipAddress.length(); i++){
            char current = ipAddress.charAt(i);
            if(current == '.'){
                result.append("[.]");
            } else {
                result.append(current);
            }
        }
        return result.toString();
    }

}


