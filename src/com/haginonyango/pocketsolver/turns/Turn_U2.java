package com.haginonyango.pocketsolver.turns;

import com.haginonyango.pocketsolver.*;

public class Turn_U2 implements Rotation{

    public StoreState apply(StoreState state) {
    	RotationUtils.turn_180(state,0);
		int cube2_0 = StoreState.cube[2][0];
		int cube2_1 = StoreState.cube[2][1];
		int cube1_0	= StoreState.cube[1][0];
		int cube1_1 = StoreState.cube[1][1];
		StoreState.cube[2][0] = StoreState.cube[4][0];
		StoreState.cube[2][1] = StoreState.cube[4][1];
		StoreState.cube[1][0] = StoreState.cube[3][0];
		StoreState.cube[1][1] = StoreState.cube[3][1];
		StoreState.cube[3][0] = cube1_0;
		StoreState.cube[3][1] = cube1_1;	
		StoreState.cube[4][0] = cube2_0;
		StoreState.cube[4][1] = cube2_1;
		System.out.print("U2 ");    

       return state;

     }
}