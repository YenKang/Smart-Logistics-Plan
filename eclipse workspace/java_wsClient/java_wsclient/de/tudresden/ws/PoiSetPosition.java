
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Poi_setPosition complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
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
     * ���o poiID �S�ʪ���.
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
     * �]�w poiID �S�ʪ���.
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
     * ���o x �S�ʪ���.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * �]�w x �S�ʪ���.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * ���o y �S�ʪ���.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * �]�w y �S�ʪ���.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

}
