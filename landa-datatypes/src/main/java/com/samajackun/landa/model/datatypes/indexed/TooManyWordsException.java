package com.samajackun.landa.model.datatypes.indexed;

public class TooManyWordsException extends IllegalArgumentException
{
	private static final long serialVersionUID=2787974848429320500L;

	public TooManyWordsException()
	{
		super("Too many words. Only 5 allowed.");
	}

}
