package object Anagramas{
// Define la función para obtener la lista de ocurrencias de una sola palabra
def lOcPal(p: Palabra): Ocurrencias = {
  // Agrupa los caracteres idénticos de la palabra (ej. 'a' -> List('a', 'a'))
  val palabra_separada = p.groupBy(c => c)
  
  // Transforma cada grupo en una tupla de tipo (carácter, cantidad de apariciones)
  val palabra_separada_contada = palabra_separada.map { case (letra, lista) => (letra, lista.length) }
  
  // Convierte el mapa a una lista de parejas (Char, Int) y la ordena alfabéticamente
  palabra_separada_contada.toList.sorted
}

// Define la función para obtener la lista de ocurrencias de una frase completa
def lOcFrase(f: Frase): Ocurrencias = {
  // Une todas las palabras de la lista en un único String continuo
  val frase_concatenada = f.mkString
  
  // Reutiliza lOcPal para calcular las ocurrencias del String resultante
  lOcPal(frase_concatenada)
}

// Agrupa las palabras del diccionario global usando sus ocurrencias como clave
lazy val diccionarioPorOcurrencias: Map[Ocurrencias, List[Palabra]] = {
  // Asocia cada lista de ocurrencias con la lista de palabras que la forman
  diccionario.groupBy(lOcPal)
}

// Busca todos los anagramas posibles para una palabra en el diccionario
def anagramasDePalabra(palabra: Palabra): List[Palabra] = {
  // Calcula la lista de ocurrencias de la palabra recibida
  val palabra_ocurrencia = lOcPal(palabra)
  
  // Consulta el mapa precalculado; si no halla coincidencias, retorna una lista vacía
  diccionarioPorOcurrencias.getOrElse(palabra_ocurrencia, List())
}
//Documentación hecha con IA
}