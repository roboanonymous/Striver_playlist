
public class Print_number {
	
	public static void number(int n)
	{
		if(n==0)
		{
			return;
		}
		
		number(n-1);
		System.out.println(n);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		number(10);
	}

}
