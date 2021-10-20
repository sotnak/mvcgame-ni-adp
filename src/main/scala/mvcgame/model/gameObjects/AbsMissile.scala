package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

import mvcgame.visitor.IVisitor

abstract class AbsMissile extends GameObject {
  override def acceptVisitor(visitor: IVisitor): Unit = {
    visitor.visitMissile(this)
  }
}
