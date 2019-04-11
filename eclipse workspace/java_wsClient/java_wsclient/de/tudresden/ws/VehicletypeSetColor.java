
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicletype_setColor complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Vehicletype_setColor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typeID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "Vehicletype_setColor", propOrder = {
    "typeID",
    "color"
})
public class VehicletypeSetColor {

    protected String typeID;
    protected SumoColor color;

    /**
     * 取得 typeID 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeID() {
        return typeID;
    }

    /**
     * 設定 typeID 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeID(String value) {
        this.typeID = value;
    }

    /**
     * 取得 color 特性的值.
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
     * 設定 color 特性的值.
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
