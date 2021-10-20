package cz.cvut.fit.niadp
package mvcgame


import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.controller.GameController
import cz.cvut.fit.niadp.mvcgame.model.{GameModel, Position}
import cz.cvut.fit.niadp.mvcgame.view.GameView
import scalafx.application.Platform
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

import scala.collection.mutable.ArrayBuffer


class MvcGame {

  private val model = GameModel();
  private val controller = GameController(model);
  private val view = GameView(model);

  def processPressedKeys(pressedKeysCodes: ArrayBuffer[String]): Unit = {
    this.controller.processPressedKeys(pressedKeysCodes)
  }

  def update(): Unit = {
    this.model.destroyMissiles()
    this.model.moveMissiles()
  }

  def render(): Unit = {
    this.view.render()
  }

  def getWindowTitle = "The NI-ADP.16 MvcGame"

  def getWindowWidth: Int = MvcGameConfig.MAX_X

  def getWindowHeight: Int = MvcGameConfig.MAX_Y

  def setGraphicsContext(gc: GraphicsContext): Unit = {
    this.view.setGraphicsContext(gc)
  }
}
