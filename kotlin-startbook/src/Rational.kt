// クラスRationalの定義
class Rational(val numerator: Int, val denominator: Int) {
    // イニシャライザで分母0を禁止する
    init {
        require(denominator != 0, {"denominator must not be null"})
    }
    // toStringをオーバーライド
    override fun toString(): String = "${numerator}/${denominator}"
}