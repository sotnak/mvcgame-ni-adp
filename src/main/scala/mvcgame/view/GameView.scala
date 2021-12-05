package cz.cvut.fit.niadp
package mvcgame.view

import mvcgame.model.IGameModel

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics
import cz.cvut.fit.niadp.mvcgame.observer.Observer
import cz.cvut.fit.niadp.mvcgame.visitor.GameRenderer

class GameView(private val model: IGameModel) extends Observer{

  model.registerObserver(this)
  private var updateCnt : Int = 1
  private val gameRenderer: GameRenderer = new GameRenderer
  private var gc: IGameGraphics = _
  private val gameInfo: GameInfo = GameInfo(model)

  def setGraphicsContext(gc: IGameGraphics): Unit={
    this.gc = gc
    gameRenderer.setGraphicsContext(gc)
  }

  def render(): Unit = {

    if(updateCnt > 0) {
      this.gc.clear()

      val iterator = model.getGameObjectsIterator

      while (iterator.hasNext){
        iterator.next.acceptVisitor(gameRenderer)
      }

      this.updateCnt=0
    }

  }

  override def update(): Unit = {
    updateCnt+=1
  }
}
