package Recursion_Backtracing;

import java.util.ArrayList;

public class Combination_sum {
	
	public static void com_sum(int i, int target, ArrayList <Integer> list, int [] arr, int n)
	{
		if(i == n)
		{
			if(target == 0)
			{
				System.out.println(list);
				
			}
			
			return;
		}
		
		
		if(arr[i] <= target)
		{
			list.add(arr[i]);
			
			com_sum(i,target - arr[i],list ,arr, n);
			list.remove(list.size()-1);
			
		}
		
		com_sum(i+1,target ,list ,arr, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {2,3, 6,7};
		int n= arr.length;
		int target = 7;
		ArrayList <Integer> list = new ArrayList<>();
		
		com_sum(0, target ,list ,arr, n);

	}

}
