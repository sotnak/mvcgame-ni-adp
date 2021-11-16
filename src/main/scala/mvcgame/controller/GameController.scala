package cz.cvut.fit.niadp
package mvcgame.controller

import cz.cvut.fit.niadp.mvcgame.model.IGameModel
import scalafx.application.Platform
import scala.collection.mutable.ArrayBuffer

class GameController(private val model: IGameModel) {

  def processPressedKeys(pressedKeysCodes: ArrayBuffer[String]): Unit = {

    for (code <- pressedKeysCodes) {
      code match {
        case "UP" =>
          this.model.moveCannonUp()

        case "DOWN" =>
          this.model.moveCannonDown()

        case "SPACE" =>
          this.model.cannonShoot()

        case "A" =>
          this.model.aimCannonUp()

        case "D" =>
          this.model.aimCannonDown()

        case "W" =>
          this.model.cannonPowerUp()

        case "S" =>
          this.model.cannonPowerDown()

        case "R" =>
          this.model.toggleMovingStrategy()

        case "T" =>
          this.model.toggleShootingMode()

        case "ESCAPE" =>
          Platform.exit()
          System.exit(0)

        case _ =>
        //nothing
      }
    }
  }
}
