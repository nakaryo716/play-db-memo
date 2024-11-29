package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.db.Database
import play.db.NamedDatabase

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}


@Singleton
class A @Inject()(val controllerComponents: ControllerComponents, @NamedDatabase("default")db: Database) extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    var data = "";

    val con = db.getConnection()
    println(db.name)
    val stmt = con.createStatement()
    val rs = stmt.executeQuery("select name from sample where id = 16")

    if (rs.next()) {
      data += rs.getString("name")
    }
    
    con.close()
    Ok(data.toString)
  }
}
