package cz.cvut.fit.niadp
package mvcgame.bridge

import mvcgame.model.Position

trait IGameGraphics {
  def drawImage(path: String, pos: Position): Unit
  def drawText(text: String, pos: Position): Unit
  def drawRectangle(leftTop: Position, rightBottom: Position): Unit
  def clear(): Unit
}
