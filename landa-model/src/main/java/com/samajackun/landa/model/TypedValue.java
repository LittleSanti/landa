package com.samajackun.landa.model;

import com.samajackun.landa.model.datatypes.DataType;

public class TypedValue
{
	private final DataType<?> dataType;

	private final Object value;

	public TypedValue(DataType<?> dataType, Object value)
	{
		super();
		this.dataType=dataType;
		this.value=value;
	}

	public DataType<?> getDataType()
	{
		return dataType;
	}

	public Object getValue()
	{
		return value;
	}
}
