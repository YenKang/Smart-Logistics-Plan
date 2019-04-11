
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>vehicleData complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
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
     * ���o length �S�ʪ���.
     * 
     */
    public double getLength() {
        return length;
    }

    /**
     * �]�w length �S�ʪ���.
     * 
     */
    public void setLength(double value) {
        this.length = value;
    }

    /**
     * ���o entryTime �S�ʪ���.
     * 
     */
    public double getEntryTime() {
        return entryTime;
    }

    /**
     * �]�w entryTime �S�ʪ���.
     * 
     */
    public void setEntryTime(double value) {
        this.entryTime = value;
    }

    /**
     * ���o leaveTime �S�ʪ���.
     * 
     */
    public double getLeaveTime() {
        return leaveTime;
    }

    /**
     * �]�w leaveTime �S�ʪ���.
     * 
     */
    public void setLeaveTime(double value) {
        this.leaveTime = value;
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

}
