package com.haginonyango.pocketsolver.turns;
import com.haginonyango.pocketsolver.*;

public class RotationUtils {
	
		public static StoreState turn_CW(StoreState state, int side_num){
			
	        int cube0_0 = StoreState.cube[side_num][0];
	StoreState.cube[side_num][0] = StoreState.cube[side_num][2];
	StoreState.cube[side_num][2] = StoreState.cube[side_num][3];
	StoreState.cube[side_num][3] = StoreState.cube[side_num][1];
	StoreState.cube[side_num][1] = cube0_0;		
	
	return state;
	}
	
	public static StoreState turn_CC(StoreState state, int side_num){
	
	        int cube0_0 = StoreState.cube[side_num][0];
	StoreState.cube[side_num][0] = StoreState.cube[side_num][1];
	StoreState.cube[side_num][1] = StoreState.cube[side_num][3];
	StoreState.cube[side_num][3] = StoreState.cube[side_num][2];
	StoreState.cube[side_num][2] = cube0_0;
	
	return state;
	}
	
	public static StoreState turn_180(StoreState state, int side_num){
	
	    int cube0_1 = StoreState.cube[side_num][1];
	    int cube0_3 = StoreState.cube[side_num][3];  
	StoreState.cube[side_num][1] = StoreState.cube[side_num][2];
	StoreState.cube[side_num][3] =StoreState. cube[side_num][0];
	StoreState.cube[side_num][2] = cube0_1;
	StoreState.cube[side_num][0] = cube0_3;
	
	return state;
	}
	

	
}
	
	/*
	public static void swap(int[] array, int pos1, int pos2){
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
   }
   public static void swap(int[][] array, int face1, int pos1, int face2, int pos2){
        int tmp = array[face1][pos1];
        array[face1][pos1] = array[face2][pos2];
        array[face2][pos2] = tmp;
   }
   public static void InnerFaceRotation(StoreState state, int side_num) {
       int[] face = StoreState.cube[side_num];
       swap(face,1,2);
       swap(face,0,3);
   } 
   
   */

