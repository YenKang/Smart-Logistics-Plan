
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Lane_setMaxSpeed complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Lane_setMaxSpeed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="laneID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lane_setMaxSpeed", propOrder = {
    "laneID",
    "speed"
})
public class LaneSetMaxSpeed {

    protected String laneID;
    protected double speed;

    /**
     * 取得 laneID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaneID() {
        return laneID;
    }

    /**
     * 設定 laneID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaneID(String value) {
        this.laneID = value;
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

}
