package Recursion_Backtracing;
import java.util.*;

public class print_permutation {
	
	public static void print_per (String str, String perm, int idx)
	{
		if(str.length() == 0)
		{
			System.out.println(perm);
			return;
		}
		
		
		
		for(int i=0; i< str.length(); i++)
		{
			char currChar = str.charAt(i);
			String newstr =  str.substring(0, i)  + str.substring(i+1);
			print_per (newstr, perm + currChar, idx+1);
			
		}
	}

	
	public static void main(String[] args) 
	{
		
		String str = "ABCD";
		
		print_per (str, "", 0);
		
		
	}
}
