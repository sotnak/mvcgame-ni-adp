package cz.cvut.fit.niadp
package mvcgame.state
import mvcgame.model.gameObjects.AbsCannon

case class SingleShootingMode() extends IShootingMode {
  override def getName: String = "SingleShootingMode"

  override def shoot(cannon: AbsCannon): Unit = cannon.primitiveShoot()
}
