package cz.cvut.fit.niadp

import cz.cvut.fit.niadp.mvcgame.bridge.IGameGraphics
import cz.cvut.fit.niadp.mvcgame.model.gameObjects.{AbsCannon, AbsCollision, AbsEnemy, AbsMissile, GameInfo, GameObject}
import cz.cvut.fit.niadp.mvcgame.visitor.GameRenderer
import org.mockito.Mockito.{times, verify}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.mockito.MockitoSugar.mock

import scala.collection.mutable.ListBuffer

class VisitorTest extends AnyFlatSpec{
  it should "" in {
    val visitor = new GameRenderer
    val gc = mock[IGameGraphics]
    val buffer = ListBuffer.empty[GameObject]

    buffer += mock[AbsMissile]
    buffer += mock[AbsEnemy]
    buffer += mock[AbsCannon]
    buffer += mock[AbsCollision]
    buffer += mock[GameInfo]

    for(go <- buffer){
      go.acceptVisitor(visitor)
    }

    verify(gc, times(4)).drawImage(_:String,_)
    verify(gc, times(1)).drawText(_:String,_)
  }
}
