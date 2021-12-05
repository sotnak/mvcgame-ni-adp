package cz.cvut.fit.niadp
package mvcgame.view

import mvcgame.model.{IGameModel, Position}

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.GameObject

case class GameInfo(model: IGameModel) extends GameObject{

  position = new Position(10,10)

  def getText: String ={
    val score = model.getScore
    val movingStrategy = model.getMovingStrategy.getClass.getSimpleName
    val power = model.getCannonPower
    var angle = -(180 * model.getCannonAngle / math.Pi) % 360

    if(angle<0)
      angle += 360

    "score: " + score + ", moving strategy: " + movingStrategy + ", power: " + power + ", angle: " + angle
  }
}
