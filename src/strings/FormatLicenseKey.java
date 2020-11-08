package strings;

public class FormatLicenseKey {
    public static void main(String[] args) {
        String str = "2e5F-3Z-2e-9-w";
        int k = 3;
        String result = licenseKeyFormatting(str,k);
        System.out.println("Formatted LK is " + result);
    }

    private static String licenseKeyFormatting(String str, int k) {
        StringBuilder result = new StringBuilder();
        int i = str.length() - 1;
        int count = 0;
        while (i >= 0){
            char current = Character.toUpperCase(str.charAt(i));
            if(current == '-'){
                i--;
            } else if(count != 0 && count % k == 0){
                result.insert(0,'-');
                count = 0;
            } else {
                result.insert(0,current);
                count++;
                i--;
            }
        }
        return result.toString();
    }

}
