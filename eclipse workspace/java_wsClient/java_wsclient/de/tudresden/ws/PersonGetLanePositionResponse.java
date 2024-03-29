
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Person_getLanePositionResponse complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Person_getLanePositionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person_getLanePositionResponse", propOrder = {
    "_return"
})
public class PersonGetLanePositionResponse {

    @XmlElement(name = "return")
    protected double _return;

    /**
     * 取得 return 特性的值.
     * 
     */
    public double getReturn() {
        return _return;
    }

    /**
     * 設定 return 特性的值.
     * 
     */
    public void setReturn(double value) {
        this._return = value;
    }

}
