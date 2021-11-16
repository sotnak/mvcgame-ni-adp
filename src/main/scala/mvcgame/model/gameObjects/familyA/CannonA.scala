package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.config.MvcGameConfig
import mvcgame.model.gameObjects.{AbsCannon, AbsMissile}
import mvcgame.model.{Position, Vector}

import cz.cvut.fit.niadp.mvcgame.abstractFactory.IGameObjectsFactory
import cz.cvut.fit.niadp.mvcgame.state.{DoubleShootingMode, IShootingMode, SingleShootingMode}

import scala.collection.mutable.ArrayBuffer

class CannonA(p: Position = new Position(0,0), val goFactory: IGameObjectsFactory) extends AbsCannon {

  this.position=p

  var power: Int = MvcGameConfig.INIT_POWER
  var angle: Double = MvcGameConfig.INIT_ANGLE

  val shootingBatch: ArrayBuffer[AbsMissile] = ArrayBuffer.empty[AbsMissile]

  def moveUp(): Unit = move(Vector(0,- MvcGameConfig.MOVE_STEP))

  def moveDown(): Unit = move(Vector(0,MvcGameConfig.MOVE_STEP))

  override def shoot(): ArrayBuffer[AbsMissile] = {
    shootingBatch.clear()

    shootingMode.shoot(this)

    return shootingBatch
  }

  override def primitiveShoot(): Unit = shootingBatch += this.goFactory.createMissile(angle, power)

  override def aimUp(): Unit = angle += MvcGameConfig.ANGLE_STEP

  override def aimDown(): Unit = angle -= MvcGameConfig.ANGLE_STEP

  override def powerUp(): Unit = power += MvcGameConfig.POWER_STEP

  override def powerDown(): Unit = power -= MvcGameConfig.POWER_STEP
}
