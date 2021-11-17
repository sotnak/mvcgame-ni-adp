package cz.cvut.fit.niadp
package mvcgame.command

import mvcgame.model.IGameModel

abstract class AbstractGameCommand(val model: IGameModel) {

  var memento: Any = _

  protected def execute()

  def doExecute(): Unit ={
    memento = model.createMemento()
    execute()
  }

  def unExecute(): Unit={
    model.setMemento(memento)
  }
}
