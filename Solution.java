package atoi;

import java.util.Arrays;

/*
Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
Note:
Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-2^31,  2^31 - 1]. 
If the numerical value is out of the range of representable values, INT_MAX (2^31 - 1) or INT_MIN (-2^31) is returned.
*/

public class Solution {
	
	public static int myAtoi(String str) {
		int a=0;
		String num="";
		
        String s = removeWhiteSpace(str);
        
        if(s.length()==1) {
        	if(checkForPlusOrMinus(s)) {
        		return 0;
        	}else {
        		if(reqCheck(s,0)) {
            		num += getNumber(s,0);
            	}else {
            		return 0;
            	}
        	}
       
        }else if(checkForPlusOrMinus(s) && s.length()>1) {
        	if(reqCheck(s,1)) {
        		num += s.charAt(0);
        		num += getNumber(s,1);
        	}else {
        		return 0;
        	}
        }else {
        	if(reqCheck(s,0)) {
        		num += getNumber(s,0);
        	}else {
        		return 0;
        	}
        }
        
       a += stringToInt(num); 
        
       return a;
        
    }
	
	public static boolean reqCheck(String a, int k) {
		if(a.length()==0 || !Character.isDigit(a.charAt(k)) )  {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static int stringToInt(String a) {
		try{
			int z = Integer.parseInt(a);
			return z;
		}catch(Exception e){
			if(a.charAt(0)=='-'){
				return Integer.MIN_VALUE;
			}else{
				return Integer.MAX_VALUE;
			}
		}
		
	}
	
	public static String removeWhiteSpace(String a) {
		String s = a.trim();
		return s;
	}
	
	public static boolean checkForPlusOrMinus(String a) {
		if(a.length()>0 && (a.charAt(0)=='+' || a.charAt(0)=='-')) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String getNumber(String a, int k) {
		String s="";
		int i=k;
		
		while(i<a.length() && Character.isDigit(a.charAt(i))) {
			s += a.charAt(i);
			i++;
		}
		return s;
	}
	
	
	public static void main(String[] args) {
		
		String a = "   +0 123 ";
		System.out.println(a.length());
		System.out.println(myAtoi(a));
		
//		String s = "    Today is beautiful day";
//		String[] vals = s.split(" ");
//		System.out.println(vals[2].length());
//		System.out.println(Arrays.asList(vals));
		
		
		
		
		
		
		
	}
}
