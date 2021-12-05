package cz.cvut.fit.niadp

import cz.cvut.fit.niadp.mvcgame.command.{AimUpCmd, MoveCannonUpCmd, PowerUpCmd}
import cz.cvut.fit.niadp.mvcgame.config.MvcGameConfig
import cz.cvut.fit.niadp.mvcgame.memento.CareTaker
import cz.cvut.fit.niadp.mvcgame.model.{GameModel, Position}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class DoUndoTest extends AnyFlatSpec with should.Matchers {
  it should "do and undo commands" in {
    val model = new GameModel
    CareTaker.setModel(model)

    val defaultCannonPosition = new Position(model.getCannonPos.getX, model.getCannonPos.getY)
    val defaultCannonPower = model.getCannonPower
    val defaultCannonAngle = model.getCannonAngle

    model.registerCommand(MoveCannonUpCmd(model))
    model.registerCommand(PowerUpCmd(model))
    model.registerCommand(AimUpCmd(model))

    model.executeCmds()

    model.getCannonAngle should be (defaultCannonAngle + MvcGameConfig.ANGLE_STEP)
    model.getCannonPower should be (defaultCannonPower + MvcGameConfig.POWER_STEP)
    model.getCannonPos.getX should be (defaultCannonPosition.getX)
    model.getCannonPos.getY should be (defaultCannonPosition.getY - MvcGameConfig.MOVE_STEP)

    model.undoLastCommand()
    model.getCannonAngle should be (defaultCannonAngle)

    model.undoLastCommand()
    model.getCannonPower should be (defaultCannonPower)

    model.undoLastCommand()
    model.getCannonPos.getX should be (defaultCannonPosition.getX)
    model.getCannonPos.getY should be (defaultCannonPosition.getY)
  }
}
