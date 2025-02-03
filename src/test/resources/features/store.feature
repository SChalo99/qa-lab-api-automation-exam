@PetStoreOrder
Feature: Pet Store Orders

  @crearPetOrder
  Scenario Outline: Crear una orden en la tienda de mascota
    When creo una orden con id <id>, para la mascota <idPet> con una cantidad <cantidad>, el status "<status>" y completado "<complete>"
    Then el código de respuesta es <statusCode>
    And valido que la cantidad sea <cantidad>
    And valido que el status sea "<status>"
    Examples:
      | id    || idPet      || cantidad     || status     || complete   || statusCode |
      |1      ||3           ||1             ||placed      ||true        ||200         |
      |2      ||4           ||50            ||approved    ||false       ||200         |
      |3      ||5           ||100           ||delivered   ||false       ||200         |

  @consultarPetOrder
  Scenario Outline: Consultar una orden, por ID, en la tienda de mascota
    When consulto una orden con id <id>
    Then el código de respuesta es <statusCode>
    And valido que la cantidad sea <cantidad>
    And valido que el status sea "<status>"
    And valido que el id mascota sea <idPet>
    Examples:
      | id    || idPet      || cantidad     || status     || statusCode |
      |1      ||3           ||1             ||placed      ||200         |
      |2      ||4           ||50            ||approved    ||200         |
      |3      ||5           ||100           ||delivered   ||200         |
