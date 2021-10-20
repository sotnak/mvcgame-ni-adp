package cz.cvut.fit.niadp
package mvcgame.visitor
import mvcgame.model.gameObjects.{AbsCannon, AbsMissile}

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
}
