package cz.cvut.fit.niadp
package mvcgame.model

import mvcgame.observer.Observable

import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.GameObject
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy

import scala.collection.mutable.ListBuffer

trait IGameModel extends Observable{
  def getScore: Int

  def setMemento(memento: Any): Unit
  def createMemento(): Any

  def toggleShootingMode(): Unit
  def moveCannonDown(): Unit
  def moveCannonUp(): Unit
  def cannonShoot(): Unit
  def cannonPowerDown(): Unit
  def cannonPowerUp(): Unit
  def aimCannonDown(): Unit
  def aimCannonUp(): Unit
  def toggleMovingStrategy(): Unit

  def moveMissiles(): Unit
  def getGameObjects: ListBuffer[GameObject]

  def getCannonPos: Position
  def getMovingStrategy: IMovingStrategy

  def registerCommand(cmd: AbstractGameCommand):Unit
  def undoLastCommand():Unit

  def update():Unit
}
