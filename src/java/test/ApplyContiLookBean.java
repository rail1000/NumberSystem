
package test;

import java.util.Date;

public class ApplyContiLookBean {
    int[] id;
    String[] numBegin;
    String[] numEnd;
    int[] agreeFlag;
    int num;
    String[] descrip;
    String[] type;
    String[] typeA;
    String[] typeB;
    String[] typeC;
    int[] chec;
    Date[] date;
     public void setDate(Date[] a){
    date = a;
    }
    public Date[] getDate(){
    return date;
    }
    
    public void setChec(int[] a){
    chec = a;
    }
    public int[] getChec(){
    return chec;
    }
    public void setTypeA(String[] a){
    typeA = a;
    }
    public void setTypeB(String[] a){
    typeB = a;
    }
    public void setTypeC(String[] a){
    typeC = a;
    }
    public String[] getTypeA(){
    return typeA;
    }
    public String[] getTypeB(){
    return typeB;
    }
    public String[] getTypeC(){
   return typeC;
    }
    public void setId(int[] a){
    id = a;
    }
    public void setType(String[] a){
    type = a;
    }
        public void setNumBegin(String[] a){
    numBegin = a;
    }
    public void setNumEnd(String[] a){
    numEnd = a;
    }
    public void setAgreeFlag(int[] a){
    agreeFlag = a;
    }
    public void setNum(int a){
    num = a;
    }
    public void setDescrip(String[] a){
    descrip = a;
    }
    public int[] getId(){
    return id;
    }
     public String[] getNumBegin(){
    return numBegin;
    }
    public String[] getNumEnd(){
    return numEnd;
    }
    public int[] getAgreeFlag(){
    return agreeFlag;
    }
    public int getNum(){
    return num;
    }
    public String[] getDescrip(){
    return descrip;
    }
    public String[] getType(){
    return type;
    }
}

