

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidationNetwork {

    /**Email Pattern for validating an email address**/
    private static final String EMAIL_PATTERN = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    
    /**Number Pattern for validating a number**/
    private static final String NUMBER_PATTERN = "\\d{6,10}";

    /**mail container to check duplicate mail id**/
    private static HashSet<String> mailContainer = new HashSet<>();
    
    /**name container to check duplicate name**/
    private static HashSet<String> nameContainer = new HashSet<>();
    
    /**pattern object of Pattern class**/
    private static Pattern pattern;
    
    /**matcher object of Matcher class**/
    private static Matcher matcher;

    /**
     * checkMail Method
     *
     * @param mailID
     * @return true if Mail Id is valid
     */
    public static boolean checkMail(String mailID) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(mailID);
        return matcher.matches();
    }

    /**
     * checkNumber Method
     *
     * @param contact
     * @return true if contact Number is valid
     */
    public static boolean checkNumber(String contact) {
        pattern = Pattern.compile(NUMBER_PATTERN);
        matcher = pattern.matcher(contact);
        return matcher.matches();
    }

    /**
     * checkDuplicacy Method
     *
     * @param mailId
     * @return true if mailId is unique
     */
    
    public static boolean checkDuplicacy(String mailId) {
        return mailContainer.add(mailId);
    }
    
    /**
     * checkName Method
     *
     * @param name
     * @return true if name is unique
     */
    public static boolean checkName(String Name) {
        return nameContainer.add(Name);
    }
}
