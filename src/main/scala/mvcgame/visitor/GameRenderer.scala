package cz.cvut.fit.niadp
package mvcgame.visitor
import mvcgame.model.gameObjects.{AbsCannon, AbsCollision, AbsEnemy, AbsMissile}

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

class GameRenderer extends IVisitor {
  private var gc : GraphicsContext = _

  def setGraphicsContext(gc: GraphicsContext): Unit = {
    this.gc = gc
  }

  override def visitCannon(cannon: AbsCannon): Unit = {
    this.gc.drawImage(new Image("images/cannon.png"), cannon.getPosition.getX, cannon.getPosition.getY)
  }

  override def visitMissile(missile: AbsMissile): Unit = {
    this.gc.drawImage(new Image("images/missile.png"), missile.getPosition.getX, missile.getPosition.getY)
  }

  override def visitEnemy(enemy: AbsEnemy): Unit = {
    this.gc.drawImage(new Image("images/enemy1.png"), enemy.getPosition.getX, enemy.getPosition.getY)
  }

  override def visitCollision(collision: AbsCollision): Unit = {
    this.gc.drawImage(new Image("images/collision.png"), collision.getPosition.getX, collision.getPosition.getY)
  }
}
