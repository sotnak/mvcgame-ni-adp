package cz.cvut.fit.niadp
package mvcgame.command

import mvcgame.model.IGameModel

case class MoveCannonDownCmd(model: IGameModel) extends AbstractGameCommand {
  override protected def execute(): Unit = model.moveCannonDown()
}
