package cz.cvut.fit.niadp
package mvcgame.model.gameObjects
import mvcgame.model.{Position, Vector}

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig

class Cannon(p: Position) extends GameObject {

  this.position=p

  def moveUp(): Unit = move(Vector(0,- MvcGameConfig.MOVE_STEP))

  def moveDown(): Unit = move(Vector(0,MvcGameConfig.MOVE_STEP))

}
