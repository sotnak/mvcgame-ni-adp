package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.model.Position
import mvcgame.model.gameObjects.AbsEnemy

class EnemyA(p: Position = new Position(0,0)) extends AbsEnemy {
  this.position = p
}
