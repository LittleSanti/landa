package com.samajackun.landa.model.datatypes.indexed;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class IndexedTextTest
{
	@BeforeClass
	public static void populateWordsList()
	{
		Utils.createWordsList();
	}

	@Test
	public void testToString()
	{
		IndexedText it01=IndexedText.of((short)1, (short)4, (short)20, (short)0, (short)0);
		assertEquals("alberto bellido hernandez", it01.toString());
	}

	@Test
	public void compareToDistinct()
	{
		// alberto bellido hernandez
		IndexedText it01=IndexedText.of((short)1, (short)4, (short)20, (short)0, (short)0);
		// irma enriquez quintana
		IndexedText it02=IndexedText.of((short)22, (short)14, (short)35, (short)0, (short)0);
		assertEquals(-1, it01.compareTo(it02));
		assertEquals(1, it02.compareTo(it01));
	}

	@Test
	public void compareToEqual()
	{
		// alberto bellido hernandez
		IndexedText it01=IndexedText.of((short)1, (short)4, (short)20, (short)0, (short)0);
		// alberto bellido hernandez
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)20, (short)0, (short)0);
		assertEquals(0, it01.compareTo(it02));
		assertEquals(0, it02.compareTo(it01));
	}

	@Test
	public void concatZeroPlusOne()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)0, (short)0, (short)0, (short)0, (short)0);
		// alberto
		IndexedText it02=IndexedText.of((short)1, (short)0, (short)0, (short)0, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("alberto", it03.toString());
	}

	@Test
	public void concatZeroPlusTwo()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)0, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)0, (short)0, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("alberto bellido", it03.toString());
	}

	@Test
	public void concatZeroPlusThree()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)0, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido hernandez
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)20, (short)0, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("alberto bellido hernandez", it03.toString());
	}

	@Test
	public void concatZeroPlusFour()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)0, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido hernandez quintana
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)20, (short)35, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("alberto bellido hernandez quintana", it03.toString());
	}

	@Test
	public void concatZeroPlusFive()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)0, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido hernandez quintana
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)20, (short)35, (short)43);
		IndexedText it03=it01.concat(it02);
		assertEquals("alberto bellido hernandez quintana ulecia", it03.toString());
	}

	@Test
	public void concatOnePlusOne()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)7, (short)0, (short)0, (short)0, (short)0);
		// alberto
		IndexedText it02=IndexedText.of((short)1, (short)0, (short)0, (short)0, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("daniel alberto", it03.toString());
	}

	@Test
	public void concatOnePlusTwo()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)7, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)0, (short)0, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("daniel alberto bellido", it03.toString());
	}

	@Test
	public void concatOnePlusThree()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)7, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido hernandez
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)20, (short)0, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("daniel alberto bellido hernandez", it03.toString());
	}

	@Test
	public void concatOnePlusFour()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)7, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido hernandez quintana
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)20, (short)35, (short)0);
		IndexedText it03=it01.concat(it02);
		assertEquals("daniel alberto bellido hernandez quintana", it03.toString());
	}

	@Test(expected=TooManyWordsException.class)
	public void concatOnePlusFive()
	{
		// vacío
		IndexedText it01=IndexedText.of((short)7, (short)0, (short)0, (short)0, (short)0);
		// alberto bellido hernandez quintana
		IndexedText it02=IndexedText.of((short)1, (short)4, (short)20, (short)35, (short)43);
		it01.concat(it02);
	}
}
