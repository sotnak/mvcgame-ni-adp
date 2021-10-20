package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

import mvcgame.model.Position
import mvcgame.model.Vector

import cz.cvut.fit.niadp.mvcgame.visitor.IVisitable

trait GameObject extends IVisitable{
  var position:Position = new Position()
  def move(v : Vector): Unit = this.position.add(v)
  def getPosition:Position = this.position
}
