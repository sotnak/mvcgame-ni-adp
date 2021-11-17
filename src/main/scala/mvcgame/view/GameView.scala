package cz.cvut.fit.niadp
package mvcgame.view

import mvcgame.model.{IGameModel, Position}

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics
import cz.cvut.fit.niadp.mvcgame.observer.Observer
import cz.cvut.fit.niadp.mvcgame.visitor.GameRenderer

class GameView(private val model: IGameModel) extends Observer{

  model.registerObserver(this)
  private var updateCnt : Int = 1
  private val gameRenderer: GameRenderer = new GameRenderer
  private var gc: IGameGraphics = _

  def setGraphicsContext(gc: IGameGraphics): Unit={
    this.gc = gc
    gameRenderer.setGraphicsContext(gc)
  }

  def printStats():Unit = {
    val score = model.getScore
    val movingStrategy = model.getMovingStrategy.getClass.getSimpleName

    gc.drawText("score: " + score + ", moving strategy: " + movingStrategy,new Position(10,10))
  }

  def render(): Unit = {

    if(updateCnt > 0) {
      this.gc.clear()

      printStats()

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
