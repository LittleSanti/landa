IndexedText
===========
Es una abstracción que permite almacenar textos codificados en base a un diccionario de términos comunes (WordsList). 

Cualidades
----------
	-Cada entrada ocupa sólo 2*5=10 bytes, aunque puede almacenar nombres que en realidad son muy largos, con la limitación de que cada nombre puede contener a lo sumo 5 palabras, y que el diccionario puede contener a lo sumo 65535 términos.
	-Siempre que el diccionario esté ordenado, el método compareTo no necesita acceder al mismo; le basta con comparar los índices.
	-La entrada 0 del diccionario debe ser siempre la cadena vacía.
	-Hay entradas del diccionario que contienen más de una palabra, por la frecuencia con que aparecen: "de la", "de los", "de las".

Aplicaciones
-----------
Almacenar nombres y/o apellidos en una tabla de una BD minimizando el espacio mediante la reducción de redundancia.

Ampliaciones futuras
--------------------
	-Actualmente sólo existe un diccionario (WordsList). Hay que permitir que cada columna de cada tabla tenga su propio diccionario, para que el mantenimiento resulte más manejable.
	-Para añadir un nuevo término al diccionario (y que quede ordenado) es necesario reindexar todos los IndexedText existentes. Durante la fase de aprendizaje, exigirá reindexaciones frecuentes, pero una vez alcanzada una estabilidad, será muy infrecuente que aparezca algún término que no estuviera ya registrado.
	-Podemos publicar los diccionarios online, e ir versionándolos (nombres españoles, apellidos españoles, apellidos franceses, etc). Obviamente, una columna de tipo IndexedText debe llevar siempre la referencia de qué diccionario y versión resuelven los índices.
	-Encriptación: Basta con aplicar a los índices de IndexedText una función de transformación biunívoca para convertir un texto inicial verdadero (alberto martin nuñez) en otro falso, pero con aspect auténtico (ana rodriguez del pozo). Desventaja: Es incompatible con la ordenación implícita de los términos. Para hacer compatibles ambas, habría que añadir un primer diccionario de encriptación (por sustitución), y luego el de los valores; y el método compareTo sí tendría que acceder al de encriptación, aunque sólo para obtener los índices reales.
	-Procedimiento de serializar el IndexedText a un String o Writer: Hay que añadir como parámetro de entrada un contexto, del cual hay que extraer el diccionario
	-Filtrado: Para que el filtrado sea fácil de realizar, es mejor proveer palabras completas o al menos el comienzo de una palabra (en realidad estas son las necesidades de filtrado más frecuentes). Pero si se necesita filtrar por fragmentos de la composición completa (where nombre like '%rvantes y saaved%'), hay que hacerlo expandiendo primero el valor compuesto completo, y aplicar el filtro después, al estilo clásico.
	-Funciones específicas para valores del datatype IndexedText:
		* word-count(indexed_text): retorna nº de palabras.
		* word(indexed_text, n): retorna palabra por nº de posición.
		* anyword(indexed_text)='x'
		* anyword(indexed_text) like 'x%'
		Realiza la comparación sobre cualquier palabra.
		* anywords(indexed_text)='x y'
		* anywords(indexed_text) like 'x y%'
		Realiza la comparación sobre varias palabras consecutivas.
		* concat(indexed_text1,indexed_text2,...): Concatena y produce un indexed_text nuevo.
		
	- Temo que tendremos que reimplementar TreeSet para operar con valores IndexedText, pues si queremos independizar compareTo del diccionario usado (y no queremos meter el diccionario como variable de estado), no tendremos más remedio que introducir el CONTEXTO como parámetro de entrada en compareTo.
