import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

class quad{
	public quad[] quadMap = new quad[4];
	public char type;
	public boolean base = false;
	
	public quad(){	
	}
}

public class quad_tree {	

	public void changeSeq(quad[] quadMap){
		quad temp = quadMap[0];
		quadMap[0] = quadMap[1];
		quadMap[2] = temp;
		
		temp = quadMap[1];
		quadMap[1] = quadMap[3];
		quadMap[3] = temp;
	}
	
	public quad[] baseQuad = new quad[4];
	
	public String reverse(String word, int index){
		char c = word.charAt(index); 
		if(c == 'b' || c == 'w'){			
			return new StringBuilder().append("").append(c).toString();
		}
		
		String upperLeft = reverse(word, ++index);
		String upperRight = reverse(word, ++index);
		String lowerLeft = reverse(word, ++index);
		String lowerRight = reverse(word, ++index);
		
		return new StringBuilder().append("x") + lowerLeft + lowerRight + upperLeft + upperRight;
	}
	
	void change(String compressed, quad[] quadMap, int mapIndex){
		if(mapIndex == 4){
			changeSeq(quadMap);
			return;
		}
		for(int i = 0; i < compressed.length(); i++){
			quadMap[mapIndex] = new quad();
			if(compressed.charAt(i) == 'w' || compressed.charAt(i) == 'b'){
				quadMap[mapIndex].base = true;
				quadMap[mapIndex].type = compressed.charAt(i);
				change(compressed.substring(1, compressed.length()), quadMap, mapIndex + 1);
			}else{
				quadMap[mapIndex].base = false;
				change(compressed.substring(1, compressed.length()), quadMap[mapIndex].quadMap, 0);
			}
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
		//change("xwbbw", baseQuad, 0);
		String ret = reverse("xbwxwbbwb", 0);
		System.out.println(ret);
		assertThat(ret, is("xxbwwbbbw"));
		
	}

}
