package com.amit.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MockData {


    public List<Map<String, Object>> getEmailMockData() {
        List list = new ArrayList();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "Application 1");
        map.put("start_time", "2022-07-18 13:15:32.385");
        map.put("end_time", "2022-07-18 13:18:08.951");
        map.put("total_errors", null);
        map.put("total_records", 13);
        map.put("run_status", "SUCCESS");
        map.put("error_type", null);
        map.put("exception_message", null);


        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", 2);
        map2.put("name", "Application 2");
        map2.put("start_time", "2022-07-18 13:16:02.138");
        map2.put("end_time", "2022-07-18 13:19:35.242");
        map2.put("total_errors", null);
        map2.put("total_records", 20);
        map2.put("run_status", "SUCCESS");
        map2.put("error_type", null);
        map2.put("exception_message", null);


        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", 3);
        map3.put("name", "Application 3");
        map3.put("start_time", "2022-07-18 13:16:13.253");
        map3.put("end_time", "2022-07-18 13:20:56.732");
        map3.put("total_errors", 0);
        map3.put("total_records", 0);
        map3.put("run_status", "FAILURE");
        map3.put("error_type", "org.springframework.jdbc.BadSqlGrammarException");
        map3.put("exception_message", "StatementCallback: bad SQL grammar [truncate table TABLE_1]; nested exception");


        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", 4);
        map4.put("name", "Application 4");
        map4.put("start_time", "2022-07-18 13:16:32.277");
        map4.put("end_time", "2022-07-18 13:18:34.623");
        map4.put("total_errors", null);
        map4.put("total_records", 5);
        map4.put("run_status", "SUCCESS");
        map4.put("error_type", null);
        map4.put("exception_message", null);


        list.add(map);
        list.add(map2);
        list.add(map3);
        list.add(map4);


        return list;
    }


}
