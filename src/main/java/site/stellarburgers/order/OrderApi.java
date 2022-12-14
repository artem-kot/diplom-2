package site.stellarburgers.order;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import site.stellarburgers.ClientInterface;

public class OrderApi implements ClientInterface {
    public RequestSpecification request(OrderPojo order, String accessToken) {
        return RestAssured
                .given()
                .spec(spec)
                .header("Authorization", accessToken)
                .body(order);
    }

    public RequestSpecification request(OrderPojo order) {
        return RestAssured
                .given()
                .spec(spec)
                .body(order);
    }

    public RequestSpecification getUsersOrders(String accessToken) {
        return RestAssured
                .given()
                .spec(spec)
                .header("Authorization", accessToken);
    }

    public RequestSpecification getUsersOrders() {
        return RestAssured
                .given()
                .spec(spec);
    }

    public Response createOrder(OrderPojo order) {
        return request(order).post(createOrderUrl);
    }

    public Response createOrder(OrderPojo order, String accessToken) {
        return request(order, accessToken).post(createOrderUrl);
    }

    public Response getUserOrders(String accessToken) {
        return getUsersOrders(accessToken).get(getUsersOrdersUrl);
    }

    public Response getUserOrders() {
        return getUsersOrders().get(getUsersOrdersUrl);
    }

}
