package cz.cvut.fit.niadp
package mvcgame.strategy

import mvcgame.model.gameObjects.AbsMissile

trait IMovingStrategy {
  def updatePosition(missile: AbsMissile): Unit
}
