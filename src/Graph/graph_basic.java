package Graph;
import java.util.*;

public class graph_basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n =4, m=4;
		
		ArrayList <ArrayList<Integer>> adj = new ArrayList <ArrayList<Integer>> ();
		
		for(int i=0; i<n; i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(1).add(3);
		adj.get(3).add(1);
		
		for(int i=1 ;  i<n; i++)
		{
			for(int j=0; j< adj.get(i).size(); j++)
			{
				System.out.println(adj.get(i).get(j) + " ");
			}
			
			System.out.println();
		}
	}

}
