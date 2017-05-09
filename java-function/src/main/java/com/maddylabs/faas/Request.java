package com.maddylabs.faas;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by mageshwaranr on 5/8/2017.
 */
@Getter
@Setter
@ToString
public class Request {

    private long respondIn;
    private String responseStr;
    private int exitCode;
    private String type;
    private String svcName;

}
