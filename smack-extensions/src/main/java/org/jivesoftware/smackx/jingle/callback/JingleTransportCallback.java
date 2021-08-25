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
package org.jivesoftware.smackx.jingle.callback;

import org.jivesoftware.smackx.bytestreams.BytestreamSession;

/**
 * Callback used to signal success/failure of the transport component.
 */
public interface JingleTransportCallback {

    /**
     * The {@link org.jivesoftware.smackx.jingle.component.JingleTransport} is ready to transfer data.
     * @param bytestreamSession bytestreamSession which was established.
     */
    void onTransportReady(BytestreamSession bytestreamSession);

    /**
     * The {@link org.jivesoftware.smackx.jingle.component.JingleTransport} failed to establish a session.
     * @param e exception.
     */
    void onTransportFailed(Exception e);
}
