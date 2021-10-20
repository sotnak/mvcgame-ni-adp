package cz.cvut.fit.niadp
package mvcgame.visitor

import mvcgame.model.gameObjects.{AbsCannon, AbsMissile}

trait IVisitor {
  def visitCannon(cannon: AbsCannon): Unit
  def visitMissile(missile: AbsMissile): Unit

  //jen def visit ??? rozpoznavani class
}
