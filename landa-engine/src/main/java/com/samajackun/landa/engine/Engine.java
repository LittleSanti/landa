package com.samajackun.landa.engine;

public interface Engine
{
	public Transaction createTransaction()
		throws EngineException;

}
