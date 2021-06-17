package com.samajackun.landa.population;

import com.samajackun.landa.LandaException;

public class ValueNotParseableException extends LandaException
{
	private static final long serialVersionUID=7550487645552943500L;

	private String serialValue;

	public ValueNotParseableException(String serialValue)
	{
		super("Value '" + serialValue + "' not parseable with any registered datatype");
	}

	public String getSerialValue()
	{
		return this.serialValue;
	}
}
