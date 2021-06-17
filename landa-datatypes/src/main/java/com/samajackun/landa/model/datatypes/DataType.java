package com.samajackun.landa.model.datatypes;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Set;

public interface DataType<T extends Comparable<T>>
{
	public String getName();

	public Map<String, Object> getMetadata();

	public Class<T> getJavaType();

	public T parse(String serialValue)
		throws DataTypeParseException;

	public T parseOrNull(String serialValue);

	public String serialize(T value);

	public DataType<?> getParentDataType();

	public Set<DataType<?>> getChildDataTypes();

	public void serialize(T value, Writer out)
		throws IOException;
}
