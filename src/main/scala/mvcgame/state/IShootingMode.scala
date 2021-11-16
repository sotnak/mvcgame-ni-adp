package cz.cvut.fit.niadp
package mvcgame.state

import mvcgame.model.gameObjects.AbsCannon

trait IShootingMode {
  def getName: String

  def shoot(cannon: AbsCannon): Unit
}
