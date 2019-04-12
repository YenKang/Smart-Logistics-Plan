
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_convert2D complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Simulation_convert2D">
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
@XmlType(name = "Simulation_convert2D", propOrder = {
    "edgeID",
    "pos",
    "laneIndex",
    "toGeo"
})
public class SimulationConvert2D {

    protected String edgeID;
    protected double pos;
    protected byte laneIndex; // btye to int
    protected String toGeo;

    /**
     * 取得 edgeID 特性的值.
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
     * 設定 edgeID 特性的值.
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
     * 取得 laneIndex 特性的值.
     * 
     */
    public byte getLaneIndex() {
        return laneIndex;
    }

    /**
     * 設定 laneIndex 特性的值.
     * 
     */
    public void setLaneIndex(byte value) {
        this.laneIndex = value;
    }

    /**
     * 取得 toGeo 特性的值.
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
     * 設定 toGeo 特性的值.
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
