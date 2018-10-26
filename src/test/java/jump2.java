import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

public class jump2 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	int n;
	int[][] board = new int[100][100];

	boolean jump(int y, int x){
		if(y >= n || x >= n) return false;

		if(y == n - 1 && x == n - 1) return true;

		int jumpSize = board[y][x];
		return jump(y + jumpSize, x) || jump(y, x + jumpSize);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
