/**
 * Copyright (c) 2009-2011 VMware, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.springsource.insight.plugin.logging;

import com.springsource.insight.intercept.operation.OperationType;

/**
 * 
 */
public final class LoggingDefinitions {
    private LoggingDefinitions() {
        // no instance
    }

    public static final OperationType   TYPE=OperationType.valueOf("logging");
    // a fully qualified path of the framework logger class
    public static final String  FRAMEWORK_ATTR="logFramework",
                                NAME_ATTR="logName",
                                LEVEL_ATTR="logLevel",
                                MESSAGE_ATTR="logMessage",
                                EXCEPTION_ATTR="logException";
}