package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.model.Position
import mvcgame.model.gameObjects.{AbsCollision, LifetimeLimited}

class CollisionA(p: Position) extends AbsCollision {
  this.position = p
}
