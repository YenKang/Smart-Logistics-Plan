
package de.tudresden.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoTLSPhase complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="sumoTLSPhase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minDur" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxDur" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="phasedef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="next" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoTLSPhase", propOrder = {
    "duration",
    "minDur",
    "maxDur",
    "phasedef",
    "next",
    "name"
})
public class SumoTLSPhase {

    protected double duration;
    protected double minDur;
    protected double maxDur;
    protected String phasedef;
    @XmlElement(nillable = true)
    protected List<Integer> next;
    protected String name;

    /**
     * ���o duration �S�ʪ���.
     * 
     */
    public double getDuration() {
        return duration;
    }

    /**
     * �]�w duration �S�ʪ���.
     * 
     */
    public void setDuration(double value) {
        this.duration = value;
    }

    /**
     * ���o minDur �S�ʪ���.
     * 
     */
    public double getMinDur() {
        return minDur;
    }

    /**
     * �]�w minDur �S�ʪ���.
     * 
     */
    public void setMinDur(double value) {
        this.minDur = value;
    }

    /**
     * ���o maxDur �S�ʪ���.
     * 
     */
    public double getMaxDur() {
        return maxDur;
    }

    /**
     * �]�w maxDur �S�ʪ���.
     * 
     */
    public void setMaxDur(double value) {
        this.maxDur = value;
    }

    /**
     * ���o phasedef �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhasedef() {
        return phasedef;
    }

    /**
     * �]�w phasedef �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhasedef(String value) {
        this.phasedef = value;
    }

    /**
     * Gets the value of the next property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the next property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getNext() {
        if (next == null) {
            next = new ArrayList<Integer>();
        }
        return this.next;
    }

    /**
     * ���o name �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * �]�w name �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
