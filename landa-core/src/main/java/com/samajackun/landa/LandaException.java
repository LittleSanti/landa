package com.samajackun.landa;

public class LandaException extends Exception
{
	private static final long serialVersionUID=-1187820665519032284L;

	public LandaException()
	{
		super();
	}

	public LandaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LandaException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LandaException(String message)
	{
		super(message);
	}

	public LandaException(Throwable cause)
	{
		super(cause);
	}
}
