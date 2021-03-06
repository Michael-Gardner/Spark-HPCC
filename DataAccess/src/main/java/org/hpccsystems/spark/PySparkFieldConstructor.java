/*******************************************************************************
 *     HPCC SYSTEMS software Copyright (C) 2019 HPCC Systems®.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *******************************************************************************/
package org.hpccsystems.spark;

import net.razorvine.pickle.IObjectConstructor;
import net.razorvine.pickle.PickleException;

public class PySparkFieldConstructor implements IObjectConstructor
{

    public PySparkFieldConstructor() {}

    @Override
    public Object construct(Object[] tupleFields) throws PickleException
    {
        // PySparkFields consist of two fields Name & Value
        if (tupleFields.length != 2 || tupleFields[0] instanceof String == false)
        {
            throw new PickleException("Unexpected PySparkField data layout.");
        }

        String name = (String) tupleFields[0];
        Object value = (Object) tupleFields[1];
        return new PySparkField(name,value);
    }
}
