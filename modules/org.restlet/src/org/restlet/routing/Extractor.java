/**
 * Copyright 2005-2009 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.routing;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.data.Cookie;
import org.restlet.data.Form;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.util.Series;

/**
 * Filter extracting attributes from a call. Multiple extractions can be
 * defined, based on the query string of the resource reference, on the request
 * form (ex: posted from a browser) or on cookies.<br>
 * <br>
 * Concurrency note: instances of this class or its subclasses can be invoked by
 * several threads at the same time and therefore must be thread-safe. You
 * should be especially careful when storing state in member variables.
 * 
 * @author Jerome Louvel
 */
public class Extractor extends Filter {
    /** Internal class holding extraction information. */
    private static final class ExtractInfo {
        /** Target attribute name. */
        protected String attribute;

        /** Indicates how to handle repeating values. */
        protected boolean first;

        /** Name of the parameter to look for. */
        protected String parameter;

        /**
         * Constructor.
         * 
         * @param attribute
         *            Target attribute name.
         * @param parameter
         *            Name of the parameter to look for.
         * @param first
         *            Indicates how to handle repeating values.
         */
        public ExtractInfo(String attribute, String parameter, boolean first) {
            this.attribute = attribute;
            this.parameter = parameter;
            this.first = first;
        }
    }

    /** The list of cookies to extract. */
    private volatile List<ExtractInfo> cookieExtracts;

    /** The list of request entity parameters to extract. */
    private volatile List<ExtractInfo> entityExtracts;

    /** The list of query parameters to extract. */
    private volatile List<ExtractInfo> queryExtracts;

    /**
     * Constructor.
     */
    public Extractor() {
        this(null);
    }

    /**
     * Constructor.
     * 
     * @param context
     *            The context.
     */
    public Extractor(Context context) {
        this(context, null);
    }

    /**
     * Constructor.
     * 
     * @param context
     *            The context.
     * @param next
     *            The next Restlet.
     */
    public Extractor(Context context, Restlet next) {
        super(context, next);
    }

    /**
     * Allows filtering before its handling by the target Restlet. By default it
     * parses the template variable, adjust the base reference, then extracts
     * the attributes from form parameters (query, cookies, entity) and finally
     * tries to validates the variables as indicated by the
     * {@link #validate(String, boolean, String)} method.
     * 
     * @param request
     *            The request to filter.
     * @param response
     *            The response to filter.
     * @return The continuation status.
     */
    @Override
    protected int beforeHandle(Request request, Response response) {
        // Extract the query parameters
        if (!getQueryExtracts().isEmpty()) {
            final Form form = request.getResourceRef().getQueryAsForm();

            if (form != null) {
                for (final ExtractInfo ei : getQueryExtracts()) {
                    if (ei.first) {
                        request.getAttributes().put(ei.attribute,
                                form.getFirstValue(ei.parameter));
                    } else {
                        request.getAttributes().put(ei.attribute,
                                form.subList(ei.parameter));
                    }
                }
            }
        }

        // Extract the request entity parameters
        if (!getEntityExtracts().isEmpty()) {
            final Form form = request.getEntityAsForm();

            if (form != null) {
                for (final ExtractInfo ei : getEntityExtracts()) {
                    if (ei.first) {
                        request.getAttributes().put(ei.attribute,
                                form.getFirstValue(ei.parameter));
                    } else {
                        request.getAttributes().put(ei.attribute,
                                form.subList(ei.parameter));
                    }
                }
            }
        }

        // Extract the cookie parameters
        if (!getCookieExtracts().isEmpty()) {
            final Series<Cookie> cookies = request.getCookies();

            if (cookies != null) {
                for (final ExtractInfo ei : getCookieExtracts()) {
                    if (ei.first) {
                        request.getAttributes().put(ei.attribute,
                                cookies.getFirstValue(ei.parameter));
                    } else {
                        request.getAttributes().put(ei.attribute,
                                cookies.subList(ei.parameter));
                    }
                }
            }
        }

        return CONTINUE;
    }

    /**
     * Extracts an attribute from the request cookies.
     * 
     * @param attribute
     *            The name of the request attribute to set.
     * @param cookieName
     *            The name of the cookies to extract.
     * @param first
     *            Indicates if only the first cookie should be set. Otherwise as
     *            a List instance might be set in the attribute value.
     * @return The current Filter.
     */
    public Extractor extractCookie(String attribute, String cookieName,
            boolean first) {
        getCookieExtracts().add(new ExtractInfo(attribute, cookieName, first));
        return this;
    }

    /**
     * Extracts an attribute from the request entity form.
     * 
     * @param attribute
     *            The name of the request attribute to set.
     * @param parameter
     *            The name of the entity form parameter to extract.
     * @param first
     *            Indicates if only the first cookie should be set. Otherwise as
     *            a List instance might be set in the attribute value.
     * @return The current Filter.
     */
    public Extractor extractEntity(String attribute, String parameter,
            boolean first) {
        getEntityExtracts().add(new ExtractInfo(attribute, parameter, first));
        return this;
    }

    /**
     * Extracts an attribute from the query string of the resource reference.
     * 
     * @param attribute
     *            The name of the request attribute to set.
     * @param parameter
     *            The name of the query string parameter to extract.
     * @param first
     *            Indicates if only the first cookie should be set. Otherwise as
     *            a List instance might be set in the attribute value.
     * @return The current Filter.
     */
    public Extractor extractQuery(String attribute, String parameter,
            boolean first) {
        getQueryExtracts().add(new ExtractInfo(attribute, parameter, first));
        return this;
    }

    /**
     * Returns the list of query extracts.
     * 
     * @return The list of query extracts.
     */
    private List<ExtractInfo> getCookieExtracts() {
        // Lazy initialization with double-check.
        List<ExtractInfo> ce = this.cookieExtracts;
        if (ce == null) {
            synchronized (this) {
                ce = this.cookieExtracts;
                if (ce == null) {
                    this.cookieExtracts = ce = new CopyOnWriteArrayList<ExtractInfo>();
                }
            }
        }
        return ce;
    }

    /**
     * Returns the list of query extracts.
     * 
     * @return The list of query extracts.
     */
    private List<ExtractInfo> getEntityExtracts() {
        // Lazy initialization with double-check.
        List<ExtractInfo> ee = this.entityExtracts;
        if (ee == null) {
            synchronized (this) {
                ee = this.entityExtracts;
                if (ee == null) {
                    this.entityExtracts = ee = new CopyOnWriteArrayList<ExtractInfo>();
                }
            }
        }
        return ee;
    }

    /**
     * Returns the list of query extracts.
     * 
     * @return The list of query extracts.
     */
    private List<ExtractInfo> getQueryExtracts() {
        // Lazy initialization with double-check.
        List<ExtractInfo> qe = this.queryExtracts;
        if (qe == null) {
            synchronized (this) {
                qe = this.queryExtracts;
                if (qe == null) {
                    this.queryExtracts = qe = new CopyOnWriteArrayList<ExtractInfo>();
                }
            }
        }
        return qe;
    }

}
