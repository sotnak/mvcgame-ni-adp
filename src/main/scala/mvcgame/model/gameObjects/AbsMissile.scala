package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

abstract class AbsMissile(val initAngle: Double, val initVelocity: Int) extends GameObject with LifetimeLimited {

  def move():Unit
}
