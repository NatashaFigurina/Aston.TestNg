import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    String URL = "https://postman-echo.com";

    @Test
    public void checkGetTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecUnique(200));
        given().log().body()
                .param("name", "Ric")
                .param("id", 15)
                .when()
                .get("/get")
                .then().log().body()
                .body("args.name", equalTo("Ric"))
                .body("args.id", equalTo("15"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.x-request-start", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get?name=Ric&id=15"))
                .extract()
                .response();
    }

    @Test
    public void checkPostRawTextTest() {
        Specifications.installSpecification(Specifications.requestSpecAny(URL), Specifications.responseSpecUnique(200));
        given().log().body()
                .contentType("text/plain; charset=utf-8")
                .body("name Ann id 15")
                .when()
                .post("/post")
                .then().log().body()
                .body("data", equalTo("name Ann id 15"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.user-agent", notNullValue())
                .body("headers.content-type", containsString("text/plain; charset=utf-8"))
                .body("headers.accept-encoding", containsString("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"))
                .extract().response();
    }


    @Test
    public void checkPostFromDataTest() {
        Specifications.installSpecification(Specifications.requestSpecAny(URL), Specifications.responseSpecUnique(200));
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name", "Natasha")
                .formParam("id", 20)
                .when()
                .post("/post")
                .then().log().body()
                .body("form.name", equalTo("Natasha"))
                .body("form.id", equalTo("20"))
                .contentType("application/json; charset=UTF-8")
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", containsString("application/x-www-form-urlencoded; charset=utf-8"))
                .body("headers.accept-encoding", containsString("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("json", notNullValue())
                .extract().
                response();
    }

    @Test
    public void checkPutTest() {
        Specifications.installSpecification(Specifications.requestSpecAny(URL), Specifications.responseSpecUnique(200));
        given()
                .contentType("text/plain; charset=utf-8")
                .body("name Peter id 18")
                .when()
                .put("/put")
                .then().log().body()
                .body("data", equalTo("name Peter id 18"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", containsString("text/plain; charset=utf-8"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", containsString("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"))
                .extract().response();
    }

    @Test
    public void checkPatchTest() {
        Specifications.installSpecification(Specifications.requestSpecAny(URL), Specifications.responseSpecUnique(200));
        given()
                .contentType("text/plain; charset=utf-8")
                .body("name Peter id 15")
                .when()
                .patch("/patch")
                .then().log().body()
                .body("data", containsString("name Peter id 15"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.content-type", containsString("text/plain; charset=utf-8"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", containsString("gzip,deflate"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .extract().response();
    }

    @Test
    public void checkDeleteTest() {
        Specifications.installSpecification(Specifications.requestSpecAny(URL), Specifications.responseSpecUnique(200));
        given()
                .body("name Peter id 15")
                .when()
                .delete("/delete")
                .then().log().body()
                .body("data", equalTo("name Peter id 15"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connection", equalTo("close"))
                .body("headers.content-length", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.user-agent", notNullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("json", equalTo(null))
                .extract().response();
    }
}