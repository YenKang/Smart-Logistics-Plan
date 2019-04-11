
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_add complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Vehicle_add">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="routeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depart" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pos" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="speed" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lane" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehicle_add", propOrder = {
    "vehID",
    "typeID",
    "routeID",
    "depart",
    "pos",
    "speed",
    "lane"
})
public class VehicleAdd {

    protected String vehID;
    protected String typeID;
    protected String routeID;
    protected int depart;
    protected double pos;
    protected double speed;
    protected byte lane;

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

    /**
     * 取得 routeID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteID() {
        return routeID;
    }

    /**
     * 設定 routeID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteID(String value) {
        this.routeID = value;
    }

    /**
     * 取得 depart 特性的值.
     * 
     */
    public int getDepart() {
        return depart;
    }

    /**
     * 設定 depart 特性的值.
     * 
     */
    public void setDepart(int value) {
        this.depart = value;
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
     * 取得 lane 特性的值.
     * 
     */
    public byte getLane() {
        return lane;
    }

    /**
     * 設定 lane 特性的值.
     * 
     */
    public void setLane(byte value) {
        this.lane = value;
    }

}
