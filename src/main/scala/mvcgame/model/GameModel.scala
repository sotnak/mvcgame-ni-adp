package cz.cvut.fit.niadp
package mvcgame.model

import mvcgame.config.MvcGameConfig

import cz.cvut.fit.niadp.mvcgame.abstractFactory.{GameObjectsFactoryA, IGameObjectsFactory}
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCannon, AbsMissile, Collision, Enemy, GameObject}
import cz.cvut.fit.niadp.mvcgame.observer.Observable

import scala.collection.mutable.ListBuffer

case class GameModel() extends Observable {

  private val goFactory : IGameObjectsFactory = new GameObjectsFactoryA(this)

  private val cannon : AbsCannon = goFactory.createCannon()
  val enemies: ListBuffer[Enemy] = ListBuffer.empty
  val missiles: ListBuffer[AbsMissile] = ListBuffer.empty
  val collisions: ListBuffer[Collision] = ListBuffer.empty

  def moveCannonDown(): Unit = {
    cannon.moveDown()
    notifyObservers()
  }

  def moveCannonUp(): Unit = {
    cannon.moveUp()
    notifyObservers()
  }

  def cannonShoot(): Unit ={
    this.missiles.addOne(this.cannon.shoot())
    notifyObservers()
  }

  def moveMissiles(): Unit ={
    for(missile <- this.missiles) {
      missile.move(Vector(MvcGameConfig.MOVE_STEP,0))
    }

    notifyObservers()
  }

  def destroyMissiles(): Unit ={
    val toRemove: ListBuffer[AbsMissile] = ListBuffer.empty

    for(missile <- this.missiles){
      if(missile.getPosition.getX > MvcGameConfig.MAX_X)
        toRemove.addOne(missile)
    }

    this.missiles --= toRemove
  }

  def getCannonPos: Position = cannon.getPosition

  def getMissiles: ListBuffer[AbsMissile] = this.missiles

  def getGameObjects: ListBuffer[GameObject] = {
    val go = ListBuffer.empty[GameObject]
    go ++= this.missiles
    go += this.cannon
    return go
  }
}
