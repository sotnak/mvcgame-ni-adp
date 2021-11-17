package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

abstract class AbsEnemy(val variant: Int) extends GameObject {
  def destroy(): AbsCollision
}
