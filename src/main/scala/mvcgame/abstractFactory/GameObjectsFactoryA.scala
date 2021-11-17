package cz.cvut.fit.niadp
package mvcgame.abstractFactory

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCollision, AbsEnemy}
import cz.cvut.fit.niadp.mvcgame.model.{IGameModel, Position}
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.{CannonA, CollisionA, EnemyA, MissileA}

import scala.util.Random

class GameObjectsFactoryA(val model: IGameModel) extends IGameObjectsFactory {
  val rnd = new Random

  override def createCannon(): CannonA = new CannonA(new Position(MvcGameConfig.CANNON_POSX, MvcGameConfig.CANNON_POSY), this)

  override def createMissile(initAngle: Double, initVelocity: Int): MissileA = new MissileA(new Position(model.getCannonPos.getX, model.getCannonPos.getY), initAngle, initVelocity, model.getMovingStrategy)

  override def createEnemy(): AbsEnemy = {
    val variant: Int = 1 + rnd.nextInt(2)

    val xPos: Int = MvcGameConfig.ENEMY_X_OFFSET + rnd.nextInt(MvcGameConfig.ENEMY_MAX_X - MvcGameConfig.ENEMY_X_OFFSET + 1)
    val yPos: Int = MvcGameConfig.ENEMY_Y_OFFSET + rnd.nextInt(MvcGameConfig.ENEMY_MAX_Y - MvcGameConfig.ENEMY_Y_OFFSET + 1)

    new EnemyA(variant, new Position(xPos, yPos), this)
  }

  override def createCollision(position: Position): AbsCollision = new CollisionA(position)
}
