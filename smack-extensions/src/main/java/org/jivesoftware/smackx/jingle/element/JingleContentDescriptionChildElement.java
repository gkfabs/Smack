/**
 *
 * Copyright © 2014-2017 Florian Schmaus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.smackx.jingle.element;

import org.jivesoftware.smack.packet.NamedElement;

/**
 * An element found usually in 'description' elements.
 * <pre> {@code
 *
 * <jingle>
 *     <content>
 *         <description>
 *             <XYZ/> <- We live here.
 *         </description>
 *         <transport/>
 *         <security/>
 *     </content>
 * </jingle>
 * }
 * </pre>
 */
public abstract class JingleContentDescriptionChildElement implements NamedElement {

    public static final String ELEMENT = "payload-type";

    @Override
    public String getElementName() {
        return ELEMENT;
    }
}
