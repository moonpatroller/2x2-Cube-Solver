
public class PocketCubeSolver {
	static void print_sides(int cube [][], int first_side, int side_count) {
		char ColorNames [] = {'W','O','G','R','B','Y'};
		for(int line  = 0; line < 2; line++) { 
			for(int side = first_side; side < side_count + first_side; side++) {
				System.out.print(" ");
				if(side_count == 1 || side_count == 6) {
						System.out.print("   ");
					}
				for(int column = 0; column < 2; column++) {
					int sticker = (2 * line) + column;
					System.out.print(ColorNames [cube[side][sticker]]);
				}
			}
		System.out.println();
			}
	}
	public static void turn_CW(int cube[][], int side_num){
		  
			  int cube0_0 = cube[side_num][0];
		cube[side_num][0] = cube[side_num][2];
		cube[side_num][2] = cube[side_num][3];
		cube[side_num][3] = cube[side_num][1];
		cube[side_num][1] = cube0_0;
	
		
		}
	public static void turn_CC(int cube[][], int side_num){
		
			  int cube0_0 = cube[side_num][0];
		cube[side_num][0] = cube[side_num][1];
		cube[side_num][1] = cube[side_num][3];
		cube[side_num][3] = cube[side_num][2];
		cube[side_num][2] = cube0_0;
	}
	public static void turn_C2(int cube[][], int side_num){
		
			  int cube0_0 = cube[side_num][0];
			  int cube0_1 = cube[side_num][2];  
		cube[side_num][0] = cube[side_num][1];
		cube[side_num][2] = cube[side_num][3];
		cube[side_num][1] = cube0_1;
		cube[side_num][3] = cube0_0;

	}
	 static void turn_U(int cube [][]){
		 turn_CW(cube, 0);
		int cube2_0 = cube[2][0];
		int cube2_1 = cube[2][1];
		cube[2][0] = cube[3][0];
		cube[2][1] = cube[3][1];
		
		cube[3][0] = cube[4][0];
		cube[3][1] = cube[4][1];
		
		cube[4][0] = cube[1][0];
		cube[4][1] = cube[1][1];
		
		cube[1][0] = cube2_0;
		cube[1][1] = cube2_1;
		System.out.println("U ");
		}
	 static void turn_F(int cube[][]){
		 turn_CW(cube, 2);
		 int cube0_2 = cube[0][2];
		 int cube0_3 = cube[0][3];
		 cube[0][2] = cube[1][3];
		 cube[0][3] = cube[1][1];
		 
		 cube[1][1] = cube[5][0];
		 cube[1][3] = cube[5][1];
		 
		 cube[5][0] = cube[3][2];
		 cube[5][1] = cube[3][0];
		 
		 cube[3][2] = cube0_3;
		 cube[3][0] = cube0_2;	 
		System.out.println("F ");
	 }
	 
	 static void turn_R(int cube[][]){
		 turn_CW(cube,3);
		 int cube0_1 = cube[0][1];
		 int cube0_3 = cube[0][3];
		 
		 cube[0][1] = cube[2][1];
		 cube[0][3] = cube[2][3];
		 
		 cube[2][1] = cube[5][1];
		 cube[2][3] = cube[5][3];
		 
		 cube[5][1] = cube[4][2];
		 cube[5][3] = cube[4][0];
		 
		 cube[4][2] = cube0_1;
		 cube[4][0] = cube0_3;
		 System.out.println("R ");
	 }
	 static void turn_L(int cube[][]){
		 turn_CW(cube,1);
		 int cube0_0 = cube[0][0];
		 int cube0_2 = cube[0][2];
		 
		 cube[0][0] = cube[4][1];
		 cube[0][2] = cube[4][3];
		 
		 cube[4][1] = cube[5][2];
		 cube[4][3] = cube[5][0];
		 
		 cube[5][2] = cube[2][2];
		 cube[5][0] = cube[2][0];
		 
		 cube[2][2] = cube0_2;
		 cube[2][0] = cube0_0;
		 System.out.println("L ");
	 }
	 static void turn_B(int cube[][]){
		 turn_CW(cube,4);
		 int cube0_0 = cube[0][0];
		 int cube0_1 = cube[0][1];
		 
		 cube[0][0] = cube[3][1];
		 cube[0][1] = cube[3][3];
		 
		 cube[3][1] = cube[5][3];
		 cube[3][3] = cube[5][2];
		 
		 cube[5][3] = cube[1][2];
		 cube[5][2] = cube[1][0];
		 
		 cube[1][2] = cube0_0;
		 cube[1][0] = cube0_1;
		 System.out.println("B ");
	 }
	 
	 static void turn_D(int cube[][]){
		 turn_CW(cube,5);
		 int cube2_2 = cube[2][2];
		 int cube2_3 = cube[2][3];
		 
		 cube[2][2] = cube[1][2];
		 cube[2][3] = cube[1][3];
		 
		 cube[1][2] = cube[4][2];
		 cube[1][3] = cube[4][3];
		 
		 cube[4][2] = cube[3][2];
		 cube[4][3] = cube[3][3];
		 
		 cube[3][2] = cube2_2;
		 cube[3][3] = cube2_3;
		 System.out.println("D ");
		 }
	 
