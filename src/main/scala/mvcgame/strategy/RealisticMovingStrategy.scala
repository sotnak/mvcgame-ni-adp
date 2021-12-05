package cz.cvut.fit.niadp
package mvcgame.strategy
import mvcgame.model.gameObjects.AbsMissile
import mvcgame.model.Vector

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig

case class RealisticMovingStrategy() extends IMovingStrategy {

  def nextPosition(velocity: Int, angle: Double, age: Long): Vector = {
    val angleOffset = math.Pi * 1.85

    val dx: Int = ( velocity * age * math.cos(angle + angleOffset) ).toInt
    val dy: Int = (  ( velocity * age * math.sin(angle + angleOffset) ) + ( 0.5 * MvcGameConfig.GRAVITY * age * age ) ).toInt

    Vector(dx,dy)
  }

  override def updatePosition(missile: AbsMissile): Unit = {

    val velocity = missile.initVelocity
    val angle = missile.initAngle
    val age = missile.getAge

    missile.move(nextPosition(velocity,angle,age))
  }
}
