/**
 * Classe de exceção.
 * Quando o sócio a que tentamos aceder não existe (null).
 *
 * @author cam
 * @version 20181006
 */

package model;

public class SocioNullException extends Exception {
    public SocioNullException(){
    }

    public SocioNullException(String msg) {
        super(msg);
    }
}
