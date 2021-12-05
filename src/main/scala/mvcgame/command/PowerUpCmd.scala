package cz.cvut.fit.niadp
package mvcgame.command

import cz.cvut.fit.niadp.mvcgame.model.IGameModel

case class PowerUpCmd(model: IGameModel) extends AbstractGameCommand {
  override protected def execute(): Unit = model.cannonPowerUp()
}
