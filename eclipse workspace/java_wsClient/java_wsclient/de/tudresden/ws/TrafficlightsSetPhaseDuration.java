
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Trafficlights_setPhaseDuration complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Trafficlights_setPhaseDuration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tlsID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phaseDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trafficlights_setPhaseDuration", propOrder = {
    "tlsID",
    "phaseDuration"
})
public class TrafficlightsSetPhaseDuration {

    protected String tlsID;
    protected int phaseDuration;

    /**
     * ���o tlsID �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTlsID() {
        return tlsID;
    }

    /**
     * �]�w tlsID �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTlsID(String value) {
        this.tlsID = value;
    }

    /**
     * ���o phaseDuration �S�ʪ���.
     * 
     */
    public int getPhaseDuration() {
        return phaseDuration;
    }

    /**
     * �]�w phaseDuration �S�ʪ���.
     * 
     */
    public void setPhaseDuration(int value) {
        this.phaseDuration = value;
    }

}
