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

import org.restlet.test.ext.odata.deepexpand.model.JobPart;
import org.restlet.test.ext.odata.deepexpand.model.JobPostingPart;
import org.restlet.test.ext.odata.deepexpand.model.Location;
import org.restlet.test.ext.odata.deepexpand.model.Registration;
import org.restlet.test.ext.odata.deepexpand.model.Student;

/**
 * Generated by the generator tool for the OData extension for the Restlet
 * framework.<br>
 * 
 * @see <a
 *      href="http://praktiki.metal.ntua.gr/CoopOData/CoopOData.svc/$metadata">Metadata
 *      of the target OData service</a>
 * 
 */
public class Location {

    private int id;

    private String name;

    private String path;

    private String type;

    private Tracking tracking;

    private List<Location> childLocations;

    private List<Student> issuedIdStudents;

    private List<JobPart> jobPartsInExpedition;

    private List<JobPostingPart> jobPostingPartsInExpedition;

    private Location parentLocation;

    private List<Registration> preferredByRegistrations;

    /**
     * Constructor without parameter.
     * 
     */
    public Location() {
        super();
    }

    /**
     * Constructor.
     * 
     * @param id
     *            The identifiant value of the entity.
     */
    public Location(int id) {
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
     * Returns the value of the "name" attribute.
     * 
     * @return The value of the "name" attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the value of the "path" attribute.
     * 
     * @return The value of the "path" attribute.
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns the value of the "type" attribute.
     * 
     * @return The value of the "type" attribute.
     */
    public String getType() {
        return type;
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
     * Returns the value of the "childLocations" attribute.
     * 
     * @return The value of the "childLocations" attribute.
     */
    public List<Location> getChildLocations() {
        return childLocations;
    }

    /**
     * Returns the value of the "issuedIdStudents" attribute.
     * 
     * @return The value of the "issuedIdStudents" attribute.
     */
    public List<Student> getIssuedIdStudents() {
        return issuedIdStudents;
    }

    /**
     * Returns the value of the "jobPartsInExpedition" attribute.
     * 
     * @return The value of the "jobPartsInExpedition" attribute.
     */
    public List<JobPart> getJobPartsInExpedition() {
        return jobPartsInExpedition;
    }

    /**
     * Returns the value of the "jobPostingPartsInExpedition" attribute.
     * 
     * @return The value of the "jobPostingPartsInExpedition" attribute.
     */
    public List<JobPostingPart> getJobPostingPartsInExpedition() {
        return jobPostingPartsInExpedition;
    }

    /**
     * Returns the value of the "parentLocation" attribute.
     * 
     * @return The value of the "parentLocation" attribute.
     */
    public Location getParentLocation() {
        return parentLocation;
    }

    /**
     * Returns the value of the "preferredByRegistrations" attribute.
     * 
     * @return The value of the "preferredByRegistrations" attribute.
     */
    public List<Registration> getPreferredByRegistrations() {
        return preferredByRegistrations;
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
     * Sets the value of the "name" attribute.
     * 
     * @param name
     *            The value of the "name" attribute.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the value of the "path" attribute.
     * 
     * @param path
     *            The value of the "path" attribute.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Sets the value of the "type" attribute.
     * 
     * @param type
     *            The value of the "type" attribute.
     */
    public void setType(String type) {
        this.type = type;
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
     * Sets the value of the "childLocations" attribute.
     * 
     * @param childLocations
     *            " The value of the "childLocations" attribute.
     */
    public void setChildLocations(List<Location> childLocations) {
        this.childLocations = childLocations;
    }

    /**
     * Sets the value of the "issuedIdStudents" attribute.
     * 
     * @param issuedIdStudents
     *            " The value of the "issuedIdStudents" attribute.
     */
    public void setIssuedIdStudents(List<Student> issuedIdStudents) {
        this.issuedIdStudents = issuedIdStudents;
    }

    /**
     * Sets the value of the "jobPartsInExpedition" attribute.
     * 
     * @param jobPartsInExpedition
     *            " The value of the "jobPartsInExpedition" attribute.
     */
    public void setJobPartsInExpedition(List<JobPart> jobPartsInExpedition) {
        this.jobPartsInExpedition = jobPartsInExpedition;
    }

    /**
     * Sets the value of the "jobPostingPartsInExpedition" attribute.
     * 
     * @param jobPostingPartsInExpedition
     *            " The value of the "jobPostingPartsInExpedition" attribute.
     */
    public void setJobPostingPartsInExpedition(
            List<JobPostingPart> jobPostingPartsInExpedition) {
        this.jobPostingPartsInExpedition = jobPostingPartsInExpedition;
    }

    /**
     * Sets the value of the "parentLocation" attribute.
     * 
     * @param parentLocation
     *            " The value of the "parentLocation" attribute.
     */
    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }

    /**
     * Sets the value of the "preferredByRegistrations" attribute.
     * 
     * @param preferredByRegistrations
     *            " The value of the "preferredByRegistrations" attribute.
     */
    public void setPreferredByRegistrations(
            List<Registration> preferredByRegistrations) {
        this.preferredByRegistrations = preferredByRegistrations;
    }

}