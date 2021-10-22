package cz.cvut.fit.niadp
package mvcgame.visitor

import mvcgame.model.gameObjects.{AbsCannon, AbsCollision, AbsEnemy, AbsMissile, GameObject}

trait IVisitor {
  def visitCannon(cannon: AbsCannon): Unit
  def visitMissile(missile: AbsMissile): Unit
  def visitEnemy(enemy: AbsEnemy): Unit
  def visitCollision(collision: AbsCollision): Unit

  def visit(visitable: IVisitable): Unit = {
    visitable match {
      case cannon: AbsCannon => visitCannon(cannon)
      case missile: AbsMissile => visitMissile(missile)
      case enemy: AbsEnemy => visitEnemy(enemy)
      case collision: AbsCollision => visitCollision(collision)
      case _ =>
    }
  }
}
