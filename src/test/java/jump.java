import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class jump {
	
	int n;
	int[][] board = new int[100][100];
	int[][] cache = new int[100][100];
	
	int doJump(int y, int x){
		if(y >= n || x >= n){
			return 0;
		}
		if(y == n - 1 || x == n - 1){
			return 1;
		}
		int ret = cache[y][x];
		if(ret != -1){
			return ret;
		}		
		
		int jumpSize = board[y][x];		
		int xt = doJump(y + jumpSize, x);
		int yt = doJump(y, x + jumpSize);
		if(xt == 1 || yt == 1){
			return 1;
		}else{
			return 0;
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
