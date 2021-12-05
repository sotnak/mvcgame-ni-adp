package cz.cvut.fit.niadp
package mvcgame.proxy

import mvcgame.model.{IGameModel, Position}

import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand
import cz.cvut.fit.niadp.mvcgame.iterator.IIterator
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.GameObject
import cz.cvut.fit.niadp.mvcgame.observer.Observer
import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy

case class GameModelProxy(model: IGameModel) extends IGameModel{
  override def moveCannonDown(): Unit = model.moveCannonDown()
  override def moveCannonUp(): Unit = model.moveCannonUp()
  override def cannonShoot(): Unit = model.cannonShoot()
  override def cannonPowerDown(): Unit = model.cannonPowerDown()
  override def cannonPowerUp(): Unit = model.cannonPowerUp()
  override def aimCannonDown(): Unit = model.aimCannonDown()
  override def aimCannonUp(): Unit = model.aimCannonUp()
  override def toggleMovingStrategy(): Unit = model.toggleMovingStrategy()
  override def toggleShootingMode(): Unit = model.toggleShootingMode()
  override def moveMissiles(): Unit = model.moveMissiles()
  override def setMemento(memento: Any): Unit = model.setMemento(memento)
  override def createMemento(): Any = model.createMemento()
  override def getCannonPos: Position = model.getCannonPos
  override def getMovingStrategy: IMovingStrategy = model.getMovingStrategy
  override def registerObserver(observer: Observer): Unit = model.registerObserver(observer)
  override def unregisterObserver(observer: Observer): Unit = model.unregisterObserver(observer)
  override def registerCommand(cmd: AbstractGameCommand): Unit = model.registerCommand(cmd)
  override def undoLastCommand(): Unit = model.undoLastCommand()
  override def update(): Unit = model.update()
  override def getScore: Int = model.getScore
  override def getGameObjectsIterator: IIterator[GameObject] = model.getGameObjectsIterator
  override def getCannonPower: Int = model.getCannonPower
  override def getCannonAngle: Double = model.getCannonAngle
}
