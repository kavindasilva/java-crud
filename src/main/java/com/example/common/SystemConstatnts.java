package com.example.common;

import java.util.HashMap;

public class SystemConstatnts {
    public static HashMap<String, String> RESPONSE_HEADERS = new HashMap<String, String>(){{
        put("FAILED_REASON", "Reason-Failed");
        put("REQUESTED_ID", "Requested-Id");
    }};
}
