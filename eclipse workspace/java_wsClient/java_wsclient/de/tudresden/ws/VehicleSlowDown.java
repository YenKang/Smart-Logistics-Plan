
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_slowDown complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Vehicle_slowDown">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehicle_slowDown", propOrder = {
    "vehID",
    "speed",
    "duration"
})
public class VehicleSlowDown {

    protected String vehID;
    protected double speed;
    protected int duration;

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
     * 取得 speed 特性的值.
     * 
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * 設定 speed 特性的值.
     * 
     */
    public void setSpeed(double value) {
        this.speed = value;
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

}
