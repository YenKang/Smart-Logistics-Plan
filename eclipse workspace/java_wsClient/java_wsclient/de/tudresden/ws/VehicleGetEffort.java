
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_getEffort complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Vehicle_getEffort">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="edgeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vehicle_getEffort", propOrder = {
    "vehID",
    "time",
    "edgeID"
})
public class VehicleGetEffort {

    protected String vehID;
    protected int time;
    protected String edgeID;

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
     * ���o time �S�ʪ���.
     * 
     */
    public int getTime() {
        return time;
    }

    /**
     * �]�w time �S�ʪ���.
     * 
     */
    public void setTime(int value) {
        this.time = value;
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

}
