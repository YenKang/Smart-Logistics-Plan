
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Person_getPosition3DResponse complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Person_getPosition3DResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.tudresden.de/}sumoPosition3D" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person_getPosition3DResponse", propOrder = {
    "_return"
})
public class PersonGetPosition3DResponse {

    @XmlElement(name = "return")
    protected SumoPosition3D _return;

    /**
     * 取得 return 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link SumoPosition3D }
     *     
     */
    public SumoPosition3D getReturn() {
        return _return;
    }

    /**
     * 設定 return 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoPosition3D }
     *     
     */
    public void setReturn(SumoPosition3D value) {
        this._return = value;
    }

}
