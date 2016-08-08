package com.haginonyango.pocketsolver.turns;

import com.haginonyango.pocketsolver.Rotation;
import com.haginonyango.pocketsolver.StoreState;

public class Turn_F2 implements Rotation{

	@Override
	public StoreState apply(StoreState state) {
		RotationUtils.turn_180(state, 2);
		int cube0_2 = StoreState.cube[0][2];
		int cube0_3 = StoreState.cube[0][3];
		int cube1_1 = StoreState.cube[1][1];
		int cube1_3 = StoreState.cube[1][3];
		StoreState.cube[0][2] = StoreState.cube[5][1];
		StoreState.cube[0][3] = StoreState.cube[5][0];
		StoreState.cube[1][1] = StoreState.cube[3][2];
		StoreState.cube[1][3] = StoreState.cube[3][0];
		StoreState.cube[3][2] = cube1_1;
		StoreState.cube[3][0] = cube1_3;
		StoreState.cube[5][1] = cube0_2;
		StoreState.cube[5][0] = cube0_3;
		System.out.print("F2 ");
		return state;
	}

}
