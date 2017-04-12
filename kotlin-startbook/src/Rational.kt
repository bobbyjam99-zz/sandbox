// クラスRationalの定義
// 約分する
class Rational(n: Int, d: Int) {
    // イニシャライザで分母0を禁止する
    init {
        require(d != 0, {"denominator must not be null"})
    }
    private val g = gcd(Math.abs(n), Math.abs(d))
    val numerator: Int = n / g
    val denominator: Int = d / g
    // toStringをオーバーライド
    override fun toString(): String = "${numerator}/${denominator}"
    // 再帰関数
    tailrec private fun gcd(a: Int, b: Int): Int =
            if (b == 0) a
            else gcd(b, a % b)
}