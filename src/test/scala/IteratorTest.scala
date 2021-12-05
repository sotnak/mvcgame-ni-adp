package cz.cvut.fit.niadp

import cz.cvut.fit.niadp.mvcgame.iterator.ConcreteIterator
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCannon, AbsEnemy, AbsMissile, GameObject}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatestplus.mockito.MockitoSugar.mock

import scala.collection.mutable.ListBuffer

class IteratorTest extends AnyFlatSpec with should.Matchers {

  it should "iterate through list of GameObjects" in {
    val listBuffer: ListBuffer[GameObject] = ListBuffer.empty
    listBuffer += mock[AbsCannon]
    listBuffer += mock[AbsMissile]
    listBuffer += mock[AbsEnemy]

    val iterator = new ConcreteIterator[GameObject](listBuffer)

    iterator.next shouldBe a [AbsCannon]
    iterator.next shouldBe a [AbsMissile]
    iterator.next shouldBe a [AbsEnemy]
    iterator.hasNext should be (false)
  }
}
