
package test;

public class AuditBean {
    int[] id;
    String[] Bnumber;
    int[] agreeFlag;
    int num;
    String[] descrip;
    String[] type;
    String[] typeA;
    String[] typeB;
    String[] typeC;
    
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
    public void setBnumber(String[] a){
    Bnumber = a;
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
    public String[] getBnumber(){
    return Bnumber;
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
