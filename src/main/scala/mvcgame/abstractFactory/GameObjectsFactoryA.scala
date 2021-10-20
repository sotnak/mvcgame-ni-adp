package cz.cvut.fit.niadp
package mvcgame.abstractFactory

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.model.{GameModel, Position}
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.familyA.{CannonA, MissileA}

class GameObjectsFactoryA(val model: GameModel) extends IGameObjectsFactory {
  override def createCannon(): CannonA = new CannonA(new Position(MvcGameConfig.CANNON_POSX, MvcGameConfig.CANNON_POSY), this)

  override def CreateMissile(): MissileA = new MissileA(new Position(model.getCannonPos.getX, model.getCannonPos.getY))
}
