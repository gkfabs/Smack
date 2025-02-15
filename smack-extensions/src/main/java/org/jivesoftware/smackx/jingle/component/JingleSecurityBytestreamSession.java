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
package org.jivesoftware.smackx.jingle.component;

import java.io.IOException;

import org.jivesoftware.smackx.bytestreams.BytestreamSession;

/**
 * Wrapper class that wraps a {@link BytestreamSession} to add a layer of security.
 */
public abstract class JingleSecurityBytestreamSession implements BytestreamSession {

    /**
     * Wrapped {@link BytestreamSession}.
     */
    protected BytestreamSession wrapped;

    /**
     * Constructor.
     * @param session {@link BytestreamSession} that will be wrapped.
     */
    public JingleSecurityBytestreamSession(BytestreamSession session) {
        this.wrapped = session;
    }

    @Override
    public int getReadTimeout() throws IOException {
        return wrapped.getReadTimeout();
    }

    @Override
    public void setReadTimeout(int timeout) throws IOException {
        wrapped.setReadTimeout(timeout);
    }
}
