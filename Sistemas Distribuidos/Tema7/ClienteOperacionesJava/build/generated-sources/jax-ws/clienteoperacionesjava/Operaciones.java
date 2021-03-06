
package clienteoperacionesjava;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Operaciones", targetNamespace = "http://tempuri.org/", wsdlLocation = "https://localhost:44316/Operaciones.asmx?WSDL")
public class Operaciones
    extends Service
{

    private final static URL OPERACIONES_WSDL_LOCATION;
    private final static WebServiceException OPERACIONES_EXCEPTION;
    private final static QName OPERACIONES_QNAME = new QName("http://tempuri.org/", "Operaciones");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://localhost:44316/Operaciones.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        OPERACIONES_WSDL_LOCATION = url;
        OPERACIONES_EXCEPTION = e;
    }

    public Operaciones() {
        super(__getWsdlLocation(), OPERACIONES_QNAME);
    }

    public Operaciones(WebServiceFeature... features) {
        super(__getWsdlLocation(), OPERACIONES_QNAME, features);
    }

    public Operaciones(URL wsdlLocation) {
        super(wsdlLocation, OPERACIONES_QNAME);
    }

    public Operaciones(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, OPERACIONES_QNAME, features);
    }

    public Operaciones(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Operaciones(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OperacionesSoap
     */
    @WebEndpoint(name = "OperacionesSoap")
    public OperacionesSoap getOperacionesSoap() {
        return super.getPort(new QName("http://tempuri.org/", "OperacionesSoap"), OperacionesSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OperacionesSoap
     */
    @WebEndpoint(name = "OperacionesSoap")
    public OperacionesSoap getOperacionesSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "OperacionesSoap"), OperacionesSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns OperacionesSoap
     */
    @WebEndpoint(name = "OperacionesSoap12")
    public OperacionesSoap getOperacionesSoap12() {
        return super.getPort(new QName("http://tempuri.org/", "OperacionesSoap12"), OperacionesSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OperacionesSoap
     */
    @WebEndpoint(name = "OperacionesSoap12")
    public OperacionesSoap getOperacionesSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "OperacionesSoap12"), OperacionesSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (OPERACIONES_EXCEPTION!= null) {
            throw OPERACIONES_EXCEPTION;
        }
        return OPERACIONES_WSDL_LOCATION;
    }

}
