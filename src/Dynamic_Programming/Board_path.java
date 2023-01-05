package Dynamic_Programming;

public class Board_path {
	
	public static int BPrecursion(int curr, int end)
	{
		if(curr == end)
		{
			return 1;
		}
		
		if (curr > end)
		{
			return 0;
		}
		
		int count =0;
		
		for(int d = 1 ; d<=6 ; d++)
		{
			count += BPrecursion(curr+d, end);
		}
		
		return count;
		
	}
	
	public static int BPTD(int curr, int end , int[] strg)
	{
		if(curr == end)
		{
			return 1;
		}
		
		if (curr > end)
		{
			return 0;
		}
		
		if (strg[curr] != 0)
		{
			return strg[curr];
		}
		
		int count =0;
		
		for(int d = 1 ; d<=6 ; d++)
		{
			count += BPTD(curr+d, end , strg);
		}
		
		strg[curr] = count;
		
		return count;
		
	}
	
	public static int BPBU(int end)
	{
		int [] strg = new int[end+6];
		strg[end] = 1;
		for(int i=end-1 ; i>=0 ;i--)
		{
			strg[i] = strg[i+1]+strg[i+2]+strg[i+3]+strg[i+4]+strg[i+5]+strg[i+6];
		}
		
		return strg[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int end = 40;
		System.out.println(BPrecursion(0, 10));
		System.out.println(BPTD(0 ,end, new int [end]));
	}

}
