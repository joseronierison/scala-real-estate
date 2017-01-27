package controllers

import domain.Apartment
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}


object Apartamento extends Controller {
  def index = Action {
    Ok(toJson(Apartment.all()))
  }

  def show(id: Int) = Action {
    val resource = Apartment.find(id)

    resource match {
      case Some(apt)=> Ok(toJson(apt))
      case _ => NotFound("")
    }
  }

  private def toJson(apt: Any): String = {
    implicit val residentWrites = Json.writes[Apartment]

    apt match {
      case e: Apartment => Json.stringify(Json.toJson(e.asInstanceOf[Apartment]))
      case l: List[Apartment] => Json.stringify(Json.toJson(l.asInstanceOf[List[Apartment]]))
    }
  }
}
