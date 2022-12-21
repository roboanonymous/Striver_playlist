
public class Sum {
	
	public static int sum_n(int n)
	{
		if(n == 0) {
			return 0;
		}
		
		int count =0;
		count = count+n+sum_n(n-1);
		return count;
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sum_n(10));
	}

}
