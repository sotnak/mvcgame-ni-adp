package cz.cvut.fit.niadp
package mvcgame.iterator

import scala.collection.AbstractSeq

trait IAggregate {
  def createIterator[A <: Any](seq: AbstractSeq[A]): IIterator[A]
}
