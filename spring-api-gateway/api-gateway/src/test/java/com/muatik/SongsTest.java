package com.muatik;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by mustafaatik on 13/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SongsTest {
    @Test
    public void testSongRest() {
        Response response = RestAssured.get("http://localhost:8080/api/songs/");
        assertEquals(200, response.getStatusCode());
    }
}
