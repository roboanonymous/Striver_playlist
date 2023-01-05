package Dynamic_Programming;

public class Fibbonachi {
	
	public static int fibb (int n)
	{
		if( n==0 || n==1)
		{
			return n;
		}
		
		int a = fibb(n-1);
		int b = fibb(n-2);
		
		return a+b;
	}

	public static int fibbTD (int n , int [] strg)
	{
		if( n==0 || n==1)
		{
			return n;
		}
		
		if(strg[n] != 0)
		{
			return strg[n];
		}
		int a = fibbTD(n-1 , strg);
		int b = fibbTD(n-2 , strg);
		int fn = a+b;
		
		strg[n] = fn;
		return fn;
	}
	
	public static int fibBU (int n)
	{
		int [] strg = new int[n+1];
		
		strg[0] =0;
		strg[1] = 1;
		
		for(int i=2 ; i<=n ; i++)
		{
			strg[i] = strg[i-1] + strg[i-2];
		}
		
		return strg[n];
	}
	
	public static int FibBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {
			int temp = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = temp;
		}

		return strg[1];

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =45;
		System.out.println(fibbTD(n, new int[n+1] ));
		System.out.println(fibBU (100000));
		
	}

}
