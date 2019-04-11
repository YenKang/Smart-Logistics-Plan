
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Trafficlights_getPhaseDurationResponse complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Trafficlights_getPhaseDurationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trafficlights_getPhaseDurationResponse", propOrder = {
    "_return"
})
public class TrafficlightsGetPhaseDurationResponse {

    @XmlElement(name = "return")
    protected int _return;

    /**
     * 取得 return 特性的值.
     * 
     */
    public int getReturn() {
        return _return;
    }

    /**
     * 設定 return 特性的值.
     * 
     */
    public void setReturn(int value) {
        this._return = value;
    }

}
