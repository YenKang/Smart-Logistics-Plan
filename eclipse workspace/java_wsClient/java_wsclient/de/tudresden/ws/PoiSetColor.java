
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Poi_setColor complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Poi_setColor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="poiID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="color" type="{http://ws.tudresden.de/}sumoColor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Poi_setColor", propOrder = {
    "poiID",
    "color"
})
public class PoiSetColor {

    protected String poiID;
    protected SumoColor color;

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
     * ���o color �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link SumoColor }
     *     
     */
    public SumoColor getColor() {
        return color;
    }

    /**
     * �]�w color �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoColor }
     *     
     */
    public void setColor(SumoColor value) {
        this.color = value;
    }

}
