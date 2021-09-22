package cz.cvut.fit.niadp
package mvcgame


import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.model.Position
import scalafx.application.Platform
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

import scala.collection.mutable.ArrayBuffer


class MvcGame {

  private var logoPos = new Position

  def init(): Unit = {
    logoPos = new Position(((MvcGameConfig.MAX_X / 2) - 128).asInstanceOf[Int], ((MvcGameConfig.MAX_Y / 2) - 128).asInstanceOf[Int])
  }

  def processPressedKeys(pressedKeysCodes: ArrayBuffer[String]): Unit = {
    for (code <- pressedKeysCodes) {
      code match {
        case "UP" =>
          logoPos.setY(logoPos.getY - 10)

        case "DOWN" =>
          logoPos.setY(logoPos.getY + 10)

        case "LEFT" =>
          logoPos.setX(logoPos.getX - 10)

        case "RIGHT" =>
          logoPos.setX(logoPos.getX + 10)

        case "ESCAPE" =>
          Platform.exit()
          System.exit(0)

        case _ =>
        //nothing
      }
    }
  }

  def update(): Unit = {
    // nothing yet
  }

  def render(gr: GraphicsContext): Unit = {
    gr.drawImage(new Image("icons/fit-icon-256x256.png"), logoPos.getX, logoPos.getY)
  }

  def getWindowTitle = "The NI-ADP.16 MvcGame"

  def getWindowWidth: Int = MvcGameConfig.MAX_X

  def getWindowHeight: Int = MvcGameConfig.MAX_Y
}
