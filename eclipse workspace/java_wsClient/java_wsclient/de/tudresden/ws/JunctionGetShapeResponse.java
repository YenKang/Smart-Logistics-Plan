
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Junction_getShapeResponse complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Junction_getShapeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.tudresden.de/}sumoGeometry" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Junction_getShapeResponse", propOrder = {
    "_return"
})
public class JunctionGetShapeResponse {

    @XmlElement(name = "return")
    protected SumoGeometry _return;

    /**
     * ���o return �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link SumoGeometry }
     *     
     */
    public SumoGeometry getReturn() {
        return _return;
    }

    /**
     * �]�w return �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoGeometry }
     *     
     */
    public void setReturn(SumoGeometry value) {
        this._return = value;
    }

}
