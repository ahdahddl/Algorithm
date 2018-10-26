import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class boarder_cover {

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

	static final int TYPE = 4;
	static final int BLOCK = 3;
	static final int COORD = 2;
	static final int[][][] coverType = {
			{{0,0},{1,0},{0,1}},
			{{0,0},{0,1},{1,1}},
			{{0,0},{1,0},{1,1}},
			{{0,0},{1,0},{0,-1}}
	};
	
	static List<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
		
	boolean set(int y, int x, int type, int delta){
		boolean ret = true;
		for(int block = 0; block < BLOCK; block++){
			int ny = y + coverType[type][block][1];
			int nx = x + coverType[type][block][0];
			 
			board.get(ny).set(nx, Integer.valueOf(board.get(ny).get(nx) + delta));
			
			if(ny < 0 || ny >= board.size() || nx < 0 || nx >= board.size()){
				ret = false;
			}else if(board.get(ny).get(nx) > 1){
				ret = false;
			}
		}
		return ret;
	}
	
	int cover(){
		int y = -1, x = -1;
		// 채워지지않은 맨 위의 y 를 찾는다.
		for(int i = 0; i < board.size(); i++){
			for(int j = 0; j < board.get(i).size(); j++){
				if(board.get(i).get(j) == 0){
					y = i;
					x = j;
					break;
				}
			}
			if(y != -1) break;
		}
		// 기저사례
		if(y == -1) return 1;
		
		int ret = 0;
		for(int type = 0; type < 4; type++){
			if(set(y, x, type, 1)){
				ret += cover();
			}
			set(y, x, type, -1);
		}
		
		return ret;
	}
	
}
