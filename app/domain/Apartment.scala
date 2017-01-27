package domain
import scala.collection.mutable.ListBuffer


case class Apartment(id: Int, address: String, neighbourhood: String, zipcode: Int)

object Apartment {
  var apartments: ListBuffer[Apartment] = new ListBuffer[Apartment]()

  def reset(): Unit = {
    apartments.clear()
  }

  def create(apartment: Apartment): Unit =
    apartments += apartment

  def all() :ListBuffer[Apartment] =
    apartments

  def find(id: Int): Option[Apartment] =
    all().find(apt => apt.id == id)

}