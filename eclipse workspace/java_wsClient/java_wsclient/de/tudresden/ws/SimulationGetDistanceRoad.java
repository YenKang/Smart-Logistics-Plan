
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_getDistanceRoad complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Simulation_getDistanceRoad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="edgeID1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pos1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="edgeID2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pos2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="isDriving" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_getDistanceRoad", propOrder = {
    "edgeID1",
    "pos1",
    "edgeID2",
    "pos2",
    "isDriving"
})
public class SimulationGetDistanceRoad {

    protected String edgeID1;
    protected double pos1;
    protected String edgeID2;
    protected double pos2;
    protected boolean isDriving;

    /**
     * ���o edgeID1 �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdgeID1() {
        return edgeID1;
    }

    /**
     * �]�w edgeID1 �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdgeID1(String value) {
        this.edgeID1 = value;
    }

    /**
     * ���o pos1 �S�ʪ���.
     * 
     */
    public double getPos1() {
        return pos1;
    }

    /**
     * �]�w pos1 �S�ʪ���.
     * 
     */
    public void setPos1(double value) {
        this.pos1 = value;
    }

    /**
     * ���o edgeID2 �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEdgeID2() {
        return edgeID2;
    }

    /**
     * �]�w edgeID2 �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEdgeID2(String value) {
        this.edgeID2 = value;
    }

    /**
     * ���o pos2 �S�ʪ���.
     * 
     */
    public double getPos2() {
        return pos2;
    }

    /**
     * �]�w pos2 �S�ʪ���.
     * 
     */
    public void setPos2(double value) {
        this.pos2 = value;
    }

    /**
     * ���o isDriving �S�ʪ���.
     * 
     */
    public boolean isIsDriving() {
        return isDriving;
    }

    /**
     * �]�w isDriving �S�ʪ���.
     * 
     */
    public void setIsDriving(boolean value) {
        this.isDriving = value;
    }

}
