package cz.cvut.fit.niadp
package mvcgame.model

case class Vector(private val dX : Int = 0, private val dY : Int = 0) {

  def getDX:Int = dX
  def getDY:Int = dY
}
