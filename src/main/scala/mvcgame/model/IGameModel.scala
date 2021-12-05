package cz.cvut.fit.niadp
package mvcgame.model

import mvcgame.observer.Observable

import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand
import cz.cvut.fit.niadp.mvcgame.iterator.IIterator
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.GameObject
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy

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
  def getGameObjectsIterator: IIterator[GameObject]
  def getCannonPos: Position
  def getCannonPower: Int
  def getCannonAngle: Double
  def getMovingStrategy: IMovingStrategy
  def registerCommand(cmd: AbstractGameCommand):Unit
  def undoLastCommand():Unit
  def update():Unit
}
