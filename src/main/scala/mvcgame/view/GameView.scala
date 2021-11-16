package cz.cvut.fit.niadp
package mvcgame.view

import mvcgame.model.IGameModel

import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.observer.Observer
import cz.cvut.fit.niadp.mvcgame.visitor.GameRenderer
import scalafx.scene.canvas.GraphicsContext

class GameView(private val model: IGameModel) extends Observer{

  model.registerObserver(this)
  private var updateCnt : Int = 1
  private val gameRenderer: GameRenderer = new GameRenderer
  private var gc: GraphicsContext = _

  def setGraphicsContext(gc: GraphicsContext): Unit={
    this.gc = gc
    gameRenderer.setGraphicsContext(gc)
  }

  def render(): Unit = {

    if(updateCnt > 0) {
      this.gc.clearRect(0, 0, MvcGameConfig.MAX_X, MvcGameConfig.MAX_Y);

      for(go <- this.model.getGameObjects){
        go.acceptVisitor(gameRenderer)
      }

      this.updateCnt=0
    }

  }

  override def update(): Unit = {
    updateCnt+=1
  }
}
