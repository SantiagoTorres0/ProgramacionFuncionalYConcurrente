import Derivacion._

// 1. Definición de funciones de prueba
val cte = (x: Double) => 2.0 //funcion constante
val f = (x: Double) => (x * x) //función generica
val g = (x: Double) => (x * x * x) //función generica
// 2. Casos de prueba propuestos por estudiantes
val prueba_generica = derivada(f)(0) //se espera 0
val prueba_suma = derivada_Suma(f,g)(2) //se espera 16
val prueba_resta = derivada_Resta(f,g)(3) //se espera -21
val prueba_constante = derivada(cte)(2) //se espera 0
val prueba_suma_2 = derivada_Suma(cte, cte)(1) //se espera 0
//Casos de prueba generados por la IA
// 1. Evaluación en un punto negativo con la Resta
// f(x) = x^2, g(x) = x^3 => (f - g)'(x) = 2x - 3x^2
// Evaluado en x = -1.0 => 2(-1) - 3(-1)^2 = -2 - 3 = -5.0
val prueba_punto_negativo = derivada_Resta(f, g)(-1.0) // Se espera -5.0

// 2. Identidad Trigonométrica: d/dx(sin(x) + cos(x)) en x = 0.0
// f_trig = sin(x), g_trig = cos(x) => d/dx(sin(x) + cos(x)) = cos(x) - sin(x)
// Evaluado en x = 0.0 => cos(0) - sin(0) = 1.0 - 0.0 = 1.0
val f_trig = (x: Double) => scala.math.sin(x)
val g_trig = (x: Double) => scala.math.cos(x)
val prueba_trigonometrica = derivada_Suma(f_trig, g_trig)(0.0) // Se espera 1.0

// 3. Raíz de un Punto Crítico / Máximo
// f_parabola(x) = -x^2 + 4x => f'(x) = -2x + 4
// Evaluado en el vértice x = 2.0 => -2(2) + 4 = 0.0
val f_parabola = (x: Double) => -x * x + 4 * x
val prueba_punto_critico = derivada(f_parabola)(2.0) // Se espera 0.0