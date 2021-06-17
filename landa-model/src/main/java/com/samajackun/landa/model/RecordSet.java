package com.samajackun.landa.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Alignation of a table of records with the definition of record columns.
 *
 * @author Santi
 */
public class RecordSet
{
	private final RecordDefinition definition=new RecordDefinition();

	private final List<Record> records=new ArrayList<>();

	public List<Record> getRecords()
	{
		return this.records;
	}

	public RecordDefinition getDefinition()
	{
		return this.definition;
	}

	public long addRow(Object[] values)
	{
		this.records.add(new Record(values));
		return this.records.size();
	}

	public Record getRow(long num)
	{
		throw new UnsupportedOperationException();
	}

}
