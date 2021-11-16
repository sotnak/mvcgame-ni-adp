package cz.cvut.fit.niadp
package mvcgame.config

object MvcGameConfig {
  val MAX_X: Int = 1280
  val MAX_Y: Int = 720

  val MOVE_STEP: Int = 10

  val CANNON_POSX: Int = 50
  val CANNON_POSY: Int = MAX_Y/2

  val TIME_TICK_PERIOD: Long = 1000

  val GRAVITY: Double = 9.8

  val INIT_POWER: Int = 10
  val INIT_ANGLE: Double = Math.PI/18

  val POWER_STEP: Int = 10
  val ANGLE_STEP: Double = 0.2
}
