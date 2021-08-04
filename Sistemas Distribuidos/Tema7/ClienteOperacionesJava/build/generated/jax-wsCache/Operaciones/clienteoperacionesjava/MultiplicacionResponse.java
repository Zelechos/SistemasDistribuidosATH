
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
 *         &lt;element name="MultiplicacionResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "multiplicacionResult"
})
@XmlRootElement(name = "MultiplicacionResponse")
public class MultiplicacionResponse {

    @XmlElement(name = "MultiplicacionResult")
    protected int multiplicacionResult;

    /**
     * Obtiene el valor de la propiedad multiplicacionResult.
     * 
     */
    public int getMultiplicacionResult() {
        return multiplicacionResult;
    }

    /**
     * Define el valor de la propiedad multiplicacionResult.
     * 
     */
    public void setMultiplicacionResult(int value) {
        this.multiplicacionResult = value;
    }

}
