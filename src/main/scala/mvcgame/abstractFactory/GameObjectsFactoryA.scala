package cz.cvut.fit.niadp
package mvcgame.abstractFactory

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCollision, AbsEnemy}
import cz.cvut.fit.niadp.mvcgame.model.{IGameModel, Position}
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.{CannonA, CollisionA, EnemyA, MissileA}

class GameObjectsFactoryA(val model: IGameModel) extends IGameObjectsFactory {
  override def createCannon(): CannonA = new CannonA(new Position(MvcGameConfig.CANNON_POSX, MvcGameConfig.CANNON_POSY), this)

  override def createMissile(initAngle: Double, initVelocity: Int): MissileA = new MissileA(new Position(model.getCannonPos.getX, model.getCannonPos.getY), initAngle, initVelocity, model.getMovingStrategy)

  override def createEnemy(): AbsEnemy = new EnemyA()

  override def createCollision(): AbsCollision = new CollisionA()
}
