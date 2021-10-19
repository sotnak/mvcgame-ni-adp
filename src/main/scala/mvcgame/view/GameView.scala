package cz.cvut.fit.niadp
package mvcgame.view

import mvcgame.controller.GameController
import mvcgame.model.GameModel

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.observer.Observer
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

case class GameView(private val model: GameModel) extends Observer{

  model.registerObserver(this)
  var updateCnt : Int = 1

  def render(gr: GraphicsContext): Unit = {
    if(updateCnt > 0) {
      gr.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);

      drawCannon(gr)
      drawEnemies(gr)
      drawCollisions(gr)
      drawMissiles(gr)

      updateCnt=0
    }
  }

  def drawCannon(gr: GraphicsContext) : Unit ={
    val cannonPos = model.getCannonPos
    gr.drawImage(new Image("images/cannon.png"), cannonPos.getX, cannonPos.getY)
  }

  def drawEnemies(gr: GraphicsContext): Unit ={
    for(enemy <- model.enemies){
      val enemyPos = enemy.position
      gr.drawImage(new Image("images/enemy1.png"), enemyPos.getX, enemyPos.getY)
    }
  }

  def drawMissiles(gr: GraphicsContext): Unit ={
    for(missile <- model.missiles){
      val missilePos = missile.position
      gr.drawImage(new Image("images/missile.png"), missilePos.getX, missilePos.getY)
    }
  }

  def drawCollisions(gr: GraphicsContext): Unit ={
    for(collision <- model.collisions){
      val collisionPos = collision.position
      gr.drawImage(new Image("images/collision.png"), collisionPos.getX, collisionPos.getY)
    }
  }

  override def update(): Unit = {
    updateCnt+=1
  }
}
