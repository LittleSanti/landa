package com.samajackun.landa.model.datatypes;

import java.util.HashSet;
import java.util.Set;

public class DataTypeManager
{
	private final Set<DataType<?>> dataTypes;

	private final DataType<?> defaultDataType;

	public DataTypeManager(DataType<?> defaultDataType)
	{
		super();
		this.defaultDataType=defaultDataType;
		this.dataTypes=new HashSet<>();
		browseTree(this.defaultDataType, this.dataTypes);
	}

	private void browseTree(DataType<?> src, Set<DataType<?>> out)
	{
		// Es importante recorrer el �rbol en orden post-fijo:
		// El Set resultante deber�a contener los tipos de datos empezando por los m�s espec�ficos y terminando por el ra�z.
		for (DataType<?> child : src.getChildDataTypes())
		{
			browseTree(child, out);
		}
		out.add(src);
	}

	public final DataType<?> getDefaultDataType()
	{
		return this.defaultDataType;
	}

	public final Set<DataType<?>> getAllDataTypes()
	{
		return this.dataTypes;
	}
}
