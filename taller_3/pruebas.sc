import Anagramas._

// ============================================================================
// 1. PRUEBAS PARA lOcPal
// ============================================================================

// --- Casos de Prueba Propios ---
val p1_propia1 = lOcPal("a")
// Esperado: List(('a', 1))

val p1_propia2 = lOcPal("roma")
// Esperado: List(('a', 1), ('m', 1), ('o', 1), ('r', 1))

val p1_propia3 = lOcPal("reconocer")
// Esperado: List(('c', 2), ('e', 2), ('n', 1), ('o', 2), ('r', 2))

val p1_propia4 = lOcPal("palabra")
// Esperado: List(('a', 3), ('b', 1), ('l', 1), ('p', 1), ('r', 1))

val p1_propia5 = lOcPal("scala")
// Esperado: List(('a', 2), ('c', 1), ('l', 1), ('s', 1))

// --- Casos de Prueba Generados por IA ---
val p1_ia1 = lOcPal("z")
// Caso frontera: Palabra unaria de un solo carácter. Esperado: List(('z', 1))

val p1_ia2 = lOcPal("anagrama")
// Caso con alta frecuencia de una misma vocal. Esperado: List(('a', 4), ('g', 1), ('m', 1), ('n', 1), ('r', 1))

val p1_ia3 = lOcPal("mismo")
// Caso con consonantes repetidas separadas. Esperado: List(('i', 1), ('m', 2), ('o', 1), ('s', 1))


// ============================================================================
// 2. PRUEBAS PARA lOcFrase
// ============================================================================

// --- Casos de Prueba Propios ---
val p2_propia1 = lOcFrase(List("hola"))
// Esperado: List(('a', 1), ('h', 1), ('l', 1), ('o', 1))

val p2_propia2 = lOcFrase(List("hola", "mundo"))
// Esperado: List(('a', 1), ('d', 1), ('h', 1), ('l', 1), ('m', 1), ('n', 1), ('o', 2), ('u', 1))

val p2_propia3 = lOcFrase(List("sol", "y", "luna"))
// Esperado: List(('a', 1), ('l', 1), ('n', 1), ('o', 1), ('s', 1), ('u', 1), ('y', 1))

val p2_propia4 = lOcFrase(List())
// Esperado: List()

val p2_propia5 = lOcFrase(List("abc", "cba"))
// Esperado: List(('a', 2), ('b', 2), ('c', 2))

// --- Casos de Prueba Generados por IA ---
val p2_ia1 = lOcFrase(List("yo", "como", "cosas"))
// Caso con frase de varias palabras. Esperado: List(('a', 1), ('c', 2), ('m', 1), ('o', 4), ('s', 2), ('y', 1))

val p2_ia2 = lOcFrase(List("a"))
// Caso frontera: Frase de una sola palabra de una sola letra. Esperado: List(('a', 1))

val p2_ia3 = lOcFrase(List("roca", "moco"))
// Caso de acumulación de consonantes idénticas entre palabras. Esperado: List(('a', 1), ('c', 2), ('m', 1), ('o', 3), ('r', 1))


// ============================================================================
// 3. PRUEBAS PARA diccionarioPorOcurrencias
// ============================================================================

// --- Casos de Prueba Propios ---
val p3_propia1 = diccionarioPorOcurrencias.get(lOcPal("cosas"))
// Esperado: Some(List("cosas")) u otra lista con palabras que tengan exactamente esas ocurrencias

val p3_propia2 = diccionarioPorOcurrencias.get(lOcPal("como"))
// Esperado: Some(List("como"))

val p3_propia3 = diccionarioPorOcurrencias.get(lOcPal("yo"))
// Esperado: Some(List("yo"))

val p3_propia4 = diccionarioPorOcurrencias.get(lOcPal("palabrainexistente"))
// Esperado: None

val p3_propia5 = diccionarioPorOcurrencias.contains(lOcPal("mocosos"))
// Esperado: true

// --- Casos de Prueba Generados por IA ---
val p3_ia1 = diccionarioPorOcurrencias.getOrElse(List(('x', 1), ('y', 1)), List())
// Caso de consulta con clave no existente en el diccionario. Esperado: List()

val p3_ia2 = diccionarioPorOcurrencias.get(lOcPal("oca"))
// Verificación de existencia de palabra corta en diccionario. Esperado: Some(List("oca"))

val p3_ia3 = diccionarioPorOcurrencias.keySet.forall(_.nonEmpty)
// Verificación estructural: asegura que ninguna clave en el mapa sea una lista de ocurrencias vacía


// ============================================================================
// 4. PRUEBAS PARA anagramasDePalabra
// ============================================================================

// --- Casos de Prueba Propios ---
val p4_propia1 = anagramasDePalabra("cosas")
// Esperado: List("cosas")

val p4_propia2 = anagramasDePalabra("como")
// Esperado: List("como")

val p4_propia3 = anagramasDePalabra("yo")
// Esperado: List("yo")

val p4_propia4 = anagramasDePalabra("mocosos")
// Esperado: List("mocosos")

val p4_propia5 = anagramasDePalabra("xyzunk")
// Esperado: List()

// --- Casos de Prueba Generados por IA ---
val p4_ia1 = anagramasDePalabra("cayo")
// Verificación de búsqueda de anagramas para palabra existente. Esperado: List("cayo")

val p4_ia2 = anagramasDePalabra("ocasos")
// Verificación de palabra con repetición de vocales y sibilantes. Esperado: List("ocasos")

val p4_ia3 = anagramasDePalabra("")
// Caso frontera: Cadena vacía enviada a búsqueda de anagramas. Esperado: List()
