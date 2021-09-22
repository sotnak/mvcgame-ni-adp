package cz.cvut.fit.niadp

import cz.cvut.fit.niadp.mvcgame.MvcGame

import scala.collection.mutable.ArrayBuffer
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.{Group, Scene}
import scalafx.scene.canvas.Canvas
import scalafx.scene.input.KeyEvent

object MvcGameScalaFxLauncher extends JFXApp3{

  private val theMvcGame = new MvcGame()
  theMvcGame.init()

  def start(): Unit = {
    val winTitle = theMvcGame.getWindowTitle
    val winWidth = theMvcGame.getWindowWidth
    val winHeigth = theMvcGame.getWindowHeight

    val root = new Group()
    val theScene = new Scene(root)

    val canvas = new Canvas(winWidth, winHeigth)
    root.getChildren.add(canvas)

    val gc = canvas.getGraphicsContext2D

    val pressedKeysCodes = ArrayBuffer.empty[String]

    theScene.setOnKeyPressed((e: KeyEvent) => {
      val code = e.getCode.toString
      // only add once... prevent duplicates
      if (!pressedKeysCodes.contains(code)) pressedKeysCodes.addOne(code)
    })

    theScene.setOnKeyReleased((e: KeyEvent) => {
      val code = e.getCode.toString
      pressedKeysCodes -= code
    })

    // the game-loop
    AnimationTimer (currentNanoTime => {
        // Clear the canvas
        // gc.clearRect(0, 0, winWidth, winHeigth);
        theMvcGame.processPressedKeys(pressedKeysCodes)
        theMvcGame.update()
        theMvcGame.render(gc)
      }).start()

    stage = new PrimaryStage{
      title = winTitle
      scene = theScene
    }
  }
}
