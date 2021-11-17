package cz.cvut.fit.niadp
package mvcgame.visitor
import mvcgame.model.gameObjects.{AbsCannon, AbsCollision, AbsEnemy, AbsMissile}

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics

class GameRenderer extends IVisitor {
  private var gc : IGameGraphics = _

  def setGraphicsContext(gc: IGameGraphics): Unit = {
    this.gc = gc
  }


  def visitCannon(cannon: AbsCannon): Unit = {
    this.gc.drawImage("images/cannon.png", cannon.getPosition)
  }

  def visitMissile(missile: AbsMissile): Unit = {
    this.gc.drawImage("images/missile.png", missile.getPosition)
  }

  def visitEnemy(enemy: AbsEnemy): Unit = {
    enemy.variant match{
      case 1 => this.gc.drawImage("images/enemy1.png", enemy.getPosition)
      case 2 => this.gc.drawImage("images/enemy2.png", enemy.getPosition)
    }
  }

  def visitCollision(collision: AbsCollision): Unit = {
    this.gc.drawImage("images/collision.png", collision.getPosition)
  }

  override def visit(visitable: IVisitable): Unit = {

    visitable match {
      case cannon: AbsCannon => visitCannon(cannon)
      case missile: AbsMissile => visitMissile(missile)
      case enemy: AbsEnemy => visitEnemy(enemy)
      case collision: AbsCollision => visitCollision(collision)
      case _ =>
    }
  }
}
