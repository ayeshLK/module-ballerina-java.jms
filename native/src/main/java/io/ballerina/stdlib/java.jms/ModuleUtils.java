/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.java.jms;

import io.ballerina.runtime.api.Environment;
import io.ballerina.runtime.api.Module;

import java.util.HashMap;
import java.util.Map;

/**
 * {@code ModuleUtils} contains the utility methods for the module.
 */
public class ModuleUtils {
    private static Module module;

    private ModuleUtils() {
    }

    public static void setModule(Environment environment) {
        module = environment.getCurrentModule();
    }

    public static Module getModule() {
        return module;
    }

    public static Map<String, Object> getProperties(String resourceName) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("moduleOrg", getModule().getOrg());
        properties.put("moduleName", getModule().getName());
        properties.put("moduleVersion", getModule().getMajorVersion());
        properties.put("parentFunctionName", resourceName);
        return properties;
    }
}
