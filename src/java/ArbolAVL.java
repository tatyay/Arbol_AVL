/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateo
 */
public class ArbolAVL {
    private NodoAVL root;
    
    public void insert(Comparable x){
        root=insertar(x,root);
    }
    
    private NodoAVL insertar(Comparable x, NodoAVL t){
        if(t == null){
            t= new NodoAVL(x);
        }
        else if (x.compareTo(t.valor)<0){
            t.izq=insertar(x, t.izq);
            if(altura(t.izq)-altura(t.der)==2){
                if(x.compareTo(t.izq.valor)<0){
                    t=rotacionHijoIzquierdo(t); // CASO 1
                }
                else{
                    t=rotacionDobleHijoIzquierda(t);//CASO 2
                }
            }
        }
        else if(x.compareTo(t.valor)>0){
            t.der=insertar(x,t.der);
            if(altura(t.der)-altura(t.izq)==2){
                if(x.compareTo(t.der.valor)>0){
                    t=rotacionHijoDerecho(t);//CASO 4
                }
                else{
                    t=rotacionDobleHijoDerecho(t);//caso 3
                }
            }
        }
        return null;
    }

    private int altura(NodoAVL t) {
        return t==null ? -1 : t.alt;
    }
    
    private int calcularAltura(NodoAVL actual){
        if(actual==null){
            return -1;
        }
        else{
            return 1+ Math.max(calcularAltura(actual.izq),calcularAltura(actual.der));
        }
    }

    private NodoAVL rotacionHijoIzquierdo(NodoAVL t) {
        NodoAVL aux2 = t.izq;
        t.izq = aux2.der;
        aux2.der=t;
        t.alt = max(altura(t.izq),altura(t.der))+1;
        aux2.alt = max(altura(aux2.izq),t.alt)+1;
        return aux2;
    }

    private NodoAVL rotacionDobleHijoIzquierda(NodoAVL aux) {
        aux.izq = rotacionHijoDerecho(aux.izq);
        return rotacionHijoIzquierdo(aux);
    }

    private NodoAVL rotacionHijoDerecho(NodoAVL t) {
        NodoAVL aux2 = t.der;
        t.der = aux2.izq;
        aux2.izq=t;
        t.alt = max(altura(t.izq),altura(t.der))+1;
        aux2.alt = max(altura(aux2.der),t.alt)+1;
        return aux2;
    }

    private NodoAVL rotacionDobleHijoDerecho(NodoAVL aux) {
        aux.der=rotacionHijoIzquierdo(aux.der);
        return rotacionHijoDerecho(aux);
    }
    
    private static int max(int alIzq, int alDer){
        return alIzq>alDer ? alIzq : alDer;
    }
}
