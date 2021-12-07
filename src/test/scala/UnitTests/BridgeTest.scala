package cz.cvut.fit.niadp
package UnitTests

import mvcgame.bridge.{GameGraphics, IGameGraphics, IGameGraphicsImplementor}
import mvcgame.model.Position

import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.{times, verify}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.mockito.MockitoSugar.mock

class BridgeTest extends AnyFlatSpec{

  it should "call methods on implementor" in {
    val implementor: IGameGraphicsImplementor = mock[IGameGraphicsImplementor]
    val graphics: IGameGraphics = GameGraphics(implementor)

    graphics.drawText("",new Position(0,0))
    graphics.drawImage("",new Position(0,0))
    graphics.drawRectangle(new Position(0,0), new Position(1,1))
    graphics.clear()

    verify(implementor, times(1)).drawImage(any[String],any[Position])
    verify(implementor, times(1)).drawText(any[String],any[Position])
    verify(implementor, times(4)).drawLine(any[Position],any[Position])
    verify(implementor, times(1)).clear()
  }
}
