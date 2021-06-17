package com.samajackun.landa.model.datatypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeDataType extends AbstractDataType<Date>
{
	public DateTimeDataType(DataType<?> parentDataType)
	{
		super("datetime", Date.class, parentDataType);
		getMetadata().put("format", "yyyy-MM-dd HH:mm:ss Z");
	}

	@Override
	public Date parseOrNull(String serialValue)
	{
		Date value;
		try
		{
			return new SimpleDateFormat((String)getMetadata().get("format")).parse(serialValue);
		}
		catch (ParseException e)
		{
			value=null;
		}
		return value;
	}

	@Override
	public Date parse(String serialValue)
		throws DataTypeParseException
	{
		try
		{
			return new SimpleDateFormat((String)getMetadata().get("format")).parse(serialValue);
		}
		catch (ParseException e)
		{
			throw new DataTypeParseException(this, serialValue);
		}
	}

	@Override
	public String serialize(Date value)
	{
		return new SimpleDateFormat((String)getMetadata().get("format")).format(value);
	}
}
