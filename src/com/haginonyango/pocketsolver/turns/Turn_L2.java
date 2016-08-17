package com.haginonyango.pocketsolver.turns;
import com.haginonyango.pocketsolver.*;

public class Turn_L2 implements Rotation{

	public StoreState apply(StoreState state) {
		RotationUtils.turn_180(state, 1);
		int cube0_0 = StoreState.cube[0][0];
		int cube0_2 = StoreState.cube[0][2];
		int cube2_0	= StoreState.cube[2][0];
		int cube2_2	= StoreState.cube[2][2];
		StoreState.cube[0][0] = StoreState.cube[5][0];
		StoreState.cube[0][2] = StoreState.cube[5][2];
		StoreState.cube[2][0] = StoreState.cube[4][3];
		StoreState.cube[2][2] = StoreState.cube[4][1];
		StoreState.cube[5][0] = cube0_0;
		StoreState.cube[5][2] = cube0_2;
		StoreState.cube[4][3] = cube2_0;
		StoreState.cube[4][1] = cube2_2;
		System.out.print("L2 ");
		return state;
		
	}	
}
