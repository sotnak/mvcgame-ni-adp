package cz.cvut.fit.niadp
package mvcgame.model

class Position(posX: Int=0, posY: Int=0) {
  private var dimX = posX
  private var dimY = posY

  def getX: Int = dimX

  def getY: Int = dimY

  def setY(y: Int): Unit = {
    this.dimY = y
  }

  def setX(x: Int): Unit = {
    this.dimX = x
  }

  def add(v: Vector): Unit = {
    dimX += v.getDX
    dimY += v.getDY
  }

  def distance(other: Position): Double = scala.math.sqrt(scala.math.pow(getX - other.getX, 2) + scala.math.pow(getY - other.getY, 2))
}
