
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GUI_getBoundaryResponse complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="GUI_getBoundaryResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.tudresden.de/}sumoBoundingBox" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GUI_getBoundaryResponse", propOrder = {
    "_return"
})
public class GUIGetBoundaryResponse {

    @XmlElement(name = "return")
    protected SumoBoundingBox _return;

    /**
     * ���o return �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link SumoBoundingBox }
     *     
     */
    public SumoBoundingBox getReturn() {
        return _return;
    }

    /**
     * �]�w return �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoBoundingBox }
     *     
     */
    public void setReturn(SumoBoundingBox value) {
        this._return = value;
    }

}
