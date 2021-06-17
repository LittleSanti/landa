package com.samajackun.landa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List of untyped values.
 *
 * @author Santi
 */
public class Record
{
	private final List<Object> columns=new ArrayList<>();

	public Record(Object[] values)
	{
		super();
		this.columns.addAll(Arrays.asList(values));
	}

	public List<Object> getColumns()
	{
		return this.columns;
	}
}
