package com.samajackun.landa.engine;

import com.samajackun.landa.LandaException;

public class TransactionException extends LandaException
{
	private static final long serialVersionUID=-6614586042708954362L;

	public TransactionException()
	{
	}

	public TransactionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransactionException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public TransactionException(String message)
	{
		super(message);
	}

	public TransactionException(Throwable cause)
	{
		super(cause);
	}
}
