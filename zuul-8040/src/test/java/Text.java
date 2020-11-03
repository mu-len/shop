import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayList;
import java.util.List;

public class Text {

    public static void main(String[] args) {
        Text text = new Text();
        List<Character> y7IH4K72HL88AS3 = text.toArray("Y7IH4K72HL88AS3");
        String s = text.paiXu(y7IH4K72HL88AS3);
        System.out.println(s);
        text.tex();
    }

    public List<Character> toArray(String string){
        char[] chars = string.toCharArray();
        List<Character> list=new ArrayList();
        for (char aChar : chars) {
            if(aChar>47&&aChar<58){
                list.add(aChar);
            }
        }
        return list;
    }

    public String paiXu(List<Character> list){
        Character[] characters = list.toArray(new Character[list.size()]);
        char c;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 1; j < characters.length; j++) {
                if(characters[j-1]>characters[j]){
                    c=characters[j-1];
                    characters[j-1]=characters[j];
                    characters[j]=c;
                }
            }
        }

        String s="";
        for (Character character : characters) {
            s=s+character;
        }
        return s;
    }

    public void tet(){
        String[][] strings=new String[3][];
        System.out.println(strings[2][0]);
    }

    public void tex(){
        int x=0;
        int y=0;
        for (int z=0;z<5;z++){
            if(++x>2||++y>2){
                x++;
            }
        }
        System.out.println("x="+x+",y="+y);
    }
}
