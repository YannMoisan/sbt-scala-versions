import java.lang.management.ManagementFactory

object Util {
  def test(name: String) {
    (1 to 1).foreach {
      i =>
        println(s"$name[$i]")
        Thread.sleep(1000)
    }
  }
}
