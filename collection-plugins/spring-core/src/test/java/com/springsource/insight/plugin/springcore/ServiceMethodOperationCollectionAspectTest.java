/**
 * Copyright 2009-2010 the original author or authors.
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

package com.springsource.insight.plugin.springcore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.springsource.insight.collection.OperationCollectionAspectSupport;
import com.springsource.insight.collection.OperationCollectionAspectTestSupport;
import com.springsource.insight.collection.method.AnnotationDrivenMethodOperationCollectionAspect;
import com.springsource.insight.intercept.operation.Operation;

public class ServiceMethodOperationCollectionAspectTest extends OperationCollectionAspectTestSupport {

    // This test focuses only on selection, since all that 
    // ServiceMethodOperationCollectionAspect contains is a pointcut. 
    // Tests for return value, exceptions etc. reside in MethodOperationCollectionAspectTest
    
    @Test
    public void serviceCollectedNormalReturn() {
        ExampleService service = new ExampleService();
        service.perform();
        
        Operation   operation=getLastEntered();
        assertEquals("ExampleService#perform", operation.getLabel());
    }
    
    @Override
    public OperationCollectionAspectSupport getAspect() {
        return AnnotationDrivenMethodOperationCollectionAspect.aspectOf();
    }
    
    @Service
    private static class ExampleService {
        public void perform() {
        }
    }
}
