package cz.cvut.fit.niadp
package mvcgame.abstractFactory

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCannon, AbsMissile}

trait IGameObjectsFactory {
  def createCannon(): AbsCannon
  def CreateMissile(): AbsMissile
}
