package com.samajackun.landa.model;

import java.util.HashMap;
import java.util.Map;

import com.samajackun.landa.model.datatypes.DataType;

public class RecordDefinition
{
	private final Map<String, ColumnDefinition> columnDefinitions=new HashMap<>();

	public Map<String, ColumnDefinition> getColumnDefinitions()
	{
		return this.columnDefinitions;
	}

	private final Map<Integer, String> columnNamesMap=new HashMap<>();

	public Map<Integer, String> getColumnNamesMap()
	{
		return this.columnNamesMap;
	}

	public void add(String columnName, DataType<?> dataType)
	{
		ColumnDefinition columnDefinition=new ColumnDefinition(columnName, dataType);
		synchronized (this)
		{
			this.columnDefinitions.put(columnName, columnDefinition);
			this.columnNamesMap.put(this.columnDefinitions.size() - 1, columnName);
		}
	}

	public ColumnDefinition getColumnDefinition(int index)
	{
		return this.columnDefinitions.get(this.columnNamesMap.get(index));
	}

}
