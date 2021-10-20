package cz.cvut.fit.niadp
package mvcgame.model.gameObjects
import mvcgame.visitor.IVisitor

abstract class AbsCannon extends GameObject {
  def moveUp(): Unit
  def moveDown(): Unit
  def shoot(): AbsMissile

  override def acceptVisitor(visitor: IVisitor): Unit = {
    visitor.visitCannon(this)
  }
}
