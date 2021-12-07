package cz.cvut.fit.niadp
package TestSuites

import mvcgame.bridge.IGameGraphics
import mvcgame.model.Position
import mvcgame.model.gameObjects._
import mvcgame.visitor.GameRenderer

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.{times, verify, when}
import org.scalatest.Suite
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.mockito.MockitoSugar.mock

import scala.collection.mutable.ListBuffer

class VisitorTest extends AnyFlatSpec with Suite {

  def test(): Unit = {
    val visitor = new GameRenderer
    val gc = mock[IGameGraphics]
    visitor.setGraphicsContext(gc)

    val buffer = ListBuffer.empty[GameObject]

    val missile = mock[AbsMissile]
    when(missile.acceptVisitor(visitor)).thenCallRealMethod()

    val enemy = mock[AbsEnemy]
    when(enemy.acceptVisitor(visitor)).thenCallRealMethod()
    when(enemy.variant).thenReturn(1)

    val cannon = mock[AbsCannon]
    when(cannon.acceptVisitor(visitor)).thenCallRealMethod()

    val collision = mock[AbsCollision]
    when(collision.acceptVisitor(visitor)).thenCallRealMethod()

    val gameInfo = mock[GameInfo]
    when(gameInfo.acceptVisitor(visitor)).thenCallRealMethod()


    buffer += missile
    buffer += enemy
    buffer += cannon
    buffer += collision
    buffer += gameInfo

    for(go <- buffer){
      go.acceptVisitor(visitor)
    }

    verify(gc, times(4)).drawImage(any[String],any[Position])
    verify(gc, times(1)).drawText(any[String],any[Position])
  }
}
