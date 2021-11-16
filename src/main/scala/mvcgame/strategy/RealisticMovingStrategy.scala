package cz.cvut.fit.niadp
package mvcgame.strategy
import mvcgame.model.gameObjects.AbsMissile
import mvcgame.model.Vector

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig

case class RealisticMovingStrategy() extends IMovingStrategy {
  override def updatePosition(missile: AbsMissile): Unit = {

    val velocity = missile.initVelocity
    val angle = missile.initAngle
    val age = missile.getAge

    val dx: Int = ( velocity * age * Math.cos(angle) ).toInt
    val dy: Int = ( velocity * age * Math.sin(angle) - ( 0.5 * MvcGameConfig.GRAVITY * age * age ) ).toInt

    missile.move(Vector(dx,dy))
  }
}
