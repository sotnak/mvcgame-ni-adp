package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.config.MvcGameConfig
import mvcgame.model.gameObjects.{AbsCannon, AbsMissile, GameObject}
import mvcgame.model.{Position, Vector}

import cz.cvut.fit.niadp.mvcgame.abstractFactory.IGameObjectsFactory

class CannonA(p: Position = new Position(0,0), val goFactory: IGameObjectsFactory) extends AbsCannon {

  this.position=p

  def moveUp(): Unit = move(Vector(0,- MvcGameConfig.MOVE_STEP))

  def moveDown(): Unit = move(Vector(0,MvcGameConfig.MOVE_STEP))

  override def shoot(): AbsMissile = this.goFactory.CreateMissile()
}
