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
package com.springsource.insight.plugin.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.event.DirtyCheckEvent;
import org.hibernate.event.FlushEvent;
import org.junit.Test;

import com.springsource.insight.collection.OperationCollectionAspectSupport;
import com.springsource.insight.collection.OperationCollectionAspectTestSupport;
import com.springsource.insight.intercept.operation.Operation;
import com.springsource.insight.intercept.operation.OperationType;

public class HibernateEventCollectionAspectTest 
   extends OperationCollectionAspectTestSupport {

	private void standardAsserts(String method) {
        Operation op = getLastEntered();
        assertNotNull(op);
        assertEquals("Hibernate " + method, op.getLabel());
        assertEquals(OperationType.METHOD, op.getType());
	}
	
    @Test
    public void onDirtyAndCollect() {
        DummyDirtyCheckListenerImpl listener = new DummyDirtyCheckListenerImpl();
        listener.onDirtyCheck(new DirtyCheckEvent(null));
        standardAsserts("onDirtyCheck");
    }

    @Test
    public void onFlushAndCollect() {
        DummyFlushEventListenerImpl listener = new DummyFlushEventListenerImpl();
        listener.onFlush(new FlushEvent(null));
        standardAsserts("onFlush");
    }

    @Override
    public OperationCollectionAspectSupport getAspect() {
        return HibernateEventCollectionAspect.aspectOf();
    }

}
