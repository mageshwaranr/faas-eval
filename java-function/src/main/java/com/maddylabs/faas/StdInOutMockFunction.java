package com.maddylabs.faas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * Created by mageshwaranr on 5/8/2017.
 * <p>
 * Java based function to simulate business function. I/O is shared via Std IN/OUT
 * <p>
 * Accepts two inputs via std.in
 * a. respondIn : attribute defines the response should be sent after this interval
 * b. responseStr : response string that will be sent to System.out as a JSON  named data
 * c. exitCode : the code with which program exits
 */
public class StdInOutMockFunction {

    public static void main(String[] args) {
        try {
            System.err.println("Waiting for system.in");
            Request input = readInput();
            System.err.println("Read input as " + input);
            Thread.sleep(input.getRespondIn());
            writeOutput(input);
            System.exit(input.getExitCode());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static void writeOutput(Request input) {
        Map<String,Object> out = new HashMap<>();
        out.put("data", input.getResponseStr());
        out.put("env", System.getenv());
        out.put("prop", System.getProperties());
        String json = new Gson().toJson(out);
        System.out.print(json);
    }


    private static Request readInput() {
        Scanner scan = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();
        while(scan.hasNext()){
            inputBuilder.append(scan.next());
        }
        String input = inputBuilder.toString();
        return new Gson().fromJson(input,Request.class);
    }
}
