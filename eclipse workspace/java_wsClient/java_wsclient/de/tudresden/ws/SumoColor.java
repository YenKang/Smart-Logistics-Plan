
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sumoColor complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="sumoColor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="r" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="g" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumoColor", propOrder = {
    "r",
    "g",
    "b",
    "a"
})
public class SumoColor {

    protected byte r;
    protected byte g;
    protected byte b;
    protected byte a;

    /**
     * ���o r �S�ʪ���.
     * 
     */
    public byte getR() {
        return r;
    }

    /**
     * �]�w r �S�ʪ���.
     * 
     */
    public void setR(byte value) {
        this.r = value;
    }

    /**
     * ���o g �S�ʪ���.
     * 
     */
    public byte getG() {
        return g;
    }

    /**
     * �]�w g �S�ʪ���.
     * 
     */
    public void setG(byte value) {
        this.g = value;
    }

    /**
     * ���o b �S�ʪ���.
     * 
     */
    public byte getB() {
        return b;
    }

    /**
     * �]�w b �S�ʪ���.
     * 
     */
    public void setB(byte value) {
        this.b = value;
    }

    /**
     * ���o a �S�ʪ���.
     * 
     */
    public byte getA() {
        return a;
    }

    /**
     * �]�w a �S�ʪ���.
     * 
     */
    public void setA(byte value) {
        this.a = value;
    }

}
