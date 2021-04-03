// generated with ast extension for cup
// version 0.8
// 19/7/2020 12:19:17


package rs.ac.bg.etf.pp1.ast;

public class MyExtendsTypes extends ExtendsTypes {

    private ExtendsTypesOne ExtendsTypesOne;

    public MyExtendsTypes (ExtendsTypesOne ExtendsTypesOne) {
        this.ExtendsTypesOne=ExtendsTypesOne;
        if(ExtendsTypesOne!=null) ExtendsTypesOne.setParent(this);
    }

    public ExtendsTypesOne getExtendsTypesOne() {
        return ExtendsTypesOne;
    }

    public void setExtendsTypesOne(ExtendsTypesOne ExtendsTypesOne) {
        this.ExtendsTypesOne=ExtendsTypesOne;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsTypesOne!=null) ExtendsTypesOne.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsTypesOne!=null) ExtendsTypesOne.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsTypesOne!=null) ExtendsTypesOne.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MyExtendsTypes(\n");

        if(ExtendsTypesOne!=null)
            buffer.append(ExtendsTypesOne.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MyExtendsTypes]");
        return buffer.toString();
    }
}
