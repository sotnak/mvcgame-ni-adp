package cz.cvut.fit.niadp
package mvcgame.controller

import cz.cvut.fit.niadp.mvcgame.model.IGameModel
import scalafx.application.Platform

import scala.collection.mutable.ArrayBuffer
import cz.cvut.fit.niadp.mvcgame.command.{MoveCannonDownCmd, MoveCannonUpCmd}

class GameController(private val model: IGameModel) {

  private val prevPressed: ArrayBuffer[String] = ArrayBuffer.empty[String]

  def justPressed(keyCode: String, callback: ()=>Unit):Unit = {
    if( !prevPressed.contains(keyCode) )
      callback()
  }

  def processPressedKeys(pressedKeysCodes: ArrayBuffer[String]): Unit = {

    for (code <- pressedKeysCodes) {
      code match {
        case "UP" =>
          model.registerCommand(new MoveCannonUpCmd)

        case "DOWN" =>
          model.registerCommand(new MoveCannonDownCmd)

        case "SPACE" =>
          justPressed("SPACE", model.cannonShoot )

        case "A" =>
          justPressed("A", model.aimCannonUp )

        case "D" =>
          justPressed("D", model.aimCannonDown )

        case "W" =>
          justPressed("W", model.cannonPowerUp )

        case "S" =>
          justPressed("S", model.cannonPowerDown )

        case "R" =>
          justPressed("R", model.toggleMovingStrategy )

        case "T" =>
          justPressed("T", model.toggleShootingMode )

        case "Z" =>
          justPressed("Z", model.undoLastCommand )


        case "ESCAPE" =>
          Platform.exit()
          System.exit(0)

        case _ =>
        //nothing
      }
    }

    prevPressed.clear()
    prevPressed ++= pressedKeysCodes
  }
}
