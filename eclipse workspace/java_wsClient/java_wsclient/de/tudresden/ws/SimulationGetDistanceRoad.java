
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_getDistanceRoad complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
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
     * 取得 edgeID1 特性的值.
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
     * 設定 edgeID1 特性的值.
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
     * 取得 pos1 特性的值.
     * 
     */
    public double getPos1() {
        return pos1;
    }

    /**
     * 設定 pos1 特性的值.
     * 
     */
    public void setPos1(double value) {
        this.pos1 = value;
    }

    /**
     * 取得 edgeID2 特性的值.
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
     * 設定 edgeID2 特性的值.
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
     * 取得 pos2 特性的值.
     * 
     */
    public double getPos2() {
        return pos2;
    }

    /**
     * 設定 pos2 特性的值.
     * 
     */
    public void setPos2(double value) {
        this.pos2 = value;
    }

    /**
     * 取得 isDriving 特性的值.
     * 
     */
    public boolean isIsDriving() {
        return isDriving;
    }

    /**
     * 設定 isDriving 特性的值.
     * 
     */
    public void setIsDriving(boolean value) {
        this.isDriving = value;
    }

}
