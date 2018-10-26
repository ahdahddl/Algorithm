import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;

public class traveling_salesman {
	
	static int N;	//도시의 수
	static double dist[][] = new double[N][N];
	static LinkedList<Integer> path = new LinkedList<Integer>();
	static int[] visited = new int[N];
	
	double shortestPath(double currentLength){
		if(path.size() == N){
			return currentLength + dist[path.getFirst()][path.getLast()];
		}
		
		double ret = 10000000.0d;
		
		for(int next = 0; next < N; next++){
			if(visited[next] == 0){
				int here = path.getLast();
				path.add(next);	
				visited[next] = 1;
				double distance = shortestPath(currentLength + dist[here][next]);
				ret = Math.min(ret, distance);
				visited[next] = 0;
				path.remove(next);
			}
		}
		return ret;
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		// 1. visted set
		
		// 2. get shortest path
	}

}
