package cz.cvut.fit.niadp
package mvcgame.memento

import mvcgame.model.IGameModel

object CareTaker {
  private var model: IGameModel = _

  def setModel(gameModel: IGameModel): Unit = this.model = gameModel
  def getModel: IGameModel = model
  def createMemento(): Any = model.createMemento()
  def setMemento(memento: Any): Unit = model.setMemento(memento)
}
