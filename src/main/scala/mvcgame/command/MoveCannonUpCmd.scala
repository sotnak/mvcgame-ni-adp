package cz.cvut.fit.niadp
package mvcgame.command

import mvcgame.model.IGameModel

import cz.cvut.fit.niadp.mvcgame.memento.CareTaker

class MoveCannonUpCmd extends AbstractGameCommand {
  override protected def execute(): Unit = {
    CareTaker.getModel.moveCannonUp()
  }
}
