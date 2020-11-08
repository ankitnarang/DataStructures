package strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        String[] emails = {
                "abc@leetcode.com",
                "a.bc@leetcode.com",
                "ab.c@leetcode.com",
                "ab+c@leetcode.com",
                "abc+@leetcode.com",
                "a+bc@leetcode.com"
        };
        Set<String> uniqueMailIds = numUniqueEmails(emails);
        System.out.println("No. of unique mail address are " + uniqueMailIds.size());
        System.out.println("Unique mails ids are ");
        uniqueMailIds.forEach((x) -> System.out.println(x));
    }

    private static Set<String> numUniqueEmails(String[] emails){
        Set<String> seen = new HashSet();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            // Note: one should escape the specific character '.',
            // since it is treated as a regex expression.
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }

        return seen;
    }
}
