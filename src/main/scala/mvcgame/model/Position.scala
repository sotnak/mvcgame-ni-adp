package cz.cvut.fit.niadp
package mvcgame.model

class Position {
  private var dimX = 0
  private var dimY = 0

  def this(posX: Int, posY: Int) {
    this()
    this.dimX = posX
    this.dimY = posY
  }

  def getX: Int = dimX

  def getY: Int = dimY

  def setY(y: Int): Unit = {
    this.dimY = y
  }

  def setX(x: Int): Unit = {
    this.dimX = x
  }
}
