package com.samajackun.landa.model;

import com.samajackun.landa.LandaException;

import lombok.Getter;

@Getter
public class TableNotFoundException extends LandaException
{
	private static final long serialVersionUID=242490051166382010L;

	private final String schemaName;

	private final String tableName;

	public TableNotFoundException(String schemaName, String tableName)
	{
		super();
		this.schemaName=schemaName;
		this.tableName=tableName;
	}

}
