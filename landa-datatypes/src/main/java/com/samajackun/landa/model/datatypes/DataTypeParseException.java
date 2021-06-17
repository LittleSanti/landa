package com.samajackun.landa.model.datatypes;

public class DataTypeParseException extends Exception
{
	private static final long serialVersionUID=8713609361280376185L;

	private final DataType<?> dataType;

	private final String serialValue;

	public DataTypeParseException(DataType<?> dataType, String serialValue)
	{
		super("Unable to parse to " + dataType.getName() + " serial value '" + serialValue + "'");
		this.dataType=dataType;
		this.serialValue=serialValue;
	}

	public DataType<?> getDataType()
	{
		return dataType;
	}

	public String getSerialValue()
	{
		return serialValue;
	}
}
