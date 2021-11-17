package cz.cvut.fit.niadp
package mvcgame.bridge
import mvcgame.model.Position

case class GameGraphics(implementor: IGameGraphicsImplementor) extends IGameGraphics {

  override def drawImage(path: String, pos: Position): Unit = implementor.drawImage(path, pos)
  override def drawText(text: String, pos: Position): Unit = implementor.drawText(text, pos)
  override def drawRectangle(leftTop: Position, rightBottom: Position): Unit = {
    implementor.drawLine(leftTop,
      new Position(rightBottom.getX, leftTop.getY))

    implementor.drawLine(leftTop,
      new Position(leftTop.getX, rightBottom.getY))

    implementor.drawLine(rightBottom,
      new Position(leftTop.getX, rightBottom.getY))

    implementor.drawLine(rightBottom,
      new Position(rightBottom.getX, leftTop.getY))
  }
  override def clear(): Unit = implementor.clear()
}
