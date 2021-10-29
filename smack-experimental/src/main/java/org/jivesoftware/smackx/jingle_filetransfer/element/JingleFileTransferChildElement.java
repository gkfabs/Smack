/**
 *
 * Copyright 2017 Paul Schaub, 2019 Florian Schmaus
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

import java.io.File;
import java.util.Date;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.jingle.element.JingleContentDescriptionChildElement;
import org.jivesoftware.smackx.jingle_filetransfer.component.JingleFileTransfer;

/**
 * Metadata about the transferred file.
 */
public class JingleFileTransferChildElement extends JingleContentDescriptionChildElement {

    public static final String ELEMENT = "file";
    public static final String NAMESPACE = JingleFileTransfer.NAMESPACE_V5;

    public static final String ELEM_DATE = "date";
    public static final String ELEM_DESC = "desc";
    public static final String ELEM_MEDIA_TYPE = "media-type";
    public static final String ELEM_NAME = "name";
    public static final String ELEM_SIZE = "size";

    private final Date date;
    private final String desc;
    private final HashElement hash;
    private final String mediaType;
    private final String name;
    private final long size;
    private final Range range;

    /**
     * Create a new JingleFileTransferChildElement.
     * @param date last-modified date of the file.
     * @param desc description of the file.
     * @param hash hash value of the file (see XEP-0300).
     * @param mediaType mediaType (https://www.iana.org/assignments/media-types/media-types.xhtml).
     * @param name name of the file.
     * @param size size of the file in bytes.
     * @param range range of the transfer (see https://xmpp.org/extensions/xep-0234.html#range).
     */
    public JingleFileTransferChildElement(Date date, String desc, HashElement hash, String mediaType, String name, long size, Range range) {
        this.date = date;
        this.desc = desc;
        this.hash = hash;
        this.mediaType = mediaType;
        this.name = name;
        this.size = size;
        this.range = range;
    }

    /**
     * Return the last-modified date of the file.
     * @return date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Return the description of the file.
     * @return description.
     */
    public String getDescription() {
        return desc;
    }

    /**
     * Return the hash of the file.
     * @return hash.
     */
    public HashElement getHash() {
        return hash;
    }

    /**
     * Return the mediaType of the file (https://www.iana.org/assignments/media-types/media-types.xhtml).
     * @return media-type.
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * Return the name of the file.
     * @return filename.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the size of the file in bytes.
     * @return size.
     */
    public long getSize() {
        return size;
    }

    /**
     * In case of a ranged transfer: Return the range of the transmission. Otherwise return null.
     * @return range of the transfer.
     */
    public Range getRange() {
        return range;
    }

    @Override
    public String getElementName() {
        return ELEMENT;
    }

    @Override
    public XmlStringBuilder toXML(XmlEnvironment enclosingNamespace) {
        XmlStringBuilder sb = new XmlStringBuilder(this);
        sb.rightAngleBracket();

        sb.optElement(ELEM_DATE, date);
        sb.optElement(ELEM_DESC, desc);
        sb.optElement(ELEM_MEDIA_TYPE, mediaType);
        sb.optElement(ELEM_NAME, name);
        sb.optElement(range);
        if (size > 0) {
            sb.element(ELEM_SIZE, Long.toString(size));
        }
        sb.optElement(hash);
        sb.closeElement(this);
        return sb;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Date date;
        private String desc;
        private HashElement hash;
        private String mediaType;
        private String name;
        private long size;
        private Range range;

        private Builder() {
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setDescription(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder setHash(HashElement hash) {
            this.hash = hash;
            return this;
        }

        /**
         * Set the media type of the file.
         * This is a MIME type from this list:
         * https://www.iana.org/assignments/media-types/media-types.xhtml
         * Default should be application/octet-stream.
         * @param mediaType new media type.
         * @return builder.
         */
        public Builder setMediaType(String mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSize(long size) {
            this.size = size;
            return this;
        }

        public Builder setRange(Range range) {
            this.range = range;
            return this;
        }

        public JingleFileTransferChildElement build() {
            return new JingleFileTransferChildElement(date, desc, hash, mediaType, name, size, range);
        }

        public Builder setFile(File file) {
            return setDate(new Date(file.lastModified()))
                    .setName(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("/") + 1))
                    .setSize((int) file.length());
        }
    }
}
