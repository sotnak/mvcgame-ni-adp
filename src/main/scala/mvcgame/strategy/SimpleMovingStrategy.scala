package cz.cvut.fit.niadp
package mvcgame.strategy
import mvcgame.model.gameObjects.AbsMissile
import mvcgame.model.Vector

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig

case class SimpleMovingStrategy() extends IMovingStrategy {
  override def updatePosition(missile: AbsMissile): Unit = missile.move(Vector(MvcGameConfig.MOVE_STEP,0))
}
