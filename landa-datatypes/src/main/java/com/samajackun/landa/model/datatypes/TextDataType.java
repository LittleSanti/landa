package com.samajackun.landa.model.datatypes;

public class TextDataType extends AbstractDataType<String>
{
	public TextDataType(DataType<?> parentDataType)
	{
		super("text", String.class, parentDataType);
	}

	@Override
	public String parseOrNull(String serialValue)
	{
		return serialValue;
	}

	@Override
	public String parse(java.lang.String serialValue)
		throws DataTypeParseException
	{
		return serialValue;
	}

	@Override
	public java.lang.String serialize(String value)
	{
		return value;
	}
}
