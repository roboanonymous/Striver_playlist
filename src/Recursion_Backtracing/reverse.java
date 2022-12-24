package Recursion_Backtracing;
import java.util.*;

public class reverse {

	public static void reverse_num(int [] arr, int l, int r)
	{
		if(l>= r)
		{
			return;
		}
		
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
		
		reverse_num(arr, l+1, r-1);
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		
		reverse_num(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}

}
