package org.jolokia.util;

/*
 * Copyright 2009-2013 Roland Huss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * Simple log handler for dispatching logging to e.g. a {@link javax.servlet.http.HttpServlet}
 *
 * This is a dedicated abstraction in order to allow multiple implementations for a log handler
 * independent from a certain logging API.
 *
 * @author roland
 * @since Nov 11, 2009
 */
public interface LogHandler {

    /**
     * Log a debug messages
     * @param message debug message
     */
    void debug(String message);

    /**
     * Log informal message
     * @param message message to log
     */
    void info(String message);

    /**
     * Log an error
     *
     * @param message error message
     * @param t exception causing this error
     * */
    void error(String message, Throwable t);

    // =============================================================================================================

    /**
     * Loghandler which doesn not output anything
     */
    LogHandler QUIET = new LogHandler() {

        /** {@inheritDoc} */
        public void debug(String message) { }

        /** {@inheritDoc} */
        public void info(String message) { }

        /** {@inheritDoc} */
        public void error(String message, Throwable t) { }

        /** {@inheritDoc} */
        public boolean isDebug() {
            return false;
        }
    };

    // ====================================================================

    /**
     * Loghandler for printing to stdout
     */
    class StdoutLogHandler implements LogHandler {
        private boolean doDebug;

        public StdoutLogHandler(boolean pDoDebug) {
            doDebug = pDoDebug;
        }

        public void debug(String message) {
            if (doDebug) {
                log("D> " + message);
            }
        }

        public void info(String message) {
            log("I> " + message);
        }

        public void error(String message, Throwable t) {
            log("E> " + message);
            t.printStackTrace();
        }

        public boolean isDebug() {
            return doDebug;
        }

        private void log(String message) {
            System.out.println(message); //NOSONAR
        }
    }

    /**
     * Check whether debug is switched on
     *
     * @return true if debugging is enabled
     */
    boolean isDebug();
}
