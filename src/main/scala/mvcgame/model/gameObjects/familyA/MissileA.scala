package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.model.Position
import mvcgame.model.gameObjects.{AbsMissile, GameObject}

class MissileA(p: Position = new Position(0,0)) extends AbsMissile{
  this.position=p
}
