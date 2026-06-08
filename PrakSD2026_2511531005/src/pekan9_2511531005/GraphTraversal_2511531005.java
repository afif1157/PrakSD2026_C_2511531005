package pekan9_2511531005;
import java.util.*;

public class GraphTraversal_2511531005 {

    private Map<String, List<String>> graph_1005 = new HashMap<>();
    
    public void addEdge_1005(String node1_1005, String node2_1005) {
        graph_1005.putIfAbsent(node1_1005, new ArrayList<>());
        graph_1005.putIfAbsent(node2_1005, new ArrayList<>());
        graph_1005.get(node1_1005).add(node2_1005);
        graph_1005.get(node2_1005).add(node1_1005);
            
    }
    
    public void printGraph_1005() {
        System.out.println("graf awal (adjacency list) : ");
        for(String node_1005 : graph_1005.keySet()) {
            System.out.print(node_1005 + " -> ");
            List<String> neighbors_1005 = graph_1005.get(node_1005);
            System.out.println(String.join(", ", neighbors_1005));
        }
        System.out.println();
    }
    
    public void dfs_1005(String start_1005) {
        Set<String> visited_1005 = new HashSet<>();
        System.out.println("penelusuran DFS : ");
        dfsHelper_1005(start_1005, visited_1005);
        System.out.println();
    }
    
    public void dfsHelper_1005(String current_1005, Set<String> visited_1005) {
        if(visited_1005.contains(current_1005)) return;
        visited_1005.add(current_1005);
        System.out.print(current_1005 + " ");
        for(String neighbor_1005 : graph_1005.getOrDefault(current_1005, new ArrayList<>())) {
            dfsHelper_1005(neighbor_1005, visited_1005);
        }
    }
    
    public void bfs_1005(String start_1005) {
        Set<String> visited_1005 = new HashSet<>();
        Queue<String> queue_1005 = new LinkedList<>();
        queue_1005.add(start_1005);
        visited_1005.add(start_1005); 
        
        System.out.println("penelusuran BFS:");
        while(!queue_1005.isEmpty()) {
            String current_1005 = queue_1005.poll();
            System.out.print(current_1005 + " ");
            for (String neighbor_1005 : graph_1005.getOrDefault(current_1005, new ArrayList<>())) {
                if(!visited_1005.contains(neighbor_1005)) {
                    queue_1005.add(neighbor_1005);
                    visited_1005.add(neighbor_1005);
                }
            }
        }
        System.out.println();
        
    }
    
    public static void main (String[] args) {
        
        GraphTraversal_2511531005 graphObj_1005 = new GraphTraversal_2511531005 ();
        
        graphObj_1005.addEdge_1005("A", "B");
        graphObj_1005.addEdge_1005("A", "C");
        graphObj_1005.addEdge_1005("B", "D"); 
        graphObj_1005.addEdge_1005("B", "E");
        
        System.out.println("graf awal adalah :");
        graphObj_1005.printGraph_1005();
        
        graphObj_1005.dfs_1005("A");
        graphObj_1005.bfs_1005("A");
    }
}