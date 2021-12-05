package cz.cvut.fit.niadp

import cz.cvut.fit.niadp.mvcgame.model.gameObjects.AbsCannon
import cz.cvut.fit.niadp.mvcgame.state.{DoubleShootingMode, SingleShootingMode}
import org.mockito.Mockito.{times, verify}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.mockito.MockitoSugar.mock

class StateTest extends AnyFlatSpec {
  it should "match projectile count to shooting mode" in {
    val cannon = mock[AbsCannon]

    val doubleShooting = DoubleShootingMode()
    val singleShooting = SingleShootingMode()

    doubleShooting.shoot(cannon)
    verify(cannon,times(2)).primitiveShoot()

    singleShooting.shoot(cannon)
    verify(cannon,times(3)).primitiveShoot()
  }
}
