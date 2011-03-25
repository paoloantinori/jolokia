package org.jolokia.util;

/*
 *  Copyright 2009-2010 Roland Huss
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/**
 * Simple log handler for dispatching logging to e.g. a {@link javax.servlet.http.HttpServlet}
 * @author roland
 * @since Nov 11, 2009
 */
public interface LogHandler {
    void debug(String message);
    void info(String message);
    void error(String message, Throwable t);
}