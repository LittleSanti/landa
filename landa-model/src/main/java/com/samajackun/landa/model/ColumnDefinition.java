package com.samajackun.landa.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.samajackun.landa.model.datatypes.DataType;
import com.samajackun.landa.model.datatypes.DataTypeManager;
import com.samajackun.landa.util.DistributionMap;

public class ColumnDefinition
{
	private final String name;

	private DistributionMap<DataType<?>> dataTypesDistribution;

	private final Map<String, Object> metadata=new HashMap<>();

	private Object defaultValue;

	public ColumnDefinition(String name, DataType<?> dataType)
	{
		super();
		this.name=name;
	}

	public String getName()
	{
		return this.name;
	}

	public DistributionMap<DataType<?>> getDataTypesDistribution()
	{
		return this.dataTypesDistribution;
	}

	public void setDataTypesDistribution(DistributionMap<DataType<?>> dataTypesDistribution)
	{
		this.dataTypesDistribution=dataTypesDistribution;
	}

	public Map<String, Object> getMetadata()
	{
		return this.metadata;
	}

	public Object getDefaultValue()
	{
		return this.defaultValue;
	}

	public void setDefaultValue(Object defaultValue)
	{
		this.defaultValue=defaultValue;
	}

	@Override
	public String toString()
	{
		return "ColumnDefinition [name=" + this.name + ", dataTypesDistribution=" + this.dataTypesDistribution + ", metadata=" + this.metadata + "]";
	}

	public DataType<?> getPreferredDataType(DataTypeManager dataTypeManager)
	{
		DataType<?> dataType;
		if (this.dataTypesDistribution.isEmpty())
		{
			dataType=dataTypeManager.getDefaultDataType();
		}
		else
		{
			Set<DataType<?>> dataTypes=this.dataTypesDistribution.getFrequenciesMapInDescendingOrder().get(this.dataTypesDistribution.getFrequenciesMapInDescendingOrder().firstKey());
			if (dataTypes.isEmpty())
			{
				dataType=dataTypeManager.getDefaultDataType();
			}
			else
			{
				dataType=dataTypes.iterator().next();
			}
		}
		return dataType;
	}
}
