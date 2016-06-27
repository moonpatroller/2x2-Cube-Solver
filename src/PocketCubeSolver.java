import java.util.Scanner;

/*
  The goal for this program is to go through all the possible combinations of the 2x2x2 rubiks cube 
  and to give you the solution to the scramble you have on your cube so that you can solve it. :) 
  
  ther are 18 moves that can be applied to the 2x2 cube it has to go through every combination 10 times
  
  there are 
  3674160 different combinations for the 2x2
  32998564
  
  
 */
public class PocketCubeSolver {
	public static int cube[][] = new int [6][4];
	public static int cube1[][] = new int [6][4];
	public static boolean solved = false;
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
		
			  int cube0_1 = cube[side_num][1];
			  int cube0_3 = cube[side_num][3];  
		cube[side_num][1] = cube[side_num][2];
		cube[side_num][3] = cube[side_num][0];
		cube[side_num][2] = cube0_3;
		cube[side_num][0] = cube0_1;

	}
	public static int[][] turn_U(int cube [][]){
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
		System.out.print("U ");
		return cube;
		}
	public  static int[][] turn_Ui(int cube[][]){
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
		 System.out.print("Ui ");
		 return cube;
		 }
	public static int[][] turn_U2(int cube[][]){
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
		System.out.print("U2 ");	
		return cube;
	}
	public static int[][] turn_F(int cube[][]){
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
		System.out.print("F ");
		return cube;
	}
	public static int[][] turn_Fi(int cube[][]){
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
		 System.out.print("Fi ");
		 return cube;
	}
	public static int[][] turn_F2(int cube[][]){
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
		System.out.print("F2 ");
		return cube;
	}
	public static int[][] turn_R(int cube[][]){
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
		 System.out.print("R ");
		 return cube;
	}
	public static int[][] turn_Ri(int cube[][]){
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
		System.out.print("Ri ");	
		return cube;
	}
	public static int[][] turn_R2(int cube[][]){
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
		System.out.print("R2 ");	
		return cube;
	}
	public static int[][] turn_L(int cube[][]){
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
		 System.out.print("L ");
		 return cube;
	}
	public static int[][] turn_Li(int cube[][]){
		turn_CC(cube, 1);
		int cube0_0 = cube[0][0];
		int cube0_2	= cube[0][2];
		
		cube[0][0] = cube[2][0];
		cube[0][2] = cube[2][2];
		
		cube[2][0] = cube[5][0];
		cube[2][2] = cube[5][2];
		
		cube[5][0] = cube[4][3];
		cube[5][2] = cube[4][1];
		
		cube[4][1] = cube0_2;
		cube[4][3] = cube0_0;
		System.out.print("Li ");
		return cube;
	}
	public static int[][] turn_L2(int cube[][]){
		turn_C2(cube,1);
		int cube0_0 = cube[0][0];
		int cube0_2 = cube[0][2];
		int cube2_0	= cube[2][0];
		int cube2_2	= cube[2][2];
		
		cube[0][0] = cube[5][0];
		cube[0][2] = cube[5][2];
		
		cube[2][0] = cube[4][3];
		cube[2][2] = cube[4][1];
		
		cube[5][0] = cube0_0;
		cube[5][2] = cube0_2;
		
		cube[4][3] = cube2_0;
		cube[4][1] = cube2_2;
		System.out.print("L2 ");
		return cube;
	}
	public static int[][] turn_D(int cube[][]){
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
		 System.out.print("D ");
		 return cube;
		 
	}
	public static int[][] turn_Di(int cube[][]){
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
		System.out.print("Di ");
		return cube;
	}
	public static int[][] turn_D2(int cube[][]){
		turn_C2(cube,5);
		int cube2_2 = cube[2][2];
		int cube2_3	= cube[2][3];
		int cube3_2	= cube[3][2];
		int cube3_3	= cube[3][3];
		
		cube[2][2] = cube[4][2];
		cube[2][3] = cube[4][3];
		
		cube[3][2] = cube[1][2];
		cube[3][3] = cube[1][3];
		
		cube[4][2] = cube2_2;
		cube[4][3] = cube2_3;
		
		cube[1][2] = cube3_2;
		cube[1][3] = cube3_3;
		System.out.print("D2 ");
		return cube;
	}
	public static int[][] turn_B(int cube[][]){
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
		 System.out.print("B ");
		 return cube;
	 }
	 
	public static int[][] turn_Bi(int cube[][]){
		turn_CC(cube,4);
		int cube0_0 = cube[0][0];
		int cube0_1 = cube[0][1];
		
		cube[0][0] = cube[1][2];
		cube[0][1] = cube[1][0];
		
		cube[1][2] = cube[5][3];
		cube[1][0] = cube[5][2];
		
		cube[5][3] = cube[3][1];
		cube[5][2] = cube[3][3];
		
		cube[3][1] = cube0_0;
		cube[3][3] = cube0_1;
	
		System.out.print("Bi ");
		return cube;
	}
	public static int[][] turn_B2(int cube[][]){
		turn_C2(cube,4);
		int cube0_0 = cube[0][0];
		int cube0_1 = cube[0][1];
		int cube1_0 = cube[1][0];
		int cube1_2 = cube[1][2];
		
		cube[0][0] = cube[5][3];
		cube[0][1] = cube[5][2];
		
		cube[1][0] = cube[3][3];
		cube[1][2] = cube[3][1];
		
		cube[5][3] = cube0_0;
		cube[5][2] = cube0_1;
		
		cube[3][3] = cube1_0;
		cube[3][1] = cube1_2;
		System.out.print("B2 ");
		return cube;
		
	}
	
	public static int[][] scan_cube()//input is the colors that we get and will be returned as is
	{
		int input[][] = new int[6][4];
		//initate the counter 
		int counter0 = 0;
		int counter1 = 0;
		
		Scanner in = new Scanner(System.in);
		//Collect the data
			System.out.println("Hold the cube in a position that you will remember "
					+ "and won't change because the 2x2 has no centers.\nRemembering "
					+ "block colors would be helpful\nE.I: RED 1x1x2 block on top of blue piece\n \n");
			
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the TOP side\n");
			while(counter0 < 4){
				
				counter1 = 0;
				input[0][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the LEFT side");
			
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[1][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the FRONT side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[2][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the RIGHT side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[3][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the BACK SIDE");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[4][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
			
			//get colors for the red side
			System.out.println("NOTE: Rotate cube back to starting position before rotating the cube\n"
					+ "for the bottom side input\n");
			
			System.out.println(" 0 = white \n 1 = orange \n 2 = green \n 3 = red\n 4 = blue\n 5 = yellow\n");
			System.out.println("Enter the colors for the BOTTOM side");
			//reset the counter
			counter0 = 0;
			while(counter0 < 4){
				counter1 = 0;
				input[5][counter0] = Integer.parseInt(in.nextLine());
				counter0++;
			}
		return input;
	}
	
	public static boolean test(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j){
		boolean result1 = true;
		 
		if(a == 1){
			cube = turn_U(cube);
		}
		else if(a == 2){
			cube = turn_Ui(cube);
		}
		else if(a == 3){
			cube = turn_U2(cube);
		}
		else if(a == 4){
			cube = turn_F(cube);
		}
		else if(a == 5){
			cube = turn_Fi(cube);
		}
		else if(a == 6){
			cube = turn_F2(cube);
		}
		else if(a == 7){
			cube = turn_R(cube);
		}
		else if(a == 8){
			cube = turn_Ri(cube);
		}
		else if(a == 9){
			cube = turn_R2(cube);
		}
		else if(a == 10){
			cube = turn_L(cube);
		}
		else if(a == 11){
			cube = turn_Li(cube);
		}
		else if(a == 12){
			cube = turn_L2(cube);
		}
		else if(a == 13){
			cube = turn_D(cube);
		}
		else if(a == 14){
			cube = turn_Di(cube);
		}
		else if(a == 15){
			cube = turn_D2(cube);
		}
		else if(a == 16){
			cube = turn_B(cube);
		}
		else if(a == 17){
			cube = turn_Bi(cube);
		}
		else if(a == 18){
			cube = turn_B2(cube);
		}
		// b
		if(b == 1){
			cube = turn_U(cube);
		}
		else if(b == 2){
			cube = turn_Ui(cube);
		}
		else if(b == 3){
			cube = turn_U2(cube);
		}
		else if(b == 4){
			cube = turn_F(cube);
		}
		else if(b == 5){
			cube = turn_Fi(cube);
		}
		else if(b == 6){
			cube = turn_F2(cube);
		}
		else if(b == 7){
			cube = turn_R(cube);
		}
		else if(b == 8){
			cube = turn_Ri(cube);
		}
		else if(b == 9){
			cube = turn_R2(cube);
		}
		else if(b == 10){
			cube = turn_L(cube);
		}
		else if(b == 11){
			cube = turn_Li(cube);
		}
		else if(b == 12){
			 cube = turn_L2(cube);
		}
		else if(b == 13){
			cube = turn_D(cube);
		}
		else if(b == 14){
			cube = turn_Di(cube);
		}
		else if(b == 15){
			cube = turn_D2(cube);
		}
		else if(b == 16){
			cube = turn_B(cube);
		}
		else if(b == 17){
			cube = turn_Bi(cube);
		}
		else if(b == 18){
			cube = turn_B2(cube);
		}
		if(c == 1){
			cube = turn_U(cube);
		}
		else if(c == 2){
			cube = turn_Ui(cube);
		}
		else if(c == 3){
			cube = turn_U2(cube);
		}
		else if(c == 4){
			cube = turn_F(cube);
		}
		else if(c == 5){
			cube = turn_Fi(cube);
		}
		else if(c == 6){
			cube = turn_F2(cube);
		}
		else if(c == 7){
			cube = turn_R(cube);
		}
		else if(c == 8){
			cube = turn_Ri(cube);
		}
		else if(c == 9){
			cube = turn_R2(cube);
		}
		else if(c == 10){
			cube = turn_L(cube);
		}
		else if(c == 11){
			cube = turn_Li(cube);
		}
		else if(c == 12){
			cube = turn_L2(cube);
		}
		else if(c == 13){
			cube = turn_D(cube);
		}
		else if(c == 14){
			cube = turn_Di(cube);
		}
		else if(c == 15){
			cube = turn_D2(cube);
		}
		else if(c == 16){
			cube = turn_B(cube);
		}
		else if(c == 17){
			cube = turn_Bi(cube);
		}
		else if(c == 18){
			cube = turn_B2(cube);
		}	
		
		if(d == 1){
			cube = turn_U(cube);
		}
		else if(d == 2){
			cube = turn_Ui(cube);
		}
		else if(d == 3){
			cube = turn_U2(cube);
		}
		else if(d == 4){
			cube = turn_F(cube);
		}
		else if(d == 5){
			cube = turn_Fi(cube);
		}
		else if(d == 6){
			cube = turn_F2(cube);
		}
		else if(d == 7){
			cube = turn_R(cube);
		}
		else if(d == 8){
			cube = turn_Ri(cube);
		}
		else if(d == 9){
			cube = turn_R2(cube);
		}
		else if(d == 10){
			cube = turn_L(cube);
		}
		else if(d == 11){
			cube = turn_Li(cube);
		}
		else if(d == 12){
			cube = turn_L2(cube);
		}
		else if(d == 13){
			cube = turn_D(cube);
		}
		else if(d == 14){
			cube = turn_Di(cube);
		}
		else if(d == 15){
			cube = turn_D2(cube);
		}
		else if(d == 16){
			cube = turn_B(cube);
		}
		else if(d == 17){
			cube = turn_Bi(cube);
		}
		else if(d == 18){
			cube = turn_B2(cube);
		}
		
		if(e == 1){
			cube = turn_U(cube);
		}
		else if(e == 2){
			cube = turn_Ui(cube);
		}
		else if(e == 3){
			cube = turn_U2(cube);
		}
		else if(e == 4){
			cube = turn_F(cube);
		}
		else if(e == 5){
			cube = turn_Fi(cube);
		}
		else if(e == 6){
			cube = turn_F2(cube);
		}
		else if(e == 7){
			cube = turn_R(cube);
		}
		else if(e == 8){
			cube = turn_Ri(cube);
		}
		else if(e == 9){
			cube = turn_R2(cube);
		}
		else if(e == 10){
			cube = turn_L(cube);
		}
		else if(e == 11){
			cube = turn_Li(cube);
		}
		else if(e == 12){
			cube = turn_L2(cube);
		}
		else if(e == 13){
			cube = turn_D(cube);
		}
		else if(e == 14){
			cube = turn_Di(cube);
		}
		else if(e == 15){
			cube = turn_D2(cube);
		}
		else if(e == 16){
			cube = turn_B(cube);
		}
		else if(e == 17){
			cube = turn_Bi(cube);
		}
		else if(e == 18){
			cube = turn_B2(cube);
		}
		
		if(f == 1){
			cube = turn_U(cube);
		}
		else if(f == 2){
			cube = turn_Ui(cube);
		}
		else if(f == 3){
			cube = turn_U2(cube);
		}
		else if(f == 4){
			cube = turn_F(cube);
		}
		else if(f == 5){
			cube = turn_Fi(cube);
		}
		else if(f == 6){
			cube = turn_F2(cube);
		}
		else if(f == 7){
			cube = turn_R(cube);
		}
		else if(f == 8){
			cube = turn_Ri(cube);
		}
		else if(f == 9){
			cube = turn_R2(cube);
		}
		else if(f == 10){
			cube = turn_L(cube);
		}
		else if(f == 11){
			cube = turn_Li(cube);
		}
		else if(f == 12){
			cube = turn_L2(cube);
		}
		else if(f == 13){
			cube = turn_D(cube);
		}
		else if(f == 14){
			cube = turn_Di(cube);
		}
		else if(f == 15){
			cube = turn_D2(cube);
		}
		else if(f == 16){
			cube = turn_B(cube);
		}
		else if(f == 17){
			cube = turn_Bi(cube);
		}
		else if(f == 18){
			cube = turn_B2(cube);
		}
		
		if(g == 1){
			cube = turn_U(cube);
		}
		else if(g == 2){
			cube = turn_Ui(cube);
		}
		else if(g == 3){
			cube = turn_U2(cube);
		}
		else if(g == 4){
			cube = turn_F(cube);
		}
		else if(g == 5){
			cube = turn_Fi(cube);
		}
		else if(g == 6){
			cube = turn_F2(cube);
		}
		else if(g == 7){
			cube = turn_R(cube);
		}
		else if(g == 8){
			cube = turn_Ri(cube);
		}
		else if(g == 9){
			cube = turn_R2(cube);
		}
		else if(g == 10){
			cube = turn_L(cube);
		}
		else if(g == 11){
			cube = turn_Li(cube);
		}
		else if(g == 12){
			cube = turn_L2(cube);
		}
		else if(g == 13){
			cube = turn_D(cube);
		}
		else if(g == 14){
			cube = turn_Di(cube);
		}
		else if(g == 15){
			cube = turn_D2(cube);
		}
		else if(g == 16){
			cube = turn_B(cube);
		}
		else if(g == 17){
			cube = turn_Bi(cube);
		}
		else if(g == 18){
			cube = turn_B2(cube);
		}

		if(h == 1){
			cube = turn_U(cube);
		}
		else if(h == 2){
			cube = turn_Ui(cube);
		}
		else if(h == 3){
			cube = turn_U2(cube);
		}
		else if(h == 4){
			cube = turn_F(cube);
		}
		else if(h == 5){
			cube = turn_Fi(cube);
		}
		else if(h == 6){
			cube = turn_F2(cube);
		}
		else if(h == 7){
			cube = turn_R(cube);
		}
		else if(h == 8){
			cube = turn_Ri(cube);
		}
		else if(h == 9){
			cube = turn_R2(cube);
		}
		else if(h == 10){
			cube = turn_L(cube);
		}
		else if(h == 11){
			cube = turn_Li(cube);
		}
		else if(h == 12){
			cube = turn_L2(cube);
		}
		else if(h == 13){
			cube = turn_D(cube);
		}
		else if(h == 14){
			cube = turn_Di(cube);
		}
		else if(h == 15){
			cube = turn_D2(cube);
		}
		else if(h == 16){
			cube = turn_B(cube);
		}
		else if(h == 17){
			cube = turn_Bi(cube);
		}
		else if(h == 18){
			cube = turn_B2(cube);
		}
		
		if(i == 1){
			cube = turn_U(cube);
		}
		else if(i == 2){
			cube = turn_Ui(cube);
		}
		else if(i == 3){
			cube = turn_U2(cube);
		}
		else if(i == 4){
			cube = turn_F(cube);
		}
		else if(i == 5){
			cube = turn_Fi(cube);
		}
		else if(i == 6){
			cube = turn_F2(cube);
		}
		else if(i == 7){
			cube = turn_R(cube);
		}
		else if(i == 8){
			cube = turn_Ri(cube);
		}
		else if(i == 9){
			cube = turn_R2(cube);
		}
		else if(i == 10){
			cube = turn_L(cube);
		}
		else if(i == 11){
			cube = turn_Li(cube);
		}
		else if(i == 12){
			cube = turn_L2(cube);
		}
		else if(i == 13){
			cube = turn_D(cube);
		}
		else if(i == 14){
			cube = turn_Di(cube);
		}
		else if(i == 15){
			cube = turn_D2(cube);
		}
		else if(i == 16){
			cube = turn_B(cube);
		}
		else if(i == 17){
			cube = turn_Bi(cube);
		}
		else if(i == 18){
			cube = turn_B2(cube);
		}
	
		if(j == 1){
			cube = turn_U(cube);
		}
		else if(j == 2){
			cube = turn_Ui(cube);
		}
		else if(j == 3){
			cube = turn_U2(cube);
		}
		else if(j == 4){
			cube = turn_F(cube);
		}
		else if(j == 5){
			cube = turn_Fi(cube);
		}
		else if(j == 6){
			cube = turn_F2(cube);
		}
		else if(j == 7){
			cube = turn_R(cube);
		}
		else if(j == 8){
			cube = turn_Ri(cube);
		}
		else if(j == 9){
			cube = turn_R2(cube);
		}
		else if(j == 10){
			cube = turn_L(cube);
		}
		else if(j == 11){
			cube = turn_Li(cube);
		}
		else if(j == 12){
			cube = turn_L2(cube);
		}
		else if(j == 13){
			cube = turn_D(cube);
		}
		else if(j == 14){
			cube = turn_Di(cube);
		}
		else if(j == 15){
			cube = turn_D2(cube);
		}
		else if(j == 16){
			cube = turn_B(cube);
		}
		else if(j == 17){
			cube = turn_Bi(cube);
		}
		else if(j == 18){
			cube = turn_B2(cube);
		}
		
		//check to see if cube is solved
		for(int x = 0; x < 4; x++){
			if(cube[0][x] != 0){
				result1 = false;
			}
		}
		for(int x = 0; x < 4; x++){
			if(cube[1][x] != 1){
				result1 = false;
			}
		}
		for(int x = 0; x < 4; x++){
			if(cube[2][x] != 2){
				result1 = false;
			}
		}
		for(int x = 0; x < 4; x++){
			if(cube[3][x] != 3){
				result1 = false;
			}
		}
		for(int x = 0; x < 4; x++){
			if(cube[4][x] != 4){
				result1 = false;
			}
		}
		for(int x = 0; x < 4; x++){
			if(cube[5][x] != 5){
				result1 = false;
			}
		}
		return result1;
	}
	public static void resetColors(){
		for(int x = 0; x < 4; x++){
			cube[0][x] = cube1[0][x];
		}
		for(int x = 0; x < 4; x++){
			cube[1][x] = cube1[1][x];
		}
		for(int x = 0; x < 4; x++){
			cube[2][x] = cube1[2][x];
		}
		
		for(int x = 0; x < 4; x++){
			cube[3][x] = cube1[3][x];
		}
		for(int x = 0; x < 4; x++){
			cube[4][x] = cube1[4][x];
		}
		for(int x = 0; x < 4; x++){
			cube[5][x] = cube1[5][x];
		}
	
	}
		
	
	
	static void print_cube(int[][] cube) {
		print_sides(cube, 0, 1);
		print_sides(cube, 1, 4);
		print_sides(cube, 5, 1);
	} 
	public static void main(String[] args){
	
		
		System.out.println();
		
		int counter = 0;
		
		cube = scan_cube();
		System.out.println("confirm that this is your scramble :) \n"
				+ "if its not please run program again and retry sorry :/ /n");
		print_cube(cube);
		
		//setting cube1 to main cubes' colors for testing solution
		for(int x = 0; x < 4; x++){
			cube1[0][x] = cube[0][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[1][x] = cube[1][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[2][x] = cube[2][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[3][x] = cube[3][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[4][x] = cube[4][x];
		}
		for(int x = 0; x < 4; x++){
			cube1[5][x] = cube[5][x];
		}
		//18 ways i can turn the cube 
		for(int a = 0; a < 18; a++){
			for(int b = 0; b < 18; b++){
				for(int c = 0; c < 18;c++ ){
					for(int d = 0; d < 18; d++){
						for(int e = 0; e < 18; e++){
							for(int f = 0; f < 18; f++){
								for(int g = 0; g < 18; g++){
									for(int h = 0; h < 18; h++){
										for(int i = 0; i < 18; i++){
											for(int j = 0; j < 18; j++){
										
										System.out.println("Testing combintaion:"+ counter);
										solved = test(a,b,c,d,e,f,g,h,i,j);
										
										if(solved){
											
											System.out.println("HOW TO DECODE YOUR SCRAMBLE: \n"
													+ "0 == no turn\n"
													+ "U = 1\n"
													+ "Ui = 2\n"
													+ "U2 = 3\n"
													+ "F = 4\n"
													+ "Fi = 5\n"
													+ "F2 = 6\n"
													+ "R = 7\n"
													+ "Ri = 8\n"
													+ "R2 = 9\n"
													+ "L = 10\n"
													+ "Li = 11\n"
													+ "L2 = 12\n"
													+ "D = 13\n"
													+ "Di = 14\n"
													+ "D2 = 15\n"
													+ "B = 16\n"
													+ "Bi = 17\n"
													+ "B = 18\n");
											System.out.println("\n"+a+"\n"+
													b+"\n"+c+"\n"+
													d+"\n"+e+"\n"+
													f+"\n"+g+"\n"+
													h+"\n"+i+"\n"+j+"\n");
											System.out.println("SOLVED!! :) ");
											
											
										}
										/*
										System.out.println("AFTER");
										for(int x = 0; x < 4; x++){
											System.out.println(cube[0][x]);
										}
										for(int x = 0; x < 4; x++){
											System.out.println(cube[1][x]);
										}
										for(int x = 0; x < 4; x++){
											System.out.println(cube[2][x]);
										}
										for(int x = 0; x < 4; x++){
											System.out.println(cube[3][x]);
										}
										for(int x = 0; x < 4; x++){
											System.out.println(cube[4][x]);
										}
										for(int x = 0; x < 4; x++){
											System.out.println(cube[5][x]);
										}*/
										resetColors();
										
										counter++;
											if(solved){
												break;
												}
											}
										if(solved){
											break;
											}
										}
									if(solved){
										break;
										}
									}
								if(solved){
									break;
									}	
								}
							if(solved){
								break;
								}	
							}
						if(solved){
							break;
							}	
						}
					if(solved){
						break;
						}	
					}
				if(solved){
					break;
					}	
				}
		if(solved){
			break;
			}	
			}
	if(solved){
		break;
		}	
	}
		
}	
	
}


