package Recursion_Backtracing;
import java.util.*;

public class String_palindrome {
	
	public static boolean palindrome(String str, int l, int r)
	{
		if(l>=r)
		{
			return true;
		}
		palindrome(str, l+1, r-1);
		if(str.charAt(l) == str.charAt(r))
		{
			return  true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "abcdcbas";
		System.out.println(palindrome(str, 0 , str.length()-1));

	}

}
