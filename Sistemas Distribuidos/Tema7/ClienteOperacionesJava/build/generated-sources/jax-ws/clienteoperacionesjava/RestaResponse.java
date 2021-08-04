
package clienteoperacionesjava;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RestaResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "restaResult"
})
@XmlRootElement(name = "RestaResponse")
public class RestaResponse {

    @XmlElement(name = "RestaResult")
    protected int restaResult;

    /**
     * Obtiene el valor de la propiedad restaResult.
     * 
     */
    public int getRestaResult() {
        return restaResult;
    }

    /**
     * Define el valor de la propiedad restaResult.
     * 
     */
    public void setRestaResult(int value) {
        this.restaResult = value;
    }

}
