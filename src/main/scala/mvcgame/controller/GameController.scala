package cz.cvut.fit.niadp
package mvcgame.controller

import cz.cvut.fit.niadp.mvcgame.model.GameModel
import scalafx.application.Platform

import scala.collection.mutable.ArrayBuffer

case class GameController(private val model: GameModel) {

  def processPressedKeys(pressedKeysCodes: ArrayBuffer[String]): Unit = {

    for (code <- pressedKeysCodes) {
      code match {
        case "UP" =>
          this.model.moveCannonUp()

        case "DOWN" =>
          this.model.moveCannonDown()

        case "SPACE" =>
          this.model.cannonShoot()

        case "ESCAPE" =>
          Platform.exit()
          System.exit(0)

        case _ =>
        //nothing
      }
    }
  }
}
