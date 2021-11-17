package cz.cvut.fit.niadp
package mvcgame.model.gameObjects.familyA

import mvcgame.model.Position
import mvcgame.model.gameObjects.{AbsCollision, AbsEnemy}

import cz.cvut.fit.niadp.mvcgame.abstractFactory.IGameObjectsFactory

class EnemyA(variant:Int, p: Position, val goFactory: IGameObjectsFactory) extends AbsEnemy(variant) {
  this.position = p

  override def destroy(): AbsCollision ={
    goFactory.createCollision(new Position(getPosition.getX, getPosition.getY))
  }
}
