/**
 * Copyright 2009-2011 the original author or authors.
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

package com.springsource.insight.plugin.runexec;

import java.util.TimerTask;

/**
 * 
 */
public class TestRunnable extends TimerTask {
    private final String    _testName;
    public TestRunnable(final String testName) {
        _testName = testName;
    }

    @Override
    public void run() {
        System.out.append('\t').append(Thread.currentThread().getName())
                  .append(" - run: ").println(_testName)
                  ;
    }

}
