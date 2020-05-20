package com.foo

import java.io._

case class Car(val brand: String, val isElectrical: Boolean, val libar: Option[Lidar], val camera: Seq[Camera])
case class Lidar(val brand: String, val lines: Int)
case class Camera(val brand: String, val mpx: Int)

object CarIdentifier {
    def isElectrical(c: Car): Boolean = {
      c.isElectrical
    }
}
