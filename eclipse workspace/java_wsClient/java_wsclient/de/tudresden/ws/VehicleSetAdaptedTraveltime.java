
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_setAdaptedTraveltime complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Vehicle_setAdaptedTraveltime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="begTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="edgeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehicle_setAdaptedTraveltime", propOrder = {
    "vehID",
    "begTime",
    "endTime",
    "edgeID",
    "time"
})
public class VehicleSetAdaptedTraveltime {

    protected String vehID;
    protected int begTime;
    protected int endTime;
    protected String edgeID;
    protected double time;

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
     * 取得 begTime 特性的值.
     * 
     */
    public int getBegTime() {
        return begTime;
    }

    /**
     * 設定 begTime 特性的值.
     * 
     */
    public void setBegTime(int value) {
        this.begTime = value;
    }

    /**
     * 取得 endTime 特性的值.
     * 
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * 設定 endTime 特性的值.
     * 
     */
    public void setEndTime(int value) {
        this.endTime = value;
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
     * 取得 time 特性的值.
     * 
     */
    public double getTime() {
        return time;
    }

    /**
     * 設定 time 特性的值.
     * 
     */
    public void setTime(double value) {
        this.time = value;
    }

}
