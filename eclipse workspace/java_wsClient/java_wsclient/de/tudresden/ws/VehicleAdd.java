
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_add complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
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
     * ���o vehID �S�ʪ���.
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
     * �]�w vehID �S�ʪ���.
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
     * ���o typeID �S�ʪ���.
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
     * �]�w typeID �S�ʪ���.
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
     * ���o routeID �S�ʪ���.
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
     * �]�w routeID �S�ʪ���.
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
     * ���o depart �S�ʪ���.
     * 
     */
    public int getDepart() {
        return depart;
    }

    /**
     * �]�w depart �S�ʪ���.
     * 
     */
    public void setDepart(int value) {
        this.depart = value;
    }

    /**
     * ���o pos �S�ʪ���.
     * 
     */
    public double getPos() {
        return pos;
    }

    /**
     * �]�w pos �S�ʪ���.
     * 
     */
    public void setPos(double value) {
        this.pos = value;
    }

    /**
     * ���o speed �S�ʪ���.
     * 
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * �]�w speed �S�ʪ���.
     * 
     */
    public void setSpeed(double value) {
        this.speed = value;
    }

    /**
     * ���o lane �S�ʪ���.
     * 
     */
    public byte getLane() {
        return lane;
    }

    /**
     * �]�w lane �S�ʪ���.
     * 
     */
    public void setLane(byte value) {
        this.lane = value;
    }

}
