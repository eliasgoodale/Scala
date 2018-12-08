package scala
final case class Symbol private (name: String) {
    override def toString: String = "'" + name
};