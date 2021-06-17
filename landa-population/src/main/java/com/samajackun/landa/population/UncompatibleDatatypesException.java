package com.samajackun.landa.population;

import com.samajackun.landa.LandaException;
import com.samajackun.landa.model.datatypes.DataType;

public class UncompatibleDatatypesException extends LandaException
{
	private static final long serialVersionUID=-2752094287533941002L;

	private final DataType<?> type1;

	private final DataType<?> type2;

	public UncompatibleDatatypesException(DataType<?> type1, DataType<?> type2)
	{
		super();
		this.type1=type1;
		this.type2=type2;
	}

	public DataType<?> getType1()
	{
		return this.type1;
	}

	public DataType<?> getType2()
	{
		return this.type2;
	}

}
