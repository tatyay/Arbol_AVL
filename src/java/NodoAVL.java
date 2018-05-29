public class NodoAVL {
    Comparable valor;
    int bal;
    int alt;
    NodoAVL izq,der;
    public NodoAVL(Comparable x){
        valor=x;
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