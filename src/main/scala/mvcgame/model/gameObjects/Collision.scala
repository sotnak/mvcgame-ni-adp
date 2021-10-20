package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

import mvcgame.model.Position

import cz.cvut.fit.niadp.mvcgame.visitor.IVisitor

class Collision(p: Position) extends GameObject {
  this.position = p

  override def acceptVisitor(visitor: IVisitor): Unit = ???
}
