package cz.cvut.fit.niadp
package mvcgame.command

import mvcgame.model.IGameModel

case class MoveCannonUpCmd(override val model: IGameModel) extends AbstractGameCommand(model) {
  override protected def execute(): Unit = {
    model.moveCannonUp()
  }
}
