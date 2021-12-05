package cz.cvut.fit.niadp
package mvcgame.command

import cz.cvut.fit.niadp.mvcgame.memento.CareTaker

abstract class AbstractGameCommand {

  var memento: Any = _

  protected def execute()

  def doExecute(): Unit ={
    memento = CareTaker.createMemento()
    execute()
  }

  def unExecute(): Unit={
    CareTaker.setMemento(memento)
  }
}
