package cz.cvut.fit.niadp
package mvcgame.bridge
import mvcgame.model.Position

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

case class ScalaFxGraphics(gc: GraphicsContext) extends IGameGraphicsImplementor {
  override def drawImage(path: String, pos: Position): Unit = {
    val img = new Image(path)
    gc.drawImage(img, pos.getX, pos.getY)
  }

  override def drawText(text: String, pos: Position): Unit = gc.fillText(text, pos.getX, pos.getY)

  override def drawLine(beginPos: Position, endPos: Position): Unit = gc.strokeLine(beginPos.getX, beginPos.getY, endPos.getX, endPos.getY)

  override def clear(): Unit = gc.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y)
}
