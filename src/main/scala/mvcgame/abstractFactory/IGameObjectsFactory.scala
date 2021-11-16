package cz.cvut.fit.niadp
package mvcgame.abstractFactory

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCannon, AbsCollision, AbsEnemy, AbsMissile}

trait IGameObjectsFactory {
  def createCannon(): AbsCannon
  def createMissile(initAngle: Double, initVelocity: Int): AbsMissile
  def createEnemy(): AbsEnemy
  def createCollision(): AbsCollision
}
