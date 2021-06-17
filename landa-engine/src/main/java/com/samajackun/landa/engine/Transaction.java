package com.samajackun.landa.engine;

public interface Transaction
{
	public Object[] getRow(String schema, String table, long rowId)
		throws TransactionException;

	public void setRow(String schema, String table, long rowId, Object[] values)
		throws TransactionException;

	public long createRow(String schema, String table)
		throws TransactionException;

	public void deleteRow(String schema, String table, long rowId)
		throws TransactionException;
}
