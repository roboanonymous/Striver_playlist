package Graph;
import java.util.*;
public class graph_new {
	
	public class vertex
	{
		HashMap <String , Integer> nbrs = new HashMap<>();
		
	}
	
	HashMap <String , vertex> vtces ;
	
	public graph_new()
	{
		vtces = new HashMap<>();
		
	}
	
	public int numvtex()
	{
		return vtces.size();
	}
	
	public boolean containVertex (String vname)
	{
		return this.vtces.containsKey(vname);
	}
	
	public void addVertex (String vname)
	{
		vertex vtx = new vertex();
		vtces.put(vname, vtx);
	}
	
	public void removeVertex (String vname)
	{
		vertex vtx = vtces.get(vname);
		ArrayList <String> keys = new ArrayList<>(vtx.nbrs.keySet());
		
		for (String key: keys)
		{
			vertex nbrvtx = vtces.get(key);
			nbrvtx.nbrs.remove(vname);
		}
		
		vtces.remove(vname);
	}
	
	
	
	public int numEdge()
	{
		ArrayList <String> keys = new ArrayList<>(vtces.keySet());
		int count = 0;
		for(String key : keys)
		{
			vertex vtx = vtces.get(key);
			count +=  vtx.nbrs.size();
		}
		
		return count/2;
	}
	
	public boolean containedge (String vname1 , String vname2)
	{
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		if( vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
		{
			return false;
		}
		
		return true;
	}
	
	public void addedge (String vname1 , String vname2, int cost)
	{
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		
		if( vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2))
		{
			return;
		}
		
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);	
	}
	
	public void removeedge (String vname1 , String vname2)

	{
		vertex vtx1 = vtces.get(vname1);
		vertex vtx2 = vtces.get(vname2);
		
		if( vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
		{
			return;
		}
		
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);	
	}

	public void display()
	{
		System.out.println("----------------------------");
		
		ArrayList <String> keys = new ArrayList <> (vtces.keySet());
		
		for(String key : keys)
		{
			vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbrs);
		}
		
		System.out.println("------------------------------");
	}
	
	public boolean haspath (String vname1 , String vname2 , HashMap <String , Boolean> processed)
	{
		processed.put(vname1, true);
		if(containedge(vname1, vname2))
		{
			return true;
		}
		
		vertex vtx = vtces.get(vname1);
	
		ArrayList <String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		
		for( String nbr : nbrs)
		{
			if( !processed.containsKey(nbr) && haspath(nbr, vname2, processed))
			{
				return true;
			}
		}
		
		return false;
		
	}

	private class pair
	{
		String vname ;
		//path so far
		String psf;
	}
	
	public boolean bsf (String src , String dst)
	{
		HashMap <String , Boolean> processed = new HashMap<>();
		LinkedList <pair> queue = new LinkedList<>();
		
		// Create a new pair
		pair sp = new pair();
		sp.vname = src;
		sp.psf = src;
		
		
		queue.addLast(sp);
		
		while(!queue.isEmpty())
		{
			pair rp = queue.removeFirst();
			
			if(processed.containsKey(rp.vname))
			{
				continue;
			}
			
			processed.put(rp.vname, true);
			
			if(containedge(rp.vname , dst))
			{
				System.out.println(rp.psf + dst);
				return true;
			}
			
			vertex rpvtx = vtces.get(rp.vname);
			ArrayList <String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			
			for( String nbr: nbrs)
			{
				if(!processed.containsKey(nbr))
				{
					pair np = new pair();
					np.vname = nbr;
					np.psf = rp.psf+ nbr;
					
					queue.addLast(np);
				}
			}
			
		}
		
		return false;
		
	}
	
	public boolean dsf (String src , String dst)
	{
		HashMap <String , Boolean> processed = new HashMap<>();
		LinkedList <pair> stack = new LinkedList<>();
		
		// Create a new pair
		pair sp = new pair();
		sp.vname = src;
		sp.psf = src;
		
		
		stack.addFirst(sp);
		
		while(!stack.isEmpty())
		{
			pair rp = stack.removeFirst();
			
			if(processed.containsKey(rp.vname))
			{
				continue;
			}
			
			processed.put(rp.vname, true);
			
			if(containedge(rp.vname , dst))
			{
				System.out.println(rp.psf + dst);
				return true;
			}
			
			vertex rpvtx = vtces.get(rp.vname);
			ArrayList <String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			
			for( String nbr: nbrs)
			{
				if(!processed.containsKey(nbr))
				{
					pair np = new pair();
					np.vname = nbr;
					np.psf = rp.psf+ nbr;
					
					stack.addFirst(np);
				}
			}
			
		}
		
		return false;
		
	}
	

	public void bst ()
	{
		HashMap <String , Boolean> processed = new HashMap<>();
		
		ArrayList <String> keys = new ArrayList<>(vtces.keySet());
		
		LinkedList <pair> queue = new LinkedList<>();
		
		for(String key : keys)
		{
			if(processed.containsKey(key))
			{
				continue;
			}
			
			// Create a new pair
			pair sp = new pair();
			sp.vname = key;
			sp.psf = key;
			
			
			queue.addLast(sp);
			
			while(!queue.isEmpty())
			{
				pair rp = queue.removeFirst();
				
				if(processed.containsKey(rp.vname))
				{
					continue;
				}
				
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " "+ rp.psf);
				
				vertex rpvtx = vtces.get(rp.vname);
				ArrayList <String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				for( String nbr: nbrs)
				{
					if(!processed.containsKey(nbr))
					{
						pair np = new pair();
						np.vname = nbr;
						np.psf = rp.psf+ nbr;
						
						queue.addLast(np);
					}
				}
				
			}
			
			
			
		}
		
		
		
	}
	
	public void dst ()
	{
		HashMap <String , Boolean> processed = new HashMap<>();
		LinkedList <pair> stack = new LinkedList<>();
		ArrayList <String> keys = new ArrayList<>(vtces.keySet());
		
		for(String key : keys)
		{
			if(processed.containsKey(key))
			{
				continue;
			}
			
			
			// Create a new pair
			pair sp = new pair();
			sp.vname = key;
			sp.psf = key;
			
			
			stack.addFirst(sp);
			
			while(!stack.isEmpty())
			{
				pair rp = stack.removeFirst();
				
				if(processed.containsKey(rp.vname))
				{
					continue;
				}
				
				processed.put(rp.vname, true);
				
				System.out.println(rp.vname + " " + rp.psf);
				
				vertex rpvtx = vtces.get(rp.vname);
				ArrayList <String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				
				for( String nbr: nbrs)
				{
					if(!processed.containsKey(nbr))
					{
						pair np = new pair();
						np.vname = nbr;
						np.psf = rp.psf+ nbr;
						
						stack.addFirst(np);
					}
				}
				
			}
		}
		
		
		
		
	
		
	}

}
