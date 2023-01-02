package Graph;
import java.util.*;
public class graph_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		graph_new graph = new graph_new();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addedge("A", "B", 2);
		graph.addedge("A", "D", 3);
		graph.addedge("B", "C", 1);
		graph.addedge("C", "D", 8);
		graph.addedge("D", "E", 10);
		graph.addedge("E", "F", 45);
		graph.addedge("E", "G", 7);
		graph.addedge("F", "G", 8);
		
		graph.display();
		
		System.out.println(graph.numEdge());
		System.out.println(graph.numvtex());
		
		
		System.out.println( graph.haspath("A", "F", new HashMap() ));
		System.out.println(graph.bsf("A", "F"));
		System.out.println(graph.dsf("A", "C"));
		
		graph.bst();
		graph.dst();

	}

}
