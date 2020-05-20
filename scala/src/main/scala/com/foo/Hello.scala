package com.foo

object Hello {
    def main(args: Array[String]) = {
        val tesla =  Car ("tesla", true, None, Seq())
        println(s"Tesla is a Eletrical car: ${CarIdentifier.isElectrical(tesla)}")
        println("Hello, world")
    }
}