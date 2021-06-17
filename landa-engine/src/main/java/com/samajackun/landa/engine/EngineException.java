package com.samajackun.landa.engine;

import com.samajackun.landa.LandaException;

public class EngineException extends LandaException
{
	private static final long serialVersionUID=-9069441975647856269L;

	public EngineException()
	{
		super();
	}

	public EngineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EngineException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public EngineException(String message)
	{
		super(message);
	}

	public EngineException(Throwable cause)
	{
		super(cause);
	}
}
