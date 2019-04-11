
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoStopFlags complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
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
     * 取得 stopped 特性的值.
     * 
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * 設定 stopped 特性的值.
     * 
     */
    public void setStopped(boolean value) {
        this.stopped = value;
    }

    /**
     * 取得 parking 特性的值.
     * 
     */
    public boolean isParking() {
        return parking;
    }

    /**
     * 設定 parking 特性的值.
     * 
     */
    public void setParking(boolean value) {
        this.parking = value;
    }

    /**
     * 取得 triggered 特性的值.
     * 
     */
    public boolean isTriggered() {
        return triggered;
    }

    /**
     * 設定 triggered 特性的值.
     * 
     */
    public void setTriggered(boolean value) {
        this.triggered = value;
    }

    /**
     * 取得 containerTriggered 特性的值.
     * 
     */
    public boolean isContainerTriggered() {
        return containerTriggered;
    }

    /**
     * 設定 containerTriggered 特性的值.
     * 
     */
    public void setContainerTriggered(boolean value) {
        this.containerTriggered = value;
    }

    /**
     * 取得 isBusStop 特性的值.
     * 
     */
    public boolean isIsBusStop() {
        return isBusStop;
    }

    /**
     * 設定 isBusStop 特性的值.
     * 
     */
    public void setIsBusStop(boolean value) {
        this.isBusStop = value;
    }

    /**
     * 取得 isContainerStop 特性的值.
     * 
     */
    public boolean isIsContainerStop() {
        return isContainerStop;
    }

    /**
     * 設定 isContainerStop 特性的值.
     * 
     */
    public void setIsContainerStop(boolean value) {
        this.isContainerStop = value;
    }

}
