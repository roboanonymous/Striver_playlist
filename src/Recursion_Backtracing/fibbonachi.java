package Recursion_Backtracing;

public class fibbonachi {
	
	public static int fibb(int n)
	{
		if(n==1)
		{
			return 0;
		}
		if(n==2)
		{
			return 1;
		}
		
		return (fibb(n-1) + fibb(n-2));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibb(6));

	}

}
