package cz.cvut.fit.niadp
package mvcgame.model

import mvcgame.config.MvcGameConfig

import cz.cvut.fit.niadp.mvcgame.abstractFactory.{GameObjectsFactoryA, IGameObjectsFactory}
import cz.cvut.fit.niadp.mvcgame.command.AbstractGameCommand
import cz.cvut.fit.niadp.mvcgame.iterator.{ConcreteAggregate, IAggregate, IIterator}
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCannon, AbsCollision, AbsEnemy, AbsMissile, GameInfo, GameObject}
import cz.cvut.fit.niadp.mvcgame.strategy.{IMovingStrategy, RealisticMovingStrategy, SimpleMovingStrategy}

import java.util
import java.util.concurrent.LinkedBlockingQueue
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

class GameModel extends IGameModel{
  private val goFactory : IGameObjectsFactory = new GameObjectsFactoryA(this)

  private val cannon : AbsCannon = goFactory.createCannon()
  val enemies: ListBuffer[AbsEnemy] = ListBuffer.empty
  val missiles: ListBuffer[AbsMissile] = ListBuffer.empty
  val collisions: ListBuffer[AbsCollision] = ListBuffer.empty
  var movingStrategy: IMovingStrategy = SimpleMovingStrategy()
  val gameInfo: GameInfo = new GameInfo(this)

  val unexecutedCmds: util.Queue[AbstractGameCommand] = new LinkedBlockingQueue[AbstractGameCommand]()
  val executedCmds: util.Stack[AbstractGameCommand] = new util.Stack[AbstractGameCommand]()

  val aggregate: IAggregate = ConcreteAggregate()

  var score = 0

  override def getScore: Int = score

  override def update(): Unit = {
    executeCmds()
    moveMissiles()

    if(enemies.isEmpty){
      spawnEnemies()
    }

    missileVicinity()
    collisionsAging()
  }

  def collisionsAging(): Unit = {
    val collisionsToRemove = ListBuffer.empty[AbsCollision]

    for(collision <- collisions){
      if(collision.getAge > MvcGameConfig.COLLISION_LIFESPAN)
        collisionsToRemove += collision
    }

    collisions --= collisionsToRemove

    if(collisionsToRemove.nonEmpty)
      notifyObservers()
  }

  def spawnEnemies(): Unit = {
    for(i <- 1 to MvcGameConfig.ENEMIES_SPAWNED){
      enemies.addOne(goFactory.createEnemy())
    }
  }

  def missileVicinity(): Unit = {
    val enemiesToRemove = ListBuffer.empty[AbsEnemy]
    val missilesToRemove = ListBuffer.empty[AbsMissile]

    for(missile <- missiles){
      breakable {
        for (enemy <- enemies) {
          val distance = missile.getPosition.distance(enemy.getPosition)

          if (distance < MvcGameConfig.ENEMY_HIT_SIZE) {
            collisions.addOne(enemy.destroy())
            enemiesToRemove += enemy
            missilesToRemove += missile
            break
          }
        }
      }
    }

    enemies --= enemiesToRemove
    missiles --= missilesToRemove

    score += enemiesToRemove.length

    if(enemiesToRemove.nonEmpty)
      notifyObservers()
  }

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
      if(missile.getPosition.getX > MvcGameConfig.MAX_X || missile.getPosition.getX < 0
        || missile.getPosition.getY > MvcGameConfig.MAX_Y /*|| missile.getPosition.getY < 0*/) {
        toRemove.addOne(missile)
      }
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
    go ++= missiles
    go += cannon
    go ++= enemies
    go ++= collisions
    go += gameInfo
    return go
  }

  def getGameObjectsIterator: IIterator[GameObject] = aggregate.createIterator[GameObject](getGameObjects)

  def toggleMovingStrategy(): Unit ={
    movingStrategy match{
      case _ : SimpleMovingStrategy => movingStrategy = new RealisticMovingStrategy
      case _: RealisticMovingStrategy => movingStrategy = new SimpleMovingStrategy
      case _ =>
    }
  }

  private case class Memento( cannonPos: Position, cannonPower: Int, cannonAngle: Double){}

  def createMemento(): Any = Memento(new Position(cannon.position.getX, cannon.position.getY), cannon.getPower, cannon.getAngle )

  def setMemento(memento: Any): Unit ={
    val m = memento.asInstanceOf[Memento]
    cannon.position.setX(m.cannonPos.getX)
    cannon.position.setY(m.cannonPos.getY)
    cannon.setPower(m.cannonPower)
    cannon.setAngle(m.cannonAngle)
  }

  override def toggleShootingMode(): Unit = cannon.toggleShootingMode()

  override def getMovingStrategy: IMovingStrategy = movingStrategy

  override def registerCommand(cmd: AbstractGameCommand): Unit = unexecutedCmds.add(cmd)

  override def undoLastCommand(): Unit = {
    if(!executedCmds.empty()){
      val cmd = executedCmds.pop()
      cmd.unExecute()
      notifyObservers()
    }
  }

  def executeCmds(): Unit = {
    while(!unexecutedCmds.isEmpty){
      val cmd = unexecutedCmds.poll()
      cmd.doExecute()
      executedCmds.push(cmd)
    }

    notifyObservers()
  }

  override def getCannonPower: Int = cannon.getPower

  override def getCannonAngle: Double = cannon.getAngle
}
