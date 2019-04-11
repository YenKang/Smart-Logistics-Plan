
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_convert3D complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Simulation_convert3D">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="edgeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pos" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="laneIndex" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="toGeo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_convert3D", propOrder = {
    "edgeID",
    "pos",
    "laneIndex",
    "toGeo"
})
public class SimulationConvert3D {

    protected String edgeID;
    protected double pos;
    protected byte laneIndex;
    protected String toGeo;

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
     * ���o toGeo �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToGeo() {
        return toGeo;
    }

    /**
     * �]�w toGeo �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToGeo(String value) {
        this.toGeo = value;
    }

}