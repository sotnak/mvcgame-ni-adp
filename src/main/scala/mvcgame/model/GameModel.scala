package cz.cvut.fit.niadp
package mvcgame.model

import mvcgame.config.MvcGameConfig

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{Cannon, Collision, Enemy, Missile}
import cz.cvut.fit.niadp.mvcgame.observer.Observable

import scala.collection.mutable.ListBuffer

case class GameModel() extends Observable {
  private val cannon = new Cannon(new Position(MvcGameConfig.CANNON_POSX, MvcGameConfig.CANNON_POSY))
  val enemies: ListBuffer[Enemy] = ListBuffer.empty
  val missiles: ListBuffer[Missile] = ListBuffer.empty
  val collisions: ListBuffer[Collision] = ListBuffer.empty

  def moveCannonDown(): Unit = {
    cannon.moveDown()
    notifyObservers()
  }

  def moveCannonUp(): Unit = {
    cannon.moveUp()
    notifyObservers()
  }

  def getCannonPos: Position = cannon.getPosition
}
