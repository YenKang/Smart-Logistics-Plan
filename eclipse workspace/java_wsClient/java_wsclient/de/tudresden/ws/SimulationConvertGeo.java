
package de.tudresden.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Simulation_convertGeo complex type �� Java ���O.
 * 
 * <p>�U�C���n���q�|���w�����O���]�t���w�����e.
 * 
 * <pre>
 * &lt;complexType name="Simulation_convertGeo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fromGeo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Simulation_convertGeo", propOrder = {
    "x",
    "y",
    "fromGeo"
})
public class SimulationConvertGeo {

    protected double x;
    protected double y;
    protected boolean fromGeo;

    /**
     * ���o x �S�ʪ���.
     * 
     */
    public double getX() {
        return x;
    }

    /**
     * �]�w x �S�ʪ���.
     * 
     */
    public void setX(double value) {
        this.x = value;
    }

    /**
     * ���o y �S�ʪ���.
     * 
     */
    public double getY() {
        return y;
    }

    /**
     * �]�w y �S�ʪ���.
     * 
     */
    public void setY(double value) {
        this.y = value;
    }

    /**
     * ���o fromGeo �S�ʪ���.
     * 
     */
    public boolean isFromGeo() {
        return fromGeo;
    }

    /**
     * �]�w fromGeo �S�ʪ���.
     * 
     */
    public void setFromGeo(boolean value) {
        this.fromGeo = value;
    }

}
