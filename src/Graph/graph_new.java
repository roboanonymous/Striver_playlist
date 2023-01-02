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
}
