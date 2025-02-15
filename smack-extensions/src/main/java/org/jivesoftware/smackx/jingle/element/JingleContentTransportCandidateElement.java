/**
 *
 * Copyright 2017 Florian Schmaus
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
import org.jivesoftware.smackx.jingle.component.JingleTransportCandidate;

/**
 * {@link NamedElement} representing a {@link JingleTransportCandidate}
 *
 *  <pre> {@code
 * <jingle>
 *     <content>
 *         <description/>
 *         <transport>
 *             <candidate/> <- We are those guys.
 *             <candidate/> <-/
 *         </transport>
 *     </content>
 * </jingle>
 * } </pre>
 *
 */
public abstract class JingleContentTransportCandidateElement implements NamedElement {

    public static final String ELEMENT = "candidate";

    @Override
    public String getElementName() {
        return ELEMENT;
    }
}
