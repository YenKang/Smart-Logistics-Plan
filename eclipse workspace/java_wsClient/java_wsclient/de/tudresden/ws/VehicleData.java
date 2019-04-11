
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vehicleData complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="vehicleData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="entry_time" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="leave_time" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="typeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicleData", propOrder = {
    "vehID",
    "length",
    "entryTime",
    "leaveTime",
    "typeID"
})
public class VehicleData {

    protected String vehID;
    protected double length;
    @XmlElement(name = "entry_time")
    protected double entryTime;
    @XmlElement(name = "leave_time")
    protected double leaveTime;
    protected String typeID;

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
     * 取得 length 特性的值.
     * 
     */
    public double getLength() {
        return length;
    }

    /**
     * 設定 length 特性的值.
     * 
     */
    public void setLength(double value) {
        this.length = value;
    }

    /**
     * 取得 entryTime 特性的值.
     * 
     */
    public double getEntryTime() {
        return entryTime;
    }

    /**
     * 設定 entryTime 特性的值.
     * 
     */
    public void setEntryTime(double value) {
        this.entryTime = value;
    }

    /**
     * 取得 leaveTime 特性的值.
     * 
     */
    public double getLeaveTime() {
        return leaveTime;
    }

    /**
     * 設定 leaveTime 特性的值.
     * 
     */
    public void setLeaveTime(double value) {
        this.leaveTime = value;
    }

    /**
     * 取得 typeID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeID() {
        return typeID;
    }

    /**
     * 設定 typeID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeID(String value) {
        this.typeID = value;
    }

}
