// Copyright (c) 2024, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 LLC. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/http;
import ballerina/test;

http:Client testClient = check new ("http://localhost:9090");

@test:Config {}
function testGetAllMenuItems() returns error? {
    MenuItem[] items = check testClient->/menu.get();
    test:assertEquals(items.length(), 30);
}

@test:Config {}
function testGetOneMenuItem() returns error? {
    MenuItem item = check testClient->/menu/[1].get();
    test:assertEquals(item.name, "Margherita Pizza");
    test:assertEquals(item.description, "Classic tomato, mozzarella, and basil pizza");
}

@test:Config {}
function testGetNonExistingItem() returns error? {
    http:Response response = check testClient->/menu/[40].get();
    test:assertEquals(response.statusCode, http:STATUS_NOT_FOUND);
}
