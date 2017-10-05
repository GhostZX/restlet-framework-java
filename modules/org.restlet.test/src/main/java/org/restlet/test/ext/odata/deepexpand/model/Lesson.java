/**
 * Copyright 2005-2017 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

package org.restlet.test.ext.odata.deepexpand.model;

import java.util.List;

import org.restlet.test.ext.odata.deepexpand.model.CoOp;
import org.restlet.test.ext.odata.deepexpand.model.Department;
import org.restlet.test.ext.odata.deepexpand.model.Multilingual;

/**
 * Generated by the generator tool for the OData extension for the Restlet
 * framework.<br>
 * 
 * @see <a
 *      href="http://praktiki.metal.ntua.gr/CoopOData/CoopOData.svc/$metadata">Metadata
 *      of the target OData service</a>
 * 
 */
public class Lesson {

    private int id;

    private Tracking tracking;

    private List<CoOp> coOps;

    private Department department;

    private Multilingual name;

    /**
     * Constructor without parameter.
     * 
     */
    public Lesson() {
        super();
    }

    /**
     * Constructor.
     * 
     * @param id
     *            The identifiant value of the entity.
     */
    public Lesson(int id) {
        this();
        this.id = id;
    }

    /**
     * Returns the value of the "id" attribute.
     * 
     * @return The value of the "id" attribute.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the value of the "tracking" attribute.
     * 
     * @return The value of the "tracking" attribute.
     */
    public Tracking getTracking() {
        return tracking;
    }

    /**
     * Returns the value of the "coOps" attribute.
     * 
     * @return The value of the "coOps" attribute.
     */
    public List<CoOp> getCoOps() {
        return coOps;
    }

    /**
     * Returns the value of the "department" attribute.
     * 
     * @return The value of the "department" attribute.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Returns the value of the "name" attribute.
     * 
     * @return The value of the "name" attribute.
     */
    public Multilingual getName() {
        return name;
    }

    /**
     * Sets the value of the "id" attribute.
     * 
     * @param id
     *            The value of the "id" attribute.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the value of the "tracking" attribute.
     * 
     * @param tracking
     *            The value of the "tracking" attribute.
     */
    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    /**
     * Sets the value of the "coOps" attribute.
     * 
     * @param coOps
     *            " The value of the "coOps" attribute.
     */
    public void setCoOps(List<CoOp> coOps) {
        this.coOps = coOps;
    }

    /**
     * Sets the value of the "department" attribute.
     * 
     * @param department
     *            " The value of the "department" attribute.
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Sets the value of the "name" attribute.
     * 
     * @param name
     *            " The value of the "name" attribute.
     */
    public void setName(Multilingual name) {
        this.name = name;
    }

}