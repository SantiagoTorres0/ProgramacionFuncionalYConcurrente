package object Multiplication{
def pheasantAlgorithm(a: Int, b: Int): Int = {
  if (a == 0) {
    0
  } else if (a % 2 == 1) {
    b + pheasantAlgorithm(a / 2, b * 2)
  } else {
    pheasantAlgorithm(a / 2, b * 2)
  }
}
def pheasantAlgorithmIt(a: Int, b: Int, acc: Int): Int = {
  if (a == 0) {
    acc
  } else if (a % 2 == 1) {
    pheasantAlgorithmIt(a / 2, b * 2, acc + b)
  } else {
    pheasantAlgorithmIt(a / 2, b * 2, acc)
  }
}
}
