public class NodoAVL {
    Comparable valor;
    String nombre;
    int bal;
    int alt;
    NodoAVL izq,der;
    public NodoAVL(Comparable x,String name){
        valor=x;
        nombre = name;
        bal=0;
        izq=der=null;
    }
    public NodoAVL(Comparable x, NodoAVL ni, NodoAVL nd){
        valor=x;
        bal=0;
        izq=ni;
        der=nd;
    }
}