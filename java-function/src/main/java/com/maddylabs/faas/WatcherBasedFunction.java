package com.maddylabs.faas;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

/**
 * Assumes that a lambda watcher is running in localhost:8080 and gets input by firing get to /input.
 *
 * Informs successful completion by doing a post to /success. Similarly failure to /fail
 */
public class WatcherBasedFunction {

    final static String WATCHER_URI = "http://localhost:8080";
    final static String INPUT = "/input";
    final static String SUCCESS = "/success";
    final static String FAIL = "/fail";

    public static void main(String[] args) throws Exception{
        try {
            JsonNode body = Unirest.get(WATCHER_URI + INPUT).asJson().getBody();
            System.out.println("Body obtained from watcher is "+body.getObject());
            int respondIn = body.getObject().getInt("respondIn");
            Thread.sleep(respondIn);
            Unirest.post(WATCHER_URI+SUCCESS).asJson().getBody();
            System.out.println("Posted success ");
        } catch (Exception e) {
            e.printStackTrace();
            Unirest.post(WATCHER_URI+FAIL).asJson().getBody();
            System.out.println("Posted FAILURE ");
        }
    }


}
