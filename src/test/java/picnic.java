import org.junit.Before;
import org.junit.BeforeClass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.fail;

public class picnic {
	
	static final String file = "";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//fail("Not yet implemented");
		FileInputStream fis = new FileInputStream(file);
		 
		//Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	 
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	@Before
	public void setUp() throws Exception {
	}

	//@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	static final int N = 10;
	static boolean[] taken = new boolean[N];
	static boolean[][] areFriends = new boolean[N][N];
	
	int countPairs(boolean[] taken){
		
		int first = -1;
		for(int i = 0; i < N; i++){
			if(!taken[i]){
				first = i;
				break;
			}
		}
		
		if(first == -1) return 1;
		int ret = 0;
		for(int pairWith = first + 1; pairWith < N; pairWith++){
			if(!taken[pairWith] && areFriends[first][pairWith]){
				taken[first] = taken[pairWith] = true;
				ret += countPairs(taken);
				taken[first] = taken[pairWith] = false;
			}
		}
		
		return ret;
	}

}
