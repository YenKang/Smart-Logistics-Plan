
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Vehicletype_getMaxSpeedResponse complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Vehicletype_getMaxSpeedResponse">
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
@XmlType(name = "Vehicletype_getMaxSpeedResponse", propOrder = {
    "_return"
})
public class VehicletypeGetMaxSpeedResponse {

    @XmlElement(name = "return")
    protected double _return;

    /**
     * ���o return �S�ʪ���.
     * 
     */
    public double getReturn() {
        return _return;
    }

    /**
     * �]�w return �S�ʪ���.
     * 
     */
    public void setReturn(double value) {
        this._return = value;
    }

}