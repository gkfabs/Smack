/**
 *
 * Copyright 2017 Florian Schmaus.
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

import java.util.Collections;
import java.util.List;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.component.JingleDescription;

/**
 * {@link ExtensionElement} representing a {@link JingleDescription}.
 * <pre> {@code
 *
 * <jingle>
 *     <content>
 *         <description/> <- This element is us.
 *         <transport/>
 *         <security/>
 *     </content>
 * </jingle>
 *
 * } </pre>
 */
public abstract class JingleContentDescriptionElement implements ExtensionElement {

    public static final String NAMESPACE = "urn:xmpp:jingle:apps:stub:0";

    public static final String ELEMENT = "description";

    private final List<NamedElement> payloads;

    protected JingleContentDescriptionElement(List<? extends NamedElement> payloads) {
        if (payloads != null) {
            this.payloads = Collections.unmodifiableList(payloads);
        }
        else {
            this.payloads = Collections.emptyList();
        }
    }

    @Override
    public String getElementName() {
        return ELEMENT;
    }

    public List<NamedElement> getJingleContentDescriptionChildren() {
        return payloads;
    }

    public JingleContentDescriptionInfoElement getDescriptionInfo() {
        return null; //TODO
    }

    protected void addExtraAttributes(XmlStringBuilder xml) {

    }

    @Override
    public XmlStringBuilder toXML(String enclosingNamespace) {
        XmlStringBuilder xml = new XmlStringBuilder(this);
        addExtraAttributes(xml);
        xml.rightAngleBracket();

        xml.append(payloads);

        xml.closeElement(this);
        return xml;
    }

}
