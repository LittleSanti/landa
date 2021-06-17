package com.samajackun.landa.model.datatypes;

import java.util.Set;

public class BooleanDataType extends AbstractDataType<Boolean>
{
	public BooleanDataType(DataType<?> parentDataType)
	{
		super("boolean", Boolean.class, parentDataType);
	}

	@Override
	public Boolean parseOrNull(String serialValue)
	{
		return parse(serialValue);
	}

	@Override
	public Boolean parse(String serialValue)
	{
		@SuppressWarnings("unchecked")
		Set<String> falseLiterals=(Set<String>)getMetadata().get("false-literals");
		boolean x;
		switch (serialValue.toLowerCase())
		{
			case "0":
			case "false":
			case "":
				x=false;
				break;
			default:
				x=!(falseLiterals != null && falseLiterals.contains(serialValue.toLowerCase()));
				break;
		}
		return x;
	}

	@Override
	public String serialize(Boolean value)
	{
		return value.toString();
	}
}
