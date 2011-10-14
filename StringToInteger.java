// Programmer : Farrin A. Reid

/*
String-to-Int Conversion Function

Description: Given a String of digits (and possibly signs) such as "123", write
             a routine int stringToInteger( String s ) that converts the string
             to an integer, without using the built in Java functions that
             would do this. The code should handle reasonable edge and error 
             conditions gracefully. (You can rely on the input being in 
             base-10 representation - no need to worry about hex, octal, or 
             binary input.)
*/


public class StringToInteger{
    public static int stringToInteger(String s)
     throws Exception
    {
        boolean negative = false;
        int result = 0, i = 0;
        int digit, limit;

        if (s.length() <= 0) {
            throw new Exception("Empty String");
        } else {
            if (s.charAt(0) == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
                i++;
            }else{
                if (s.charAt(0) == '+') {i++;}
                limit = -Integer.MAX_VALUE;
            }

            if (i < s.length()) {
                digit = Character.digit(s.charAt(i++),10);
                if (digit < 0) {
                    throw new Exception("Bad character: '"+s.charAt(i-1)+"'");
                } else {
                    result = -digit;
                }
            }
            while (i < s.length()) {
                digit = Character.digit(s.charAt(i++),10);
                result *= 10;
                if (result < limit + digit) {
                    throw new Exception("Exceedes Integer limit at index "+Integer.toString(i-1)+" in '"+s+"'");
                }
                result -= digit;        
            }
        }

        
        if (i > 1) {
            if (negative) {
                return result;
            } else {
                return -(result);
            }    
        } else {     
            throw new Exception("Invalid number: '"+s+"'");
        }
        
    }

    public static void main(String[] args) 
    {
        System.out.println("TEST 1 : Empty String ");
        try{
            stringToInteger("");
            System.out.println("FAILED");
        }
        catch (Exception e) {
            System.out.println("PASSED");
        }
        
        System.out.println("TEST 2 : '+' String ");
        try{
            stringToInteger("+");
            System.out.println("FAILED");
        }
        catch (Exception e) {
            System.out.println("PASSED");
        }
        
        System.out.println("TEST 3 : '-' String ");
        try{
            stringToInteger("-");
            System.out.println("FAILED");
        }
        catch (Exception e) {
            System.out.println("PASSED");
        }
        
        System.out.println("TEST 4 : Bad Character ");
        try{
            stringToInteger("deadbeef");
            System.out.println("FAILED");
        }
        catch (Exception e) {
            System.out.println("PASSED");
        }
        
        System.out.println("TEST 5 : MIN VALUE ");
        try{
            //Integer.MIN_VALUE-1, system specific
            String small = "-2147483649";
            stringToInteger(small);
            System.out.println("FAILED");
        }
        catch (Exception e) {
            System.out.println("PASSED");
        }
        
        System.out.println("TEST 6 : MAX VALUE ");
        try{
            //Integer.MAX_VALUE+1, system specific
            String large = "2147483648";
            stringToInteger(large);
            System.out.println("FAILED");
        }
        catch (Exception e) {
            System.out.println("PASSED");
        }
        
        System.out.println("TEST 7 : Correct VALUE 1");
        try{
            if ( stringToInteger("1337") == 1337) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }
        catch (Exception e) {
            System.out.println("FAILED");
        }
        
        System.out.println("TEST 8 : Correct VALUE 2");
        try{
            if ( stringToInteger("-7331") == -7331) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }
        catch (Exception e) {
            System.out.println("FAILED");
        }
        
        System.out.println("TEST 9 : Correct VALUE 3");
        try{
            if ( stringToInteger("+1337") == 1337) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
        }
        catch (Exception e) {
            System.out.println("FAILED");
        }

        
    }
}