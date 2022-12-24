package Recursion_Backtracing;

import java.util.ArrayList;
import java.util.Collections;

public class sum_subset {
	
	public static void sum_subset(int i,int sum, ArrayList <Integer> list , int[] arr)
	{
		if(i== arr.length)
		{
			list.add(sum);
			return ;
		}
		
		
		sum_subset(i+1, sum + arr[i] , list ,arr );
		sum_subset(i+1, sum , list ,arr );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,3,4};
		ArrayList <Integer> list = new ArrayList<>();
		
		 sum_subset(0 ,0 ,list ,arr);
		Collections.sort(list);
		System.out.println(list);
		

	}

}
