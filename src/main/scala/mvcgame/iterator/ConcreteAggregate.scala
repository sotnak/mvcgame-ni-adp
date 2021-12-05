package cz.cvut.fit.niadp
package mvcgame.iterator

import scala.collection.AbstractSeq

case class ConcreteAggregate() extends IAggregate {
  override def createIterator[A <: Any](seq: AbstractSeq[A]): IIterator[A] = {
    ConcreteIterator[A](seq)
  }
}
