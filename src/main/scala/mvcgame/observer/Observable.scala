package cz.cvut.fit.niadp
package mvcgame.observer

trait Observable {
  protected var observers = List.empty[Observer]

  def registerObserver(observer: Observer): Unit = {
    if(!observers.contains(observer)) {
      observers = observers.appended(observer)
    }
  }

  def unregisterObserver(observer: Observer): Unit = {
    if(observers.contains(observer))
      observers = observers.filter( (o:Observer) => o != observer)
  }

  def notifyObservers():Unit = {
    observers.foreach( (o:Observer) =>{
      o.update()
    })
  }
}
