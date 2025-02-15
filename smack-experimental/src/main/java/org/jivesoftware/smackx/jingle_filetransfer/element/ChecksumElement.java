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
package org.jivesoftware.smackx.jingle_filetransfer.element;

import javax.xml.namespace.QName;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

import org.jivesoftware.smackx.jingle.element.JingleContentElement;
import org.jivesoftware.smackx.jingle_filetransfer.component.JingleFileTransfer;

/**
 * Checksum element declared in <a href="https://xmpp.org/extensions/xep-0234.html#hash">XEP-0234</a>.
 */
public class ChecksumElement implements ExtensionElement {

    public static final String ELEMENT = "checksum";
    public static final QName QNAME = new QName(JingleFileTransfer.NAMESPACE_V5, ELEMENT);

    public static final String ATTR_CREATOR = "creator";
    public static final String ATTR_NAME = "name";

    private final JingleContentElement.Creator creator;
    private final String name;
    private final JingleFileTransferChildElement file;

    /**
     * Create a new ChecksumElement.
     * @param creator creator of the content (party that added the file to the transmission).
     * @param name name of the content.
     * @param file metadata of the file.
     */
    public ChecksumElement(JingleContentElement.Creator creator, String name, JingleFileTransferChildElement file) {
        this.creator = creator;
        this.name = name;
        this.file = Objects.requireNonNull(file, "file MUST NOT be null.");
        Objects.requireNonNull(file.getHash(), "file MUST contain at least one hash element.");
    }

    @Override
    public String getElementName() {
        return QNAME.getLocalPart();
    }

    @Override
    public CharSequence toXML(org.jivesoftware.smack.packet.XmlEnvironment enclosingNamespace) {
        XmlStringBuilder sb = new XmlStringBuilder(this);
        sb.optAttribute(ATTR_CREATOR, creator);
        sb.optAttribute(ATTR_NAME, name);
        sb.rightAngleBracket();
        sb.append(file);
        sb.closeElement(this);
        return sb;
    }

    @Override
    public String getNamespace() {
        return JingleFileTransfer.NAMESPACE;
    }
}
