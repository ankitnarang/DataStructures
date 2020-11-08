package strings;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        result.forEach((x) -> System.out.print(x + " "));
    }

    private static List<Integer> partitionLabels(String s) {
        List<Integer> partions = new ArrayList<>();

        int[] lastindexes = new int[26];

        for(int i = 0; i < s.length(); i++){
            lastindexes[s.charAt(i) - 'a'] = i;
        }

        int i = 0;

        while (i < s.length()) {
            int end = lastindexes[s.charAt(i) - 'a'];
            int j = i;
            while (j != end) {
                end = Math.max(end, lastindexes[s.charAt(j) - 'a']);
                j++;
            }

            partions.add(j - i  + 1);
            i = j + 1;
        }

        return partions;
    }

}
