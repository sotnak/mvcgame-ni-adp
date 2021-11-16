package cz.cvut.fit.niadp
package mvcgame.state
import mvcgame.model.gameObjects.AbsCannon

case class DoubleShootingMode() extends IShootingMode {
  override def getName: String = "DoubleShootingMode"

  override def shoot(cannon: AbsCannon): Unit = {
    cannon.aimUp()
    cannon.primitiveShoot()
    cannon.aimDown()
    cannon.aimDown()
    cannon.primitiveShoot()
    cannon.aimUp()
  }
}
