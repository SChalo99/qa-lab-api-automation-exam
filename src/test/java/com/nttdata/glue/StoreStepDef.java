package com.nttdata.glue;

import com.nttdata.steps.StoreStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreStepDef {
    StoreStep storeStep = new StoreStep();

    @When("creo una orden con id {int}, para la mascota {int} con una cantidad {int}, el status {string} y completado {string}")
    public void consultoLaTiendaMascotaConIDMASCOTA(int id, int petId, int cantidad, String status, String completado){
        boolean isCompleted = Boolean.parseBoolean(completado);
        storeStep.createOrder(id,petId,cantidad,status,isCompleted);
    }
    @When("consulto una orden con id {int}")
    public void consultoUnaOrdenConIdId(int id) {
        storeStep.consultarStoreOrder(id);
    }

    @Then("el código de respuesta es {int}")
    public void códigoDeRespuestaAlCrearEsStatusCode(int arg0) {
        storeStep.validateStatusCode(arg0);
    }
    @And("valido que la cantidad sea {int}")
    public void validoQueLaCantidadSeaCantidad(int arg0) {
        storeStep.validateQuantity(arg0);
    }

    @And("valido que el status sea {string}")
    public void validoQueElStatusSea(String arg0) {
        storeStep.validateOrderStatus(arg0);
    }

    @And("valido que el id mascota sea {int}")
    public void validoQueElIdMascotaSeaIdPet(int petId) {
        storeStep.validateIdMascota(petId);
    }
}
