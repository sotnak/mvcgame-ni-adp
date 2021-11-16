package cz.cvut.fit.niadp
package mvcgame.visitor

import mvcgame.model.gameObjects.{AbsCannon, AbsCollision, AbsEnemy, AbsMissile, GameObject}

trait IVisitor {

  def visit(visitable: IVisitable): Unit
}
