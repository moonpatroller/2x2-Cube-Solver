package com.haginonyango.pocketsolver;

public interface Rotation {
	

	public StoreState apply(StoreState state);  
	
	public Rotation add(Rotation turns);
	
	
}