	 static void turn_Ui(int cube[][]){
		 turn_CC(cube,0);
		 int cube2_0 = cube[2][0];
		 int cube2_2 = cube[2][2];
		 
		 cube[2][0] = cube[1][0];
		 cube[2][1] = cube[1][1];
		 
		 cube[1][0] = cube[4][0];
		 cube[1][1] = cube[4][1];
		 
		 cube[4][0] = cube[3][0];
		 cube[4][1] = cube[3][1];
		 
		 cube[3][0] = cube2_0;
		 cube[3][1] = cube2_2;
		 System.out.println("Ui ");
		 }
	 static void turn_Fi(int cube[][]){
		 turn_CC(cube,2);
		 int cube0_2 = cube[0][2];
		 int cube0_3 = cube[0][3];
		 
		 cube[0][2] = cube[3][0];
		 cube[0][3] = cube[3][2];
		 
		 cube[3][0] = cube[5][1];
		 cube[3][2] = cube[5][0];
		 
		 cube[5][1] = cube[1][3];
		 cube[5][0] = cube[1][1];
		 
		 cube[1][3] = cube0_2;
		 cube[1][1] = cube0_3;
		 System.out.println("Fi ");
 	 }
	static void turn_Ri(int cube[][]){
		turn_CC(cube, 3);
		int cube0_1 = cube[0][1];
		int cube0_3 = cube[0][3];
		
		cube[0][1] = cube[4][2];
		cube[0][3] = cube[4][0];
		
		cube[4][2] = cube[5][1];
		cube[4][0] = cube[5][3];
		
		cube[5][1] = cube[2][1];
		cube[5][3] = cube[2][3];
		
		cube[2][1] = cube0_1;
		cube[2][3] = cube0_3;
		System.out.println("Ri ");
		
	}
	static void turn_Li(int cube[][]){
		turn_CC(cube, 1);
		int cube0_1 = cube[0][1];
		int cube0_2	= cube[0][2];
		
		cube[0][0] = cube[2][0];
		cube[0][2] = cube[2][2];
		
		cube[2][0] = cube[5][0];
		cube[2][2] = cube[5][2];
		
		cube[5][0] = cube[4][1];
		cube[5][2] = cube[4][3];
		
		cube[4][1] = cube0_1;
		cube[4][3] = cube0_2;
		System.out.println("Li ");
	}
	static void turn_Di(int cube[][]){
		turn_CC(cube, 5);
		int cube2_2 = cube[2][2];
		int cube2_3 = cube[2][3];
		
		cube[2][2] = cube[3][2];
		cube[2][3] = cube[3][3];
		
		cube[3][2] = cube[4][2];
		cube[3][3] = cube[4][3];
		
		cube[4][2] = cube[1][2];
		cube[4][3] = cube[1][3];
		
		cube[1][2] = cube2_2;
		cube[1][3] = cube2_3;
		System.out.println("Di");
	}
	static void turn_Bi(int cube[][]){
		turn_CC(cube,4);
		int cube0_0 = cube[0][0];
		int cube0_1 = cube[0][1];
		
		cube[0][0] = cube[1][0];
		cube[0][1] = cube[1][2];
		
		cube[1][0] = cube[5][2];
		cube[1][2] = cube[5][3];
		
		cube[5][2] = cube[3][3];
		cube[5][3] = cube[3][1];
		
		cube[3][3] = cube0_1;
		cube[3][1] = cube0_0;
		System.out.println("Bi ");
	}
	static void turn_U2(int cube[][]){
		turn_C2(cube,0);
		int cube2_0 = cube[2][0];
		int cube2_1 = cube[2][1];
		
		int cube1_0	= cube[1][0];
		int cube1_1 = cube[1][1];
		
		cube[2][0] = cube[4][0];
		cube[2][1] = cube[4][1];
		
		cube[1][0] = cube[3][0];
		cube[1][1] = cube[3][1];
		
		cube[3][0] = cube1_0;
		cube[3][1] = cube1_1;
		
		cube[4][0] = cube2_0;
		cube[4][1] = cube2_1;
		System.out.println("U2 ");	
	}
	static void turn_R2(int cube[][]){
		turn_C2(cube,3);
		int cube0_1 = cube[0][1];
		int cube0_3 = cube[0][3];
		int cube2_1 = cube[2][1];
		int cube2_3 = cube[2][3];
		
		cube[0][1] = cube[5][1];
		cube[0][3] = cube[5][3];
		
		cube[2][1] = cube[4][2];
		cube[2][3] = cube[4][0];
		
		cube[4][2] = cube2_1;
		cube[4][0] = cube2_3;
		
		cube[5][3] = cube0_3;
		cube[5][1] = cube0_1;
		System.out.println("R2 ");	
	}
	static void turn_F2(int cube[][]){
		turn_C2(cube,2);
		int cube0_2 = cube[0][2];
		int cube0_3 = cube[0][3];
		int cube1_1 = cube[1][1];
		int cube1_3 = cube[1][3];
		
		cube[0][2] = cube[5][1];
		cube[0][3] = cube[5][0];
		
		cube[1][1] = cube[3][2];
		cube[1][3] = cube[3][0];
		
		cube[3][2] = cube1_1;
		cube[3][0] = cube1_3;
		
		cube[5][1] = cube0_2;
		cube[5][0] = cube0_3;
		System.out.println("F2 ");
	}
	
	static void print_cube(int[][] cube) {
		print_sides(cube, 0, 1);
		print_sides(cube, 1, 4);
		print_sides(cube, 5, 1);
	} 
	public static void main(String[] args){
		int cube[][] = {
			{0,0,0,0}, 
			{1,1,1,1},
			{2,2,2,2},
			{3,3,3,3},
			{4,4,4,4},
			{5,5,5,5},
			};
		
		//turn_L(cube);
		turn_F(cube);
		//turn_U(cube);
		//turn_R(cube);
		//turn_B(cube);
		//turn_Ri(cube);
		//turn_Bi(cube);
		//turn_Ui(cube);
		turn_R(cube);
		turn_U2(cube);
		print_cube(cube);
		
		// random comment
	}
}

