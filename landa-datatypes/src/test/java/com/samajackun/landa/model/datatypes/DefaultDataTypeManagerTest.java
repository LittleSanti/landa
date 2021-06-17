package com.samajackun.landa.model.datatypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DefaultDataTypeManagerTest
{
	@Test
	public void getDefaultDataType()
	{
		DataTypeManager dataTypeManager=DefaultDataTypeManager.getInstance();
		assertTrue(dataTypeManager.getDefaultDataType() instanceof TextDataType);
	}

	@Test
	public void getAllDataTypes()
	{
		DataTypeManager dataTypeManager=DefaultDataTypeManager.getInstance();
		assertEquals(6, dataTypeManager.getAllDataTypes().size());
		traverse(dataTypeManager.getDefaultDataType(), "");
	}

	private void traverse(DataType<?> src, String margin)
	{
		System.out.printf("%s-%s\r\n", margin, src.getName());
		for (DataType<?> child : src.getChildDataTypes())
		{
			traverse(child, margin + "\t");
		}
	}
}
