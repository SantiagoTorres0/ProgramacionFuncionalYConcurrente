package object Derivacion{
def derivada(f:Double => Double): Double => Double={
  val h = 0.000001
  (x:Double) => {
    val p1 = f(x-2*h)
    val p2 = -8*f(x-h)
    val p3 = 8*f(x+h)
    val p4 = -f(x+2*h)
    (p1 + p2 + p3 + p4) / (12 * h)
  }
}

def derivada_Suma(f:Double => Double, g:Double => Double): Double => Double={
  val h = 0.000001
  (x:Double) => {
    val p1_f = f(x-2*h)
    val p2_f = -8*f(x-h)
    val p3_f = 8*f(x+h)
    val p4_f = -f(x+2*h)
    val resultado_f = (p1_f + p2_f + p3_f + p4_f) / (12 * h)
    val p1_g = g(x-2*h)
    val p2_g = -8*g(x-h)
    val p3_g = 8*g(x+h)
    val p4_g = -g(x+2*h)
    val resultado_g = (p1_g + p2_g + p3_g + p4_g) / (12 * h)
    resultado_g + resultado_f
  }
}
def derivada_Resta(f:Double => Double, g:Double => Double): Double => Double={
  val h = 0.000001
  (x:Double) => {
    val p1_f = f(x-2*h)
    val p2_f = -8*f(x-h)
    val p3_f = 8*f(x+h)
    val p4_f = -f(x+2*h)
    val resultado_f = (p1_f + p2_f + p3_f + p4_f) / (12 * h)
    val p1_g = g(x-2*h)
    val p2_g = -8*g(x-h)
    val p3_g = 8*g(x+h)
    val p4_g = -g(x+2*h)
    val resultado_g = (p1_g + p2_g + p3_g + p4_g) / (12 * h)
    resultado_f - resultado_g
  }
}
}
