package cz.cvut.fit.niadp

import cz.cvut.fit.niadp.mvcgame.MvcGame
import cz.cvut.fit.niadp.mvcgame.bridge.{GameGraphics, IGameGraphics, ScalaFxGraphics}

import scala.collection.mutable.ArrayBuffer
import scalafx.Includes._
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.{Group, Scene}
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.input.KeyEvent

object MvcGameScalaFxLauncher extends JFXApp3{

  private val theMvcGame = new MvcGame()

  def start(): Unit = {
    val winTitle = theMvcGame.getWindowTitle
    val winWidth = theMvcGame.getWindowWidth
    val winHeight = theMvcGame.getWindowHeight

    val root = new Group()
    val theScene = new Scene(root)

    val canvas = new Canvas(winWidth, winHeight)
    root.getChildren.add(canvas)

    val gc: GraphicsContext = canvas.getGraphicsContext2D
    //theMvcGame.setGraphicsContext(gc)

    val gr: IGameGraphics = GameGraphics(ScalaFxGraphics(gc))
    theMvcGame.setGraphicsContext(gr)

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
      //gc.clearRect(0, 0, winWidth, winHeight);
      theMvcGame.processPressedKeys(pressedKeysCodes)
      theMvcGame.update()
      theMvcGame.render()
    }).start()

    stage = new PrimaryStage{
      title = winTitle
      scene = theScene
    }
  }
}
