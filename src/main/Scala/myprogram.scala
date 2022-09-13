import scalafx.scene.Scene
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.text.Font.font
import scalafx.scene.text.{Font, Text}
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.shape.{MoveTo, LineTo, Path}
import scalafx.animation.FadeTransition
import scalafx.Includes._ //import all the autoconvert function
import scalafx.util.Duration
import scalafx.scene.image.{Image, ImageView}

object myprogram extends JFXApp{
  stage = new PrimaryStage(){
    title = "My First Window"
//  title = ("My First Window)"
    height = 500
    width = 500
    fullScreen = false
    scene = new Scene() {
      val font1 = new Font("Arial", 50)
      val ft = new FadeTransition(new Duration(500)){
        fromValue = 1.0
        toValue = 0.0
        autoReverse = true
        cycleCount = FadeTransition.Indefinite
      }
      val image = new Image(getClass.getResourceAsStream("cat.jpg"))
      content = List(new Text(50,50, "My First UI Window") {
        font = font1
        effect = new DropShadow(4.0, 3, -3, Color.Blue)
        }, new Text(80,120, "My second word") {
          font = font1
          fill = Color.rgb(50, 30, 40, 0.5)
        }, new Rectangle() {
          x = 60
          y = 60
          width = 60
          height = 60 
          fill = Color.rgb(20, 30, 40, 0.5)
        }, new Path(){
          elements = List(
            MoveTo(10, 30),
            LineTo(10, 80),
            LineTo(60, 80),
            LineTo(10, 30)
          )
          fill = Color.Blue
        }, new ImageView(image)
      )
      // node initialized here
      ft.node = content(0)
      ft.node = content(1)
      ft.node = content(2)
      ft.play()
    }
  }
}