package com.cloud.shop.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

public class HanYu {

    public static String getShuPing(String inputString){
        HanyuPinyinOutputFormat format=new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String output="";
        if (!inputString.isEmpty()&&!"null".equals(inputString)){
            char[] chars = inputString.trim().toCharArray();
            try {
                String notChsTmp = "";
                for(int i=0;i<chars.length;i++){
                    if(Character.toString(chars[i]).matches("[\\u4E00-\\u9FA5]+")){
                        if(!notChsTmp.isEmpty()){
                            output+=notChsTmp;
                            output+="  ";
                            notChsTmp="";
                        }
                        String[] strings = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                        output+=strings[0];
                        if(i<chars.length-1){
                            output+="  ";
                        }
                    }else {
                        notChsTmp+=Character.toString(chars[i]);
                    }
                }
                if(notChsTmp.isEmpty()){
                    output+=notChsTmp;
                    notChsTmp="";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return output;
    }
}
