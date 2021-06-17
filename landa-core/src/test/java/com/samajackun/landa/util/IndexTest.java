package com.samajackun.landa.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class IndexTest
{
	@Test
	public void test()
	{
		Index<String> index=new Index<>();
		assertEquals(0, index.size());
		int i1=index.put("january");
		assertEquals(1, index.size());
		assertEquals("january", index.get(i1));

		int i2=index.put("february");
		assertEquals(2, index.size());
		assertNotEquals(i2, i1);
		assertEquals("february", index.get(i2));

		int i3=index.put("march");
		assertEquals(3, index.size());
		assertNotEquals(i3, i1);
		assertNotEquals(i3, i2);
		assertEquals("march", index.get(i3));

		int i4=index.put("january");
		assertEquals(3, index.size());
		assertEquals(i1, i4);
	}
}
