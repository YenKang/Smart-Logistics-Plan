
package de.tudresden.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoTLSPhase complex type 的 Java 類別.
 * 
 * <p>下列綱要片段會指定此類別中包含的預期內容.
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
     * 取得 duration 特性的值.
     * 
     */
    public double getDuration() {
        return duration;
    }

    /**
     * 設定 duration 特性的值.
     * 
     */
    public void setDuration(double value) {
        this.duration = value;
    }

    /**
     * 取得 minDur 特性的值.
     * 
     */
    public double getMinDur() {
        return minDur;
    }

    /**
     * 設定 minDur 特性的值.
     * 
     */
    public void setMinDur(double value) {
        this.minDur = value;
    }

    /**
     * 取得 maxDur 特性的值.
     * 
     */
    public double getMaxDur() {
        return maxDur;
    }

    /**
     * 設定 maxDur 特性的值.
     * 
     */
    public void setMaxDur(double value) {
        this.maxDur = value;
    }

    /**
     * 取得 phasedef 特性的值.
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
     * 設定 phasedef 特性的值.
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
     * 取得 name 特性的值.
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
     * 設定 name 特性的值.
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
