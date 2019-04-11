
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Lanearea_getJamLengthVehicleResponse complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
 * 
 * <pre>
 * &lt;complexType name="Lanearea_getJamLengthVehicleResponse">
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
@XmlType(name = "Lanearea_getJamLengthVehicleResponse", propOrder = {
    "_return"
})
public class LaneareaGetJamLengthVehicleResponse {

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
