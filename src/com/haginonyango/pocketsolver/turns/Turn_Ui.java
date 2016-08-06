package com.haginonyango.pocketsolver.turns;
import com.haginonyango.pocketsolver.*;


public class Turn_Ui implements Rotation{

	@Override
	public StoreState apply(StoreState state) {
	
		RotationUtils.turn_CC(state, 0);
	   	 int cube2_0 = StoreState.cube[2][0];
		 int cube2_1 = StoreState.cube[2][1];	 
		 StoreState.cube[2][0] = StoreState.cube[1][0];
		 StoreState.cube[2][1] = StoreState.cube[1][1];
		 StoreState.cube[1][0] = StoreState.cube[4][0];
		 StoreState.cube[1][1] = StoreState.cube[4][1];
		 StoreState.cube[4][0] = StoreState.cube[3][0];
		 StoreState.cube[4][1] = StoreState.cube[3][1];
		 StoreState.cube[3][0] = cube2_0;
		 StoreState.cube[3][1] = cube2_1;
		 System.out.print("Ui ");
		return state;
	}

	

}
