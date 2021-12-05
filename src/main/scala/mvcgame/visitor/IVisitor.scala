package cz.cvut.fit.niadp
package mvcgame.visitor

trait IVisitor {

  def visit(visitable: IVisitable): Unit
}
