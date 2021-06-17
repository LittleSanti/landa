package com.samajackun.landa.model.datatypes;

import com.samajackun.landa.model.datatypes.indexed.IndexedText;

public class IndexedTextDataType extends AbstractDataType<IndexedText>
{
	protected IndexedTextDataType(DataType<?> parentDataType)
	{
		super("indexedtext", IndexedText.class, parentDataType);
	}

	@Override
	public IndexedText parse(String serialValue)
		throws DataTypeParseException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IndexedText parseOrNull(String serialValue)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String serialize(IndexedText value)
	{
		return value.toString();
	}

}
