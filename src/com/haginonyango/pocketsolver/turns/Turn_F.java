package com.haginonyango.pocketsolver.turns;

import com.haginonyango.pocketsolver.*;


public class Turn_F implements Rotation{

	
	public StoreState apply(StoreState state) {

		 RotationUtils.turn_CW(state, 2);
		 int cube0_2 = StoreState.cube[0][2];
		 int cube0_3 = StoreState.cube[0][3];
		 StoreState.cube[0][2] = StoreState.cube[1][3];
		 StoreState.cube[0][3] = StoreState.cube[1][1];
		 StoreState.cube[1][1] = StoreState.cube[5][0];
		 StoreState.cube[1][3] = StoreState.cube[5][1];
		 StoreState.cube[5][0] = StoreState.cube[3][2];
		 StoreState.cube[5][1] = StoreState.cube[3][0]; 
		 StoreState.cube[3][2] = cube0_3;
		 StoreState.cube[3][0] = cube0_2;	 
		 System.out.print("F ");
		return state;
	}
	

}