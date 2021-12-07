package cz.cvut.fit.niadp
package TestSuites

import mvcgame.iterator.ConcreteIterator
import mvcgame.model.gameObjects.{AbsCannon, AbsEnemy, AbsMissile, GameObject}

import org.scalatest.Suite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatestplus.mockito.MockitoSugar.mock

import scala.collection.mutable.ListBuffer

class IteratorTest extends AnyFlatSpec with should.Matchers with Suite {

  def test(): Unit = {
    val listBuffer: ListBuffer[GameObject] = ListBuffer.empty
    listBuffer += mock[AbsCannon]
    listBuffer += mock[AbsMissile]
    listBuffer += mock[AbsEnemy]

    val iterator = new ConcreteIterator[GameObject](listBuffer)

    iterator.next shouldBe a [AbsCannon]
    iterator.next shouldBe a [AbsMissile]
    iterator.next shouldBe a [AbsEnemy]

    iterator.hasNext should be (false)
    an [IndexOutOfBoundsException] should be thrownBy(iterator.next)
  }
}
