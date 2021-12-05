package cz.cvut.fit.niadp
package mvcgame.iterator

trait IIterator[A <: Any] {
  def hasNext: Boolean
  def next: A
}
