package cz.cvut.fit.niadp
package mvcgame.model

import mvcgame.config.MvcGameConfig

import cz.cvut.fit.niadp.mvcgame.abstractFactory.{GameObjectsFactoryA, IGameObjectsFactory}
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.{CollisionA, EnemyA}
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCannon, AbsMissile, GameObject}
import cz.cvut.fit.niadp.mvcgame.strategy.{IMovingStrategy, RealisticMovingStrategy, SimpleMovingStrategy}

import scala.collection.mutable.ListBuffer

class GameModel extends IGameModel{
  private val goFactory : IGameObjectsFactory = new GameObjectsFactoryA(this)

  private val cannon : AbsCannon = goFactory.createCannon()
  val enemies: ListBuffer[EnemyA] = ListBuffer.empty
  val missiles: ListBuffer[AbsMissile] = ListBuffer.empty
  val collisions: ListBuffer[CollisionA] = ListBuffer.empty
  var movingStrategy: IMovingStrategy = SimpleMovingStrategy()

  var score = 0

  def moveCannonDown(): Unit = {
    cannon.moveDown()
    notifyObservers()
  }

  def moveCannonUp(): Unit = {
    cannon.moveUp()
    notifyObservers()
  }

  def cannonPowerDown(): Unit = cannon.powerDown()

  def cannonPowerUp(): Unit = cannon.powerUp()

  def aimCannonDown(): Unit = cannon.aimDown()

  def aimCannonUp(): Unit = cannon.aimUp()

  def cannonShoot(): Unit ={
    this.missiles ++= this.cannon.shoot()
    notifyObservers()
  }

  def destroyMissiles(): Unit ={
    val toRemove: ListBuffer[AbsMissile] = ListBuffer.empty

    for(missile <- this.missiles){
      if(missile.getPosition.getX > MvcGameConfig.MAX_X)
        toRemove.addOne(missile)
    }

    if(toRemove.nonEmpty)
      this.missiles --= toRemove
  }

  def moveMissiles(): Unit ={
    for(missile <- this.missiles) {
      missile.move()
    }

    val length = missiles.length

    destroyMissiles()

    if(length > 0)
      notifyObservers()
  }

  def getCannonPos: Position = cannon.getPosition

  def getMissiles: ListBuffer[AbsMissile] = this.missiles

  def getGameObjects: ListBuffer[GameObject] = {
    val go = ListBuffer.empty[GameObject]
    go ++= this.missiles
    go += this.cannon
    return go
  }

  def toggleMovingStrategy(): Unit ={
    movingStrategy match{
      case _ : SimpleMovingStrategy => movingStrategy = new RealisticMovingStrategy
      case _: RealisticMovingStrategy => movingStrategy = new SimpleMovingStrategy
      case _ =>
    }
  }

  private case class Memento(score: Int /* ... */){
  }

  def createMemento(): Any = Memento(score)

  def setMemento(memento: Any): Unit ={
    val m = memento.asInstanceOf[Memento]
    score = m.score
  }

  override def toggleShootingMode(): Unit = cannon.toggleShootingMode()

  override def getMovingStrategy: IMovingStrategy = movingStrategy
}
