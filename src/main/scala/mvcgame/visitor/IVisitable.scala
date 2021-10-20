package cz.cvut.fit.niadp
package mvcgame.visitor

trait IVisitable {
  def acceptVisitor(visitor: IVisitor): Unit
}
