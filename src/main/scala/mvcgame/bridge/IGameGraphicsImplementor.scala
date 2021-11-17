package cz.cvut.fit.niadp
package mvcgame.bridge

import mvcgame.model.Position

trait IGameGraphicsImplementor {
  def drawImage(path: String, pos: Position): Unit
  def drawText(text: String, pos: Position): Unit
  def drawLine(beginPos: Position, endPos: Position): Unit
  def clear(): Unit
}
