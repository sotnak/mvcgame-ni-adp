package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.model.Position
import mvcgame.model.gameObjects.AbsCollision

class CollisionA(p: Position = new Position(0,0)) extends AbsCollision {
  this.position = p
}
