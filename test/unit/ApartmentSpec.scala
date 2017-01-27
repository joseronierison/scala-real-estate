package unit
import org.scalatest.{BeforeAndAfter, FunSpec}
import domain.Apartment

class ApartmentSpec extends FunSpec with BeforeAndAfter {

  def createApartment(amount: Int): Unit = {
    var index = 0
    for(index <- 0 until amount) {
      Apartment.create(Apartment(
        id = index,
        address = "Almirante dias Fenrnades",
        neighbourhood = "Prazeres",
        zipcode = 54310600
      ))
    }
  }

  def before(callback: String => String) :Unit = {
    callback("ola")
  }


  describe("Apartment") {
    before {
      Apartment.reset()
    }

    describe("#create") {
      it("add an apartment") {
        Apartment.create(Apartment(
          id = 1,
          address = "Almirante dias Fenrnades",
          neighbourhood = "Prazeres",
          zipcode = 54310600
        ))
        assert(Apartment.all().size == 1)
      }
    }

    describe("#reset") {
      it("clears all apartments") {
        createApartment(10)
        Apartment.reset()
        assert(Apartment.all().isEmpty)
      }
    }

    describe("#all") {
      it("returns all apartments") {
        val apartmentAmount = 10
        createApartment(apartmentAmount)
        assert(Apartment.all().size == apartmentAmount)
      }
    }
  }
}
