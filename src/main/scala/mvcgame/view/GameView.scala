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
      updateCnt=0
    }
  }

  def drawCannon(gr: GraphicsContext) : Unit ={
    val cannonPos = model.getCannonPos
    gr.drawImage(new Image("images/cannon.png"), cannonPos.getX, cannonPos.getY)
  }

  override def update(): Unit = {
    updateCnt+=1
  }
}
