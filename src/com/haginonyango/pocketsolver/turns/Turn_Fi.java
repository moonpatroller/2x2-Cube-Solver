package com.haginonyango.pocketsolver.turns;

import com.haginonyango.pocketsolver.Rotation;
import com.haginonyango.pocketsolver.StoreState;


public class Turn_Fi implements Rotation{

	
	public StoreState apply(StoreState state) {
		
		 RotationUtils.turn_CC(state, 2);
		 int cube0_2 = StoreState.cube[0][2];
		 int cube0_3 = StoreState.cube[0][3];
		 StoreState.cube[0][2] = StoreState.cube[3][0];
		 StoreState.cube[0][3] = StoreState.cube[3][2];
		 StoreState.cube[3][0] = StoreState.cube[5][1];
		 StoreState.cube[3][2] = StoreState.cube[5][0];
		 StoreState.cube[5][1] = StoreState.cube[1][3];
		 StoreState.cube[5][0] = StoreState.cube[1][1]; 
		 StoreState.cube[1][3] = cube0_2;
		 StoreState.cube[1][1] = cube0_3;
		 System.out.print("Fi ");
		return state;
	}

}
