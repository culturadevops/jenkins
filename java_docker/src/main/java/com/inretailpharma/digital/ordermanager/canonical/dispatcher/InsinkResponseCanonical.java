package com.inretailpharma.digital.ordermanager.canonical.dispatcher;

import java.io.Serializable;

/**
 * @author Henry Gonzales Segovia
 * @version 9/01/2018
 */
public class InsinkResponseCanonical implements Serializable {

    private String inkaventaId;
    private String errorCode;
    private String successCode;
    private String message;
    private String messageDetail;
    private boolean successfullyInvoke;
    private String callSource;
    private boolean retryInkaventaDelivery;

    public InsinkResponseCanonical() {

    }

    public InsinkResponseCanonical(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getInkaventaId() {
        return inkaventaId;
    }

    public void setInkaventaId(String inkaventaId) {
        this.inkaventaId = inkaventaId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    public boolean isSuccessfullyInvoke() {
        return successfullyInvoke;
    }

    public void setSuccessfullyInvoke(boolean successfullyInvoke) {
        this.successfullyInvoke = successfullyInvoke;
    }

    public String getCallSource() {
        return callSource;
    }

    public void setCallSource(String callSource) {
        this.callSource = callSource;
    }

    public boolean isRetryInkaventaDelivery() {
        return retryInkaventaDelivery;
    }

    public void setRetryInkaventaDelivery(boolean retryInkaventaDelivery) {
        this.retryInkaventaDelivery = retryInkaventaDelivery;
    }

    @Override
    public String toString() {
        return "InsinkResponseCanonical{" +
                "inkaventaId='" + inkaventaId + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", successCode='" + successCode + '\'' +
                ", message='" + message + '\'' +
                ", messageDetail='" + messageDetail + '\'' +
                ", successfullyInvoke=" + successfullyInvoke +
                ", callSource='" + callSource + '\'' +
                ", retryInkaventaDelivery=" + retryInkaventaDelivery +
                '}';
    }
}
