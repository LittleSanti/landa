package com.samajackun.landa.model.datatypes;

public class DecimalDataType extends AbstractDataType<Double>
{
	public DecimalDataType(DataType<?> parentDataType)
	{
		super("decimal", Double.class, parentDataType);
	}

	@Override
	public Double parseOrNull(String serialValue)
	{
		Double value;
		try
		{
			value=Double.valueOf(serialValue);
		}
		catch (NumberFormatException e)
		{
			value=null;
		}
		return value;
	}

	@Override
	public Double parse(String serialValue)
		throws DataTypeParseException
	{
		try
		{
			return Double.valueOf(serialValue);
		}
		catch (NumberFormatException e)
		{
			throw new DataTypeParseException(this, serialValue);
		}
	}

	@Override
	public String serialize(Double value)
	{
		return value.toString();
	}
}
