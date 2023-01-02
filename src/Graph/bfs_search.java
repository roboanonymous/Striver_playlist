package Graph;

import java.util.*;

public class bfs_search {
	
	public static ArrayList<Integer> bfsofGraph (int v, ArrayList<ArrayList<Integer>> adj)
	{
		ArrayList <Integer> bfs = new ArrayList<>();
		Boolean Vis[] = new Boolean[v];
		Queue <Integer> q = new LinkedList<>();
		
		q.add(0);
		Vis[0] = false;
		
		while(!q.isEmpty())
		{
			Integer node = q.poll();
			bfs.add(node);
			
			
			for(Integer it : adj.get(node))
			{
				if(Vis[it] == false)
				{
					Vis[it] = true;
					q.add(it);
				}
			}
		}
		
		return bfs;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
