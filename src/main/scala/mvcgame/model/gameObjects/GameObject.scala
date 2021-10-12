package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

import mvcgame.model.Position
import mvcgame.model.Vector

trait GameObject {
  var position:Position = new Position()
  def move(v : Vector): Unit = this.position.add(v)
  def getPosition:Position = this.position
}
