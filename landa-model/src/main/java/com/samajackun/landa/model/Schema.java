package com.samajackun.landa.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Set of recordsets.
 *
 * @author Santi
 */
public class Schema
{
	private final String name;

	private final Map<String, RecordSet> tables=new HashMap<>();

	public Schema(String name)
	{
		super();
		this.name=name;
	}

	public Map<String, RecordSet> getTables()
	{
		return this.tables;
	}

	public String getName()
	{
		return this.name;
	}

	public RecordSet getTable(String tableName)
		throws TableNotFoundException
	{
		RecordSet table=this.tables.get(tableName);
		if (table == null)
		{
			throw new TableNotFoundException(this.name, tableName);
		}
		return table;
	}
}
