package com.samajackun.landa.engine.dummy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.samajackun.landa.engine.EngineException;

public class StoreTableViewTest
{
	@Test
	public void empty()
	{
		SourceTableView tableView=new SourceTableView();
		try
		{
			assertEquals(0, tableView.size());
		}
		catch (EngineException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void createAndGet()
	{
		SourceTableView tableView=new SourceTableView();
		try
		{
			Object[] row= {
				1001,
				"january"
			};
			long rowId=tableView.create(row);
			assertEquals(1, tableView.size());
			Object[] row2=tableView.get(rowId);
			assertArrayEquals(row, row2);
		}
		catch (EngineException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void createAndSet()
	{
		SourceTableView tableView=new SourceTableView();
		try
		{
			Object[] row= {
				1001,
				"january"
			};
			long rowId=tableView.create(row);
			assertEquals(1, tableView.size());
			Object[] row2= {
				1002,
				"february"
			};
			tableView.set(rowId, row2);
			Object[] row3=tableView.get(rowId);
			assertArrayEquals(row2, row3);
		}
		catch (EngineException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void createAndDelete()
	{
		SourceTableView tableView=new SourceTableView();
		try
		{
			Object[] row= {
				1001,
				"january"
			};
			long rowId=tableView.create(row);
			tableView.delete(rowId);
		}
		catch (EngineException e)
		{
			e.printStackTrace();
			fail(e.toString());
		}
	}
}
