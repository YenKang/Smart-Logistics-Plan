
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Poi_setPosition complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Poi_setPosition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poiID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Poi_setPosition", propOrder = {
    "poiID",
    "x",
    "y"
})
public class PoiSetPosition {

    protected String poiID;
    protected double x;
    protected double y;

    /**
     * 取得 poiID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoiID() {
        return poiID;
    }

    /**
     * 設定 poiID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoiID(String value) {
        this.poiID = value;
    }

    /**
     * 取得 x 特性的值.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * 設定 x 特性的值.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * 取得 y 特性的值.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * 設定 y 特性的值.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

}
