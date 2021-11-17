package cz.cvut.fit.niadp
package mvcgame


import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.controller.GameController
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker
import cz.cvut.fit.niadp.mvcgame.model.GameModel
import cz.cvut.fit.niadp.mvcgame.proxy.GameModelProxy
import cz.cvut.fit.niadp.mvcgame.view.GameView

import scala.collection.mutable.ArrayBuffer


class MvcGame {

  private val model = GameModelProxy(new GameModel)
  private val controller = new GameController(model)
  private val view = new GameView(model)
  CareTaker.setModel(model)

  def processPressedKeys(pressedKeysCodes: ArrayBuffer[String]): Unit = {
    this.controller.processPressedKeys(pressedKeysCodes)
  }

  def update(): Unit = this.model.update()

  def render(): Unit = this.view.render()

  def getWindowTitle = "The NI-ADP.16 MvcGame"

  def getWindowWidth: Int = MvcGameConfig.MAX_X

  def getWindowHeight: Int = MvcGameConfig.MAX_Y

  def setGraphicsContext(gc: IGameGraphics): Unit = {
    this.view.setGraphicsContext(gc)
  }
}
