import java.util.HashSet;

public class StoreState {
	
	public static int [][] cube = new int [6][4];
	
	public static void main(String[] args) {
				
		HashSet<PocketCubeSolver> combinations = new HashSet<PocketCubeSolver>();	
		
		combinations.contains(cube);
		System.out.println(combinations);
		
		}
	}	
