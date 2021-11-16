package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

import cz.cvut.fit.niadp.mvcgame.state.{DoubleShootingMode, IShootingMode, SingleShootingMode}

import scala.collection.mutable.ArrayBuffer

abstract class AbsCannon extends GameObject {
  def moveUp(): Unit
  def moveDown(): Unit
  def aimUp(): Unit
  def aimDown(): Unit
  def powerUp(): Unit
  def powerDown(): Unit
  def shoot(): ArrayBuffer[AbsMissile]
  def primitiveShoot(): Unit

  var shootingMode: IShootingMode = SingleShootingMode()

  def toggleShootingMode(): Unit = {
    shootingMode match{
      case _: SingleShootingMode => shootingMode = DoubleShootingMode()
      case _: DoubleShootingMode => shootingMode = SingleShootingMode()
    }
  }
}
