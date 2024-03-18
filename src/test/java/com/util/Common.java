package com.util;

import com.pojo.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class Common {

    Response response;
    GetResponse getResponse;
    PostResponse postResponse;
    PutResponse putResponse;

    public static void baseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }


    public void restActions(String action) {

        baseURI("https://petstore.swagger.io/v2");

        switch (action) {
            case "post":
                response = given().spec(requestSpecification()).body(setPostBody()).
                        when().post("/user").then().assertThat().
                        statusCode(Integer.parseInt("200")).log().all()
                        .extract().response();
                System.out.println("Post Response==============" + response.asString());
                validatePostAndPut(action,"7775");
                break;
            case "get":
                response = given().spec(requestSpecification()).
                        when().get("/user/David12").then().assertThat().
                        statusCode(Integer.parseInt("200")).log().all()
                        .extract().response();
                validateGet("David12");
                break;
            case "update":
                response = given().spec(requestSpecification()).body(setPutBody()).
                        when().put("/user/David12").then().assertThat().
                        statusCode(Integer.parseInt("200")).log().all()
                        .extract().response();
                validatePostAndPut(action,"7775");
                break;
            case "delete":
                response = given().spec(requestSpecification()).
                        when().delete("/user/David123").then().assertThat().
                        statusCode(Integer.parseInt("200")).extract().response();
                break;
            default:
                throw new IllegalArgumentException("Action is not matched");
        }

    }

    private Post setPostBody() {
        Post post = new Post();
        post.setId(7775);
        post.setUsername("David12");
        post.setFirstName("David");
        post.setLastName("Brown");
        post.setPhone("7730030000");
        post.setEmail("davidb@abc.com");
        post.setPassword("test123");
        post.setUserStatus(2);
        return post;
    }

    private Put setPutBody() {
        Put put = new Put();
        put.setId(7775);
        put.setUsername("David123");
        put.setFirstName("David");
        put.setLastName("Brown");
        put.setPhone("7730030000");
        put.setEmail("davidb@abc.com");
        put.setPassword("test123");
        put.setUserStatus(2);
        return put;
    }

    public void validatePostAndPut(String action,String expected) {
        try {
            if (action.equalsIgnoreCase("post")) {
                postResponse = response.getBody().as(PostResponse.class);
                Assert.assertEquals(postResponse.getMessage(), expected);
            } else {
                putResponse = response.getBody().as(PutResponse.class);
                Assert.assertEquals(putResponse.getMessage(), expected);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateGet(String expected) {
        try {
            getResponse = response.getBody().as(GetResponse.class);
            Assert.assertEquals(getResponse.getUsername(), expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(baseURI)
                .addHeader("Accept", "application/json").build();
    }

}
