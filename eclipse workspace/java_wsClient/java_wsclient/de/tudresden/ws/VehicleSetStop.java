
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicle_setStop complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
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
     * ���o laneIndex �S�ʪ���.
     * 
     */
    public byte getLaneIndex() {
        return laneIndex;
    }

    /**
     * �]�w laneIndex �S�ʪ���.
     * 
     */
    public void setLaneIndex(byte value) {
        this.laneIndex = value;
    }

    /**
     * ���o duration �S�ʪ���.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * �]�w duration �S�ʪ���.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
    }

    /**
     * ���o stopType �S�ʪ���.
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
     * �]�w stopType �S�ʪ���.
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
