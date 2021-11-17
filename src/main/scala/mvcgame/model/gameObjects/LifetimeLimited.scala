package cz.cvut.fit.niadp
package mvcgame.model.gameObjects

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

trait LifetimeLimited{
  val bornAt: LocalDateTime = LocalDateTime.now()

  def getAge: Long = ChronoUnit.SECONDS.between(bornAt, LocalDateTime.now())
}
