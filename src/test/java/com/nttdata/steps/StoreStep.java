package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
public class StoreStep {
    private static String STORE = "https://petstore.swagger.io/v2/store/order/";
    // CREAR ORDEN EN LA PET STORE
    public void createOrder(int id, int petId, int cantidad, String status, boolean completado ) {
        SerenityRest.given()
                .contentType("application/json")
                .accept("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + cantidad + ",\n" +
                        "  \"shipDate\": \""+"2025-02-03T22:44:21.490Z"+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": " + completado + "\n" +
                        "}")
                .log().all()
                .post(STORE)
                .then()
                .log().all()
        ;
    }
    //Consultar ORDEN DE TIENDA POR ID
    public void consultarStoreOrder(int id) {
        SerenityRest
                .given()
                .baseUri(STORE)
                .param(String.valueOf(id))
                .relaxedHTTPSValidation()
                .get(STORE+id)
        ;
    }

    public void validateQuantity(int arg0) {
        int quantityRes = SerenityRest.lastResponse().getBody().path("quantity");
        Assert.assertEquals(arg0,quantityRes);
    }

    public void validateStatusCode(int arg0) {
        int statusCode = SerenityRest.lastResponse().getStatusCode();
        Assert.assertEquals(arg0,statusCode);
    }

    public void validateOrderStatus(String arg0) {
        String orderStatusRes = SerenityRest.lastResponse().getBody().path("status");
        Assert.assertEquals(arg0,orderStatusRes);
    }
    public void validateIdMascota(int arg0) {
        int petIdRes = SerenityRest.lastResponse().getBody().path("petId");
        Assert.assertEquals(arg0,petIdRes);
    }
}
