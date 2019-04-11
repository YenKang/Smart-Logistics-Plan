
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_setStop complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Vehicle_setStop">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="edgeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pos" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="laneIndex" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stopType" type="{http://ws.tudresden.de/}sumoStopFlags" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehicle_setStop", propOrder = {
    "vehID",
    "edgeID",
    "pos",
    "laneIndex",
    "duration",
    "stopType"
})
public class VehicleSetStop {

    protected String vehID;
    protected String edgeID;
    protected double pos;
    protected byte laneIndex;
    protected int duration;
    protected SumoStopFlags stopType;

    /**
     * 取得 vehID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehID() {
        return vehID;
    }

    /**
     * 設定 vehID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehID(String value) {
        this.vehID = value;
    }

    /**
     * 取得 edgeID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdgeID() {
        return edgeID;
    }

    /**
     * 設定 edgeID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdgeID(String value) {
        this.edgeID = value;
    }

    /**
     * 取得 pos 特性的值.
     * 
     */
    public double getPos() {
        return pos;
    }

    /**
     * 設定 pos 特性的值.
     * 
     */
    public void setPos(double value) {
        this.pos = value;
    }

    /**
     * 取得 laneIndex 特性的值.
     * 
     */
    public byte getLaneIndex() {
        return laneIndex;
    }

    /**
     * 設定 laneIndex 特性的值.
     * 
     */
    public void setLaneIndex(byte value) {
        this.laneIndex = value;
    }

    /**
     * 取得 duration 特性的值.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * 設定 duration 特性的值.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
    }

    /**
     * 取得 stopType 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link SumoStopFlags }
     *     
     */
    public SumoStopFlags getStopType() {
        return stopType;
    }

    /**
     * 設定 stopType 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoStopFlags }
     *     
     */
    public void setStopType(SumoStopFlags value) {
        this.stopType = value;
    }

}
