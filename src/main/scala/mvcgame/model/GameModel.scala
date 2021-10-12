package cz.cvut.fit.niadp
package mvcgame.model

import mvcgame.config.MvcGameConfig

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.Cannon
import cz.cvut.fit.niadp.mvcgame.observer.Observable

case class GameModel() extends Observable {
  private val cannon = new Cannon(new Position(MvcGameConfig.CANNON_POSX, MvcGameConfig.CANNON_POSY))

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
