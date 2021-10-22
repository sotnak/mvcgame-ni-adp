package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

abstract class AbsCannon extends GameObject {
  def moveUp(): Unit
  def moveDown(): Unit
  def shoot(): AbsMissile
}
