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
  val INIT_ANGLE: Double = 0

  val POWER_STEP: Int = 1
  val ANGLE_STEP: Double = Math.PI/18

  val ENEMY_X_OFFSET: Int = 150
  val ENEMY_Y_OFFSET: Int = 30

  val ENEMY_MAX_X: Int = MAX_X - 30
  val ENEMY_MAX_Y: Int = MAX_Y - 30

  val ENEMIES_SPAWNED: Int = 3

  val ENEMY_HIT_SIZE: Int = 50

  val COLLISION_LIFESPAN: Int = 1
}
