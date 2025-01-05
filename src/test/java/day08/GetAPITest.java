package day08;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPITest {
    @Test
    public void testGet() {

        RestAssured.baseURI = "https://reqres.in/";

        Response response = given()
                .header("Authorization", "Bearer uiopojhvbnm")
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200) // Kiểm tra mã trạng thái HTTP là 201 (Created)
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

//      Kiểm tra giá trị trong phản hồi
        Assertions.assertEquals(2, response.jsonPath().getInt("page"));
        Assertions.assertEquals(6, response.jsonPath().getInt("per_page"));
        Assertions.assertEquals(12, response.jsonPath().getInt("total"));
        Assertions.assertEquals(2, response.jsonPath().getInt("total_pages"));

//        Kiểm tra số lượng người dùng trả về trong trang
        int totalUsers = response.jsonPath().getList("data").size();
        Assertions.assertEquals(6, totalUsers); // Giả định rằng trang 2 có 6 người dùng

//        Kiểm tra thông tin người dùng đầu tiên trong trang
        Assertions.assertEquals(7, response.jsonPath().getInt("data[0].id"));
        Assertions.assertEquals("Michael", response.jsonPath().getString("data[0].first_name"));
        Assertions.assertEquals("Lawson", response.jsonPath().getString("data[0].last_name"));
        Assertions.assertEquals("michael.lawson@reqres.in", response.jsonPath().getString("data[0].email"));

    }

}
