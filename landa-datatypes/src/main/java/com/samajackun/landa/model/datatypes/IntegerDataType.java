package com.samajackun.landa.model.datatypes;

public class IntegerDataType extends AbstractDataType<Long>
{
	public IntegerDataType(DataType<?> parentDataType)
	{
		super("integer", Long.class, parentDataType);
	}

	@Override
	public Long parseOrNull(String serialValue)
	{
		Long value;
		try
		{
			value=Long.valueOf(serialValue);
		}
		catch (NumberFormatException e)
		{
			value=null;
		}
		return value;
	}

	@Override
	public Long parse(String serialValue)
		throws DataTypeParseException
	{
		try
		{
			return Long.valueOf(serialValue);
		}
		catch (NumberFormatException e)
		{
			throw new DataTypeParseException(this, serialValue);
		}
	}

	@Override
	public String serialize(Long value)
	{
		return value.toString();
	}
}
