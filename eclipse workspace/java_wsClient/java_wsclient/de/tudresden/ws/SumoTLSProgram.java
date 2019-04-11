
package de.tudresden.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoTLSProgram complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="sumoTLSProgram">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currentPhaseIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="phases" type="{http://ws.tudresden.de/}sumoTLSPhase" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="params">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoTLSProgram", propOrder = {
    "subID",
    "type",
    "currentPhaseIndex",
    "phases",
    "params"
})
public class SumoTLSProgram {

    protected String subID;
    protected int type;
    protected int currentPhaseIndex;
    @XmlElement(nillable = true)
    protected List<SumoTLSPhase> phases;
    @XmlElement(required = true)
    protected SumoTLSProgram.Params params;

    /**
     * ���o subID �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubID() {
        return subID;
    }

    /**
     * �]�w subID �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubID(String value) {
        this.subID = value;
    }

    /**
     * ���o type �S�ʪ���.
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * �]�w type �S�ʪ���.
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

    /**
     * ���o currentPhaseIndex �S�ʪ���.
     * 
     */
    public int getCurrentPhaseIndex() {
        return currentPhaseIndex;
    }

    /**
     * �]�w currentPhaseIndex �S�ʪ���.
     * 
     */
    public void setCurrentPhaseIndex(int value) {
        this.currentPhaseIndex = value;
    }

    /**
     * Gets the value of the phases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the phases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPhases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SumoTLSPhase }
     * 
     * 
     */
    public List<SumoTLSPhase> getPhases() {
        if (phases == null) {
            phases = new ArrayList<SumoTLSPhase>();
        }
        return this.phases;
    }

    /**
     * ���o params �S�ʪ���.
     * 
     * @return
     *     possible object is
     *     {@link SumoTLSProgram.Params }
     *     
     */
    public SumoTLSProgram.Params getParams() {
        return params;
    }

    /**
     * �]�w params �S�ʪ���.
     * 
     * @param value
     *     allowed object is
     *     {@link SumoTLSProgram.Params }
     *     
     */
    public void setParams(SumoTLSProgram.Params value) {
        this.params = value;
    }


    /**
     * <p>anonymous complex type �� Java ���O.
     * 
     * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class Params {

        protected List<SumoTLSProgram.Params.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SumoTLSProgram.Params.Entry }
         * 
         * 
         */
        public List<SumoTLSProgram.Params.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<SumoTLSProgram.Params.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>anonymous complex type �� Java ���O.
         * 
         * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected String key;
            protected String value;

            /**
             * ���o key �S�ʪ���.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * �]�w key �S�ʪ���.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * ���o value �S�ʪ���.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * �]�w value �S�ʪ���.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
