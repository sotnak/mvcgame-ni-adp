package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.model.Position
import mvcgame.model.gameObjects.AbsMissile

import cz.cvut.fit.niadp.mvcgame.strategy.IMovingStrategy

class MissileA(initPosition: Position = new Position(0,0), initAngle: Double, initVelocity: Int, val movingStrategy: IMovingStrategy) extends AbsMissile(initAngle, initVelocity){

  this.position=initPosition

  override def move(): Unit = this.movingStrategy.updatePosition(this)
}
