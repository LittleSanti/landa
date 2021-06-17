package com.samajackun.landa.model.datatypes.indexed;

import java.util.SortedSet;
import java.util.TreeSet;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils
{
	public WordsList createWordsList()
	{
		SortedSet<String> words=new TreeSet<>();
		// Nombres:
		words.add("alberto");
		words.add("beatriz");
		words.add("clara");
		words.add("daniel");
		words.add("elena");
		words.add("felipe");
		words.add("gracia");
		words.add("hector");
		words.add("irma");
		words.add("julieta");
		words.add("mario");
		words.add("nicolas");
		words.add("olivia");
		words.add("paula");
		words.add("quintin");
		words.add("romeo");
		words.add("santi");
		words.add("tomas");
		words.add("ursula");
		words.add("victor");
		words.add("wenceslao");
		words.add("xanadu");
		words.add("yamile");
		words.add("zenon");

		// Apellidos:
		words.add("alvarez");
		words.add("bellido");
		words.add("cortina");
		words.add("de");
		words.add("de la");
		words.add("de las");
		words.add("de los");
		words.add("del");
		words.add("enriquez");
		words.add("fernandez");
		words.add("gomez");
		words.add("hernandez");
		words.add("illescas");
		words.add("jimenez");
		words.add("koplovitz");
		words.add("lopez");
		words.add("moreno");
		words.add("navarro");
		words.add("olias");
		words.add("perez");
		words.add("quintana");
		words.add("ramirez");
		words.add("sevilla");
		words.add("triana");
		words.add("ulecia");
		words.add("valiente");
		words.add("wagner");
		words.add("ximenez");
		words.add("yanguas");
		words.add("zoto");

		WordsList.getInstance().add("");
		words.stream().forEach(x -> WordsList.getInstance().add(x));
		return WordsList.getInstance();
	}

}
