package Recursion_Backtracing;
import java.util.*;
public class Subsequence_sum {
	
	public static void sum_sub(int i , ArrayList<Integer> list, int s , int sum , int[] arr, int n)
	{ 
		if(i == n)
		{
			if(s == sum)
			{
				System.out.println(list);
				
			}
			
			return;
		}
		
		list.add(arr[i]);
		s += arr[i];
		sum_sub(i+1 , list, s ,sum ,arr ,n);
		
		list.remove(list.size()-1);
		s -= arr[i];
		sum_sub(i+1 , list, s ,sum ,arr ,n);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,3,4,1,2,0};
		int n= arr.length;
		int sum = 4;
		ArrayList <Integer> list = new ArrayList<>();
		
		sum_sub(0 ,list , 0, sum,arr, n);

	}

}
