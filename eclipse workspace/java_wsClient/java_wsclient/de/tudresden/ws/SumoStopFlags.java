
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoStopFlags complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="sumoStopFlags">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stopped" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="parking" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="triggered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="containerTriggered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isBusStop" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isContainerStop" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoStopFlags", propOrder = {
    "stopped",
    "parking",
    "triggered",
    "containerTriggered",
    "isBusStop",
    "isContainerStop"
})
public class SumoStopFlags {

    protected boolean stopped;
    protected boolean parking;
    protected boolean triggered;
    protected boolean containerTriggered;
    protected boolean isBusStop;
    protected boolean isContainerStop;

    /**
     * ���o stopped �S�ʪ���.
     * 
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * �]�w stopped �S�ʪ���.
     * 
     */
    public void setStopped(boolean value) {
        this.stopped = value;
    }

    /**
     * ���o parking �S�ʪ���.
     * 
     */
    public boolean isParking() {
        return parking;
    }

    /**
     * �]�w parking �S�ʪ���.
     * 
     */
    public void setParking(boolean value) {
        this.parking = value;
    }

    /**
     * ���o triggered �S�ʪ���.
     * 
     */
    public boolean isTriggered() {
        return triggered;
    }

    /**
     * �]�w triggered �S�ʪ���.
     * 
     */
    public void setTriggered(boolean value) {
        this.triggered = value;
    }

    /**
     * ���o containerTriggered �S�ʪ���.
     * 
     */
    public boolean isContainerTriggered() {
        return containerTriggered;
    }

    /**
     * �]�w containerTriggered �S�ʪ���.
     * 
     */
    public void setContainerTriggered(boolean value) {
        this.containerTriggered = value;
    }

    /**
     * ���o isBusStop �S�ʪ���.
     * 
     */
    public boolean isIsBusStop() {
        return isBusStop;
    }

    /**
     * �]�w isBusStop �S�ʪ���.
     * 
     */
    public void setIsBusStop(boolean value) {
        this.isBusStop = value;
    }

    /**
     * ���o isContainerStop �S�ʪ���.
     * 
     */
    public boolean isIsContainerStop() {
        return isContainerStop;
    }

    /**
     * �]�w isContainerStop �S�ʪ���.
     * 
     */
    public void setIsContainerStop(boolean value) {
        this.isContainerStop = value;
    }

}
