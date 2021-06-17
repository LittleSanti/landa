package com.samajackun.landa.model.datatypes;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractDataType<T extends Comparable<T>> implements DataType<T>
{
	private final String name;

	private final Map<String, Object> metadata=new HashMap<>();

	private final Class<T> javaType;

	private final DataType<?> parentDataType;

	private final Set<DataType<?>> childDataTypes=new HashSet<>();

	protected AbstractDataType(String name, Class<T> javaType, DataType<?> parentDataType)
	{
		super();
		this.name=name;
		this.javaType=javaType;
		this.parentDataType=parentDataType;
		if (parentDataType != null)
		{
			parentDataType.getChildDataTypes().add(this);
		}
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public Map<String, Object> getMetadata()
	{
		return this.metadata;
	}

	@Override
	public Class<T> getJavaType()
	{
		return this.javaType;
	}

	@Override
	public DataType<?> getParentDataType()
	{
		return this.parentDataType;
	}

	// public void setParentDataType(DataType<?> parentDataType)
	// {
	// this.parentDataType=parentDataType;
	// }

	@Override
	public String toString()
	{
		return "AbstractType [name=" + this.name + ", metadata=" + this.metadata + ", javaType=" + this.javaType + "]";
	}

	@Override
	public Set<DataType<?>> getChildDataTypes()
	{
		return this.childDataTypes;
	}

	@Override
	public void serialize(T value, Writer out)
		throws IOException
	{
		out.write(serialize(value));
	}
}
