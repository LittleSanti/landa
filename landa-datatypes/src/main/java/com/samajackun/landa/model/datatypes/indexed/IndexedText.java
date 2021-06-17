package com.samajackun.landa.model.datatypes.indexed;

public class IndexedText implements Comparable<IndexedText>
{
	private final short index0;

	private final short index1;

	private final short index2;

	private final short index3;

	private final short index4;

	private IndexedText(short index0, short index1, short index2, short index3, short index4)
	{
		super();
		this.index0=index0;
		this.index1=index1;
		this.index2=index2;
		this.index3=index3;
		this.index4=index4;
	}

	public static IndexedText of(short[] indexes)
	{
		if (indexes.length > 5)
		{
			throw new TooManyWordsException();
		}
		return new IndexedText(indexes[0], indexes[1], indexes[2], indexes[3], indexes[4]);
	}

	public static IndexedText of(short index0, short index1, short index2, short index3, short index4)
	{
		return new IndexedText(index0, index1, index2, index3, index4);
	}

	@Override
	public int compareTo(IndexedText o)
	{
		int x=0;
		x=(this.index0 < o.index0
			? -1
			: this.index0 > o.index0
				? 1
				: 0);
		if (x == 0)
		{
			x=(this.index1 < o.index1
				? -1
				: this.index1 > o.index1
					? 1
					: 0);
			if (x == 0)
			{
				x=(this.index2 < o.index2
					? -1
					: this.index2 > o.index2
						? 1
						: 0);
				if (x == 0)
				{
					x=(this.index3 < o.index3
						? -1
						: this.index3 > o.index3
							? 1
							: 0);
					if (x == 0)
					{
						x=(this.index4 < o.index4
							? -1
							: this.index4 > o.index4
								? 1
								: 0);
					}
				}
			}
		}
		return x;
	}

	@Override
	public String toString()
	{
		StringBuilder stb=new StringBuilder(4 + WordsList.getInstance().get(this.index0).length() + WordsList.getInstance().get(this.index1).length() + WordsList.getInstance().get(this.index2).length() + WordsList.getInstance().get(this.index3).length() + WordsList.getInstance().get(this.index4).length());
		if (this.index0 > 0)
		{
			stb.append(WordsList.getInstance().get(this.index0));
			if (this.index1 > 0)
			{
				stb.append(' ');
				stb.append(WordsList.getInstance().get(this.index1));
				if (this.index2 > 0)
				{
					stb.append(' ');
					stb.append(WordsList.getInstance().get(this.index2));
					if (this.index3 > 0)
					{
						stb.append(' ');
						stb.append(WordsList.getInstance().get(this.index3));
						if (this.index4 > 0)
						{
							stb.append(' ');
							stb.append(WordsList.getInstance().get(this.index4));
						}
					}
				}
			}
		}
		return stb.toString();
	}

	public IndexedText concat(IndexedText o)
	{
		short index0;
		short index1;
		short index2;
		short index3;
		short index4;
		if (this.index0 != 0)
		{
			index0=this.index0;
			if ((this.index1 == 0))
			{
				if (o.index0 > 0)
				{
					index1=o.index0;
					if (o.index1 > 0)
					{
						index2=o.index1;
						if (o.index2 > 0)
						{
							index3=o.index2;
							if (o.index3 > 0)
							{
								index4=o.index3;
								if (o.index4 > 0)
								{
									throw new TooManyWordsException();
								}
							}
							else
							{
								index4=0;
							}
						}
						else
						{
							index3=0;
							index4=0;
						}
					}
					else
					{
						index2=0;
						index3=0;
						index4=0;
					}
				}
				else
				{
					index1=0;
					index2=0;
					index3=0;
					index4=0;
				}
			}
			else
			{
				index1=this.index0;
				if ((this.index2 == 0))
				{
					if (o.index0 > 0)
					{
						index2=o.index0;
						if (o.index1 > 0)
						{
							index3=o.index1;
							if (o.index2 > 0)
							{
								index4=o.index2;
								if (o.index3 > 0)
								{

									throw new TooManyWordsException();
								}
							}
							else
							{
								index4=0;
							}
						}
						else
						{
							index3=0;
							index4=0;
						}
					}
					else
					{
						index2=0;
						index3=0;
						index4=0;
					}
				}
				else
				{
					index2=this.index0;
					if ((this.index3 == 0))
					{
						if (o.index0 > 0)
						{
							index3=o.index0;
							if (o.index1 > 0)
							{
								index4=o.index1;
								if (o.index2 > 0)
								{
									throw new TooManyWordsException();
								}
							}
							else
							{
								index3=0;
								index4=0;
							}
						}
						else
						{
							index2=0;
							index3=0;
							index4=0;
						}
					}
					else
					{
						index3=this.index0;
						if ((this.index4 == 0))
						{
							if (o.index0 > 0)
							{
								index4=o.index0;
								if (o.index1 > 0)
								{
									throw new TooManyWordsException();
								}
							}
							else
							{
								index3=0;
								index4=0;
							}
						}
						else
						{
							index4=this.index0;
						}
					}
				}
			}
		}
		else
		{
			index0=o.index0;
			index1=o.index1;
			index2=o.index2;
			index3=o.index3;
			index4=o.index4;
		}
		return IndexedText.of(index0, index1, index2, index3, index4);
	}
}