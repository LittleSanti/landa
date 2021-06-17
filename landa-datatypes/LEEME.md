IndexedText
===========
Es una abstracci�n que permite almacenar textos codificados en base a un diccionario de t�rminos comunes (WordsList). 

Cualidades
----------
	-Cada entrada ocupa s�lo 2*5=10 bytes, aunque puede almacenar nombres que en realidad son muy largos, con la limitaci�n de que cada nombre puede contener a lo sumo 5 palabras, y que el diccionario puede contener a lo sumo 65535 t�rminos.
	-Siempre que el diccionario est� ordenado, el m�todo compareTo no necesita acceder al mismo; le basta con comparar los �ndices.
	-La entrada 0 del diccionario debe ser siempre la cadena vac�a.
	-Hay entradas del diccionario que contienen m�s de una palabra, por la frecuencia con que aparecen: "de la", "de los", "de las".

Aplicaciones
-----------
Almacenar nombres y/o apellidos en una tabla de una BD minimizando el espacio mediante la reducci�n de redundancia.

Ampliaciones futuras
--------------------
	-Actualmente s�lo existe un diccionario (WordsList). Hay que permitir que cada columna de cada tabla tenga su propio diccionario, para que el mantenimiento resulte m�s manejable.
	-Para a�adir un nuevo t�rmino al diccionario (y que quede ordenado) es necesario reindexar todos los IndexedText existentes. Durante la fase de aprendizaje, exigir� reindexaciones frecuentes, pero una vez alcanzada una estabilidad, ser� muy infrecuente que aparezca alg�n t�rmino que no estuviera ya registrado.
	-Podemos publicar los diccionarios online, e ir version�ndolos (nombres espa�oles, apellidos espa�oles, apellidos franceses, etc). Obviamente, una columna de tipo IndexedText debe llevar siempre la referencia de qu� diccionario y versi�n resuelven los �ndices.
	-Encriptaci�n: Basta con aplicar a los �ndices de IndexedText una funci�n de transformaci�n biun�voca para convertir un texto inicial verdadero (alberto martin nu�ez) en otro falso, pero con aspect aut�ntico (ana rodriguez del pozo). Desventaja: Es incompatible con la ordenaci�n impl�cita de los t�rminos. Para hacer compatibles ambas, habr�a que a�adir un primer diccionario de encriptaci�n (por sustituci�n), y luego el de los valores; y el m�todo compareTo s� tendr�a que acceder al de encriptaci�n, aunque s�lo para obtener los �ndices reales.
	-Procedimiento de serializar el IndexedText a un String o Writer: Hay que a�adir como par�metro de entrada un contexto, del cual hay que extraer el diccionario
	-Filtrado: Para que el filtrado sea f�cil de realizar, es mejor proveer palabras completas o al menos el comienzo de una palabra (en realidad estas son las necesidades de filtrado m�s frecuentes). Pero si se necesita filtrar por fragmentos de la composici�n completa (where nombre like '%rvantes y saaved%'), hay que hacerlo expandiendo primero el valor compuesto completo, y aplicar el filtro despu�s, al estilo cl�sico.
	-Funciones espec�ficas para valores del datatype IndexedText:
		* word-count(indexed_text): retorna n� de palabras.
		* word(indexed_text, n): retorna palabra por n� de posici�n.
		* anyword(indexed_text)='x'
		* anyword(indexed_text) like 'x%'
		Realiza la comparaci�n sobre cualquier palabra.
		* anywords(indexed_text)='x y'
		* anywords(indexed_text) like 'x y%'
		Realiza la comparaci�n sobre varias palabras consecutivas.
		* concat(indexed_text1,indexed_text2,...): Concatena y produce un indexed_text nuevo.
		
	- Temo que tendremos que reimplementar TreeSet para operar con valores IndexedText, pues si queremos independizar compareTo del diccionario usado (y no queremos meter el diccionario como variable de estado), no tendremos m�s remedio que introducir el CONTEXTO como par�metro de entrada en compareTo.
