package com.samajackun.landa.model.datatypes;

public final class DefaultDataTypeManager extends DataTypeManager
{
	public static final TextDataType TEXT_DATATYPE=new TextDataType(null);

	public static final BooleanDataType BOOLEAN_DATATYPE=new BooleanDataType(TEXT_DATATYPE);

	public static final DateTimeDataType DATETIME_DATATYPE=new DateTimeDataType(TEXT_DATATYPE);

	public static final DateDataType DATE_DATATYPE=new DateDataType(DATETIME_DATATYPE);

	public static final DecimalDataType DECIMAL_DATATYPE=new DecimalDataType(TEXT_DATATYPE);

	public static final IntegerDataType INTEGER_DATATYPE=new IntegerDataType(DECIMAL_DATATYPE);

	private static final DefaultDataTypeManager INSTANCE=new DefaultDataTypeManager();

	public static DefaultDataTypeManager getInstance()
	{
		return INSTANCE;
	}

	private DefaultDataTypeManager()
	{
		super(TEXT_DATATYPE);
	}
}
