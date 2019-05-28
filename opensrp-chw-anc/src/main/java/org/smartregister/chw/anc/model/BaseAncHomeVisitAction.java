package org.smartregister.chw.anc.model;

import android.support.v4.app.Fragment;

import org.apache.commons.lang3.StringUtils;

/**
 * This action list allows users to either load a form or link it to a separate fragment.
 */
public class BaseAncHomeVisitAction {

    private String title;
    private String subTitle;
    private Status actionStatus = Status.PENDING;
    private boolean optional;
    private Fragment destinationFragment;
    private String formName;
    private String jsonPayload;

    public BaseAncHomeVisitAction(String title, String subTitle, boolean optional, Fragment destinationFragment, String formName) throws ValidationException {
        this.title = title;
        this.subTitle = subTitle;
        this.optional = optional;
        this.destinationFragment = destinationFragment;
        this.formName = formName;

        validateMe();
    }

    /**
     * Validate that action object has a proper end point destination
     */
    private void validateMe() throws ValidationException {
        if (StringUtils.isBlank(formName) && destinationFragment == null) {
            throw new ValidationException("This action object lacks a valid form or destination fragment");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Status getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(Status actionStatus) {
        this.actionStatus = actionStatus;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getJsonPayload() {
        return jsonPayload;
    }

    public void setJsonPayload(String jsonPayload) {
        this.jsonPayload = jsonPayload;
    }

    public Fragment getDestinationFragment() {
        return destinationFragment;
    }

    public void setDestinationFragment(Fragment destinationFragment) {
        this.destinationFragment = destinationFragment;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public enum Status {COMPLETED, PARTIALLY_COMPLETED, PENDING}

    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
}
