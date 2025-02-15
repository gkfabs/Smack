/**
 *
 * Copyright 2017 Paul Schaub
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

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.jingle.component.JingleSecurity;

/**
 * {@link ExtensionElement} representing a {@link JingleSecurity}.
 *  <pre> {@code
 *
 * <jingle>
 *     <content>
 *         <description/>
 *         <transport/>
 *         <security/> <- That's me :)
 *     </content>
 * </jingle>
 *
 * } </pre>
 *
 */
public abstract class JingleContentSecurityElement implements ExtensionElement {

    public static final String NAMESPACE = "urn:xmpp:jingle:security:stub:0";

    public static final String ELEMENT = "security";

    private JingleContentSecurityInfoElement securityInfo;

    public JingleContentSecurityElement() {

    }

    public JingleContentSecurityElement(JingleContentSecurityInfoElement info) {
        this.securityInfo = info;
    }

    @Override
    public String getElementName() {
        return ELEMENT;
    }

    public JingleContentSecurityInfoElement getSecurityInfo() {
        return securityInfo;
    }
}
