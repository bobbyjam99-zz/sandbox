// クラスRationalの定義
class Rational(val numerator: Int, val denominator: Int) {
    // toStringをオーバーライド
    override fun toString(): String = "${numerator}/${denominator}"
}