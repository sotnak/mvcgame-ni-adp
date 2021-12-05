package cz.cvut.fit.niadp
package mvcgame.iterator

import scala.collection.AbstractSeq

case class ConcreteIterator[A <: Any](val seq: AbstractSeq[A]) extends IIterator[A] {
  private var index: Int = -1

  override def hasNext: Boolean = (index + 1 < seq.length)

  override def next: A = {
    index += 1
    seq(index)
  }
}
