/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Y;

import org.apache.nifi.util.TestRunner;
import org.apache.nifi.util.TestRunners;
import org.junit.Before;
import org.junit.Test;


public class MyProcessorTest {

    private TestRunner testRunner;

    @Before
    public void init() {
        testRunner = TestRunners.newTestRunner(MyProcessor.class);
    }

    @Test
    public void testProcessor() {
        String json = "[\n" +
                "  {\n" +
                "    \"_id\": \"5cc02c11db6b048b60d5ecd9\",\n" +
                "    \"index\": 0,\n" +
                "    \"guid\": \"0ab8f7b6-33bd-4081-9bcb-a98b886c619c\",\n" +
                "    \"isActive\": true,\n" +
                "    \"age\": 39,\n" +
                "    \"eyeColor\": \"brown\",\n" +
                "    \"name\": \"Dina Horton\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"company\": \"KONNECT\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"_id\": \"5cc02c11fe5a4f18c5ae91f2\",\n" +
                "    \"index\": 1,\n" +
                "    \"guid\": \"5551c3af-55f6-41ef-989a-684dfd92908d\",\n" +
                "    \"isActive\": true,\n" +
                "    \"age\": 25,\n" +
                "    \"eyeColor\": \"blue\",\n" +
                "    \"name\": \"Mccarty Hubbard\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"company\": \"YOGASM\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"_id\": \"5cc02c11323b3dc38c6b19f7\",\n" +
                "    \"index\": 2,\n" +
                "    \"guid\": \"d87c062f-4ff2-4cb9-8829-2d8a4904cd88\",\n" +
                "    \"isActive\": false,\n" +
                "    \"age\": 22,\n" +
                "    \"eyeColor\": \"blue\",\n" +
                "    \"name\": \"Shelton Weiss\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"company\": \"BALOOBA\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"_id\": \"5cc02c11691627438db3b811\",\n" +
                "    \"index\": 3,\n" +
                "    \"guid\": \"afe01147-b8e5-4f78-8813-7ed35c3ce68a\",\n" +
                "    \"isActive\": true,\n" +
                "    \"age\": 33,\n" +
                "    \"eyeColor\": \"blue\",\n" +
                "    \"name\": \"Mckee Wilson\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"company\": \"ISOTRONIC\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"_id\": \"5cc02c1182fcab8da72c4fd6\",\n" +
                "    \"index\": 4,\n" +
                "    \"guid\": \"25012f27-d55f-4084-8d6b-32358503aac9\",\n" +
                "    \"isActive\": true,\n" +
                "    \"age\": 35,\n" +
                "    \"eyeColor\": \"green\",\n" +
                "    \"name\": \"Decker Sweeney\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"company\": \"PERKLE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"_id\": \"5cc02c11dcc8fae468d92845\",\n" +
                "    \"index\": 5,\n" +
                "    \"guid\": \"75e0bfc7-75c4-4f34-9cea-5b67fe1b66f6\",\n" +
                "    \"isActive\": false,\n" +
                "    \"age\": 35,\n" +
                "    \"eyeColor\": \"brown\",\n" +
                "    \"name\": \"Miranda Bradley\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"company\": \"EXODOC\"\n" +
                "  }\n" +
                "]";
        testRunner.enqueue(json);
        testRunner.run();
        testRunner.getFlowFilesForRelationship("MY_RELATIONSHIP").forEach(x ->{
            String out = new String(testRunner.getContentAsByteArray(x));
            System.out.println(out);
            System.out.println("Hello");
        });
    }

}
