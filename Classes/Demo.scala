import graphics._
import run._

object PointDemo {
    def main(args: Array[String]) {
        val pt = new Point(10, 20)
        pt.move(10, 10)
    }
}

object LocationDemo {
    def main(args: Array[String]) {
        val loc = new Location(10, 20, 15)
        loc.move(10, 10, 5);
    }
}

object LoopDemo {
    def main(args: Array[String]) {
        4 times println("hello");
    }
}

