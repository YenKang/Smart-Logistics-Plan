
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_setEffort complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Vehicle_setEffort">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="begTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="edgeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="effort" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehicle_setEffort", propOrder = {
    "vehID",
    "begTime",
    "endTime",
    "edgeID",
    "effort"
})
public class VehicleSetEffort {

    protected String vehID;
    protected int begTime;
    protected int endTime;
    protected String edgeID;
    protected double effort;

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
     * ���o begTime �S�ʪ���.
     * 
     */
    public int getBegTime() {
        return begTime;
    }

    /**
     * �]�w begTime �S�ʪ���.
     * 
     */
    public void setBegTime(int value) {
        this.begTime = value;
    }

    /**
     * ���o endTime �S�ʪ���.
     * 
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * �]�w endTime �S�ʪ���.
     * 
     */
    public void setEndTime(int value) {
        this.endTime = value;
    }

    /**
     * ���o edgeID �S�ʪ���.
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
     * �]�w edgeID �S�ʪ���.
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
     * ���o effort �S�ʪ���.
     * 
     */
    public double getEffort() {
        return effort;
    }

    /**
     * �]�w effort �S�ʪ���.
     * 
     */
    public void setEffort(double value) {
        this.effort = value;
    }

}
