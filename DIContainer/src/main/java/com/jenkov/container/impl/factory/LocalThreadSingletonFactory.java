/*
    Copyright 2007-2010 Jenkov Development

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/



package com.jenkov.container.impl.factory;

import com.jenkov.container.itf.factory.ILocalFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jakob Jenkov - Copyright 2004-2006 Jenkov Development
 */
public class LocalThreadSingletonFactory extends LocalFactoryBase implements ILocalFactory {
    public ILocalFactory            sourceFactory = null;
    public Map<Thread, Object> instances     = new HashMap<Thread, Object>();


    public LocalThreadSingletonFactory(ILocalFactory sourceFactory) {
        this.sourceFactory = sourceFactory;
    }

    public ILocalFactory getSourceFactory() {
        return sourceFactory;
    }

    public Class getReturnType() {
        return this.sourceFactory.getReturnType();
    }

    public synchronized Object instance(Object[] parameters, Object[] localProducts) {
        Thread callingThread = Thread.currentThread();
        Object instance = this.instances.get(callingThread);
        if(instance == null){
            instance = this.sourceFactory.instance(parameters, localProducts);
            this.instances.put(callingThread, instance);
        }
        return instance;
    }

    public String toString() {
        return "<LocalThreadSingletonFactory> --> "+ this.sourceFactory.toString();
    }

}
