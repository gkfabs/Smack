/**
 *
 * Copyright 2017 Paul Schaub.
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

import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.provider.JingleContentSecurityProvider;

/**
 * Default {@link JingleContentSecurityElement}, which gets returned, if there is no suitable
 * {@link JingleContentSecurityProvider} registered.
 */
public final class UnknownJingleContentSecurityElement extends JingleContentSecurityElement {

    private final StandardExtensionElement standardExtensionElement;

    public UnknownJingleContentSecurityElement(StandardExtensionElement standardExtensionElement) {
        super();
        this.standardExtensionElement = standardExtensionElement;
    }

    @Override
    public String getElementName() {
        return standardExtensionElement.getElementName();
    }

    @Override
    public String getNamespace() {
        return standardExtensionElement.getNamespace();
    }

    @Override
    public XmlStringBuilder toXML(org.jivesoftware.smack.packet.XmlEnvironment enclosingNamespace) {
        return standardExtensionElement.toXML(enclosingNamespace);
    }

    @Override
    public JingleContentSecurityInfoElement getSecurityInfo() {
        throw new UnsupportedOperationException();
    }

    /**
     * Return the {@link StandardExtensionElement} which represents this.
     * @return element.
     */
    public StandardExtensionElement getStandardExtensionElement() {
        return standardExtensionElement;
    }
}
