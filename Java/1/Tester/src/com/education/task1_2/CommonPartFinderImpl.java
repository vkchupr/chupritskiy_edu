package com.education.task1_2;


import java.util.ArrayList;

public class CommonPartFinderImpl implements CommonPartFinder {
    public String getMaxLengthCommonPrefix(String[] arrayOfString){
        if(arrayOfString.length == 0)
            return "";

        Boolean flag = true;
        int prefixLength = 0;

        for(int i = 0; i < arrayOfString[0].length(); i++){
            for(int j = 0; j < arrayOfString.length - 1; j++){
                if((arrayOfString[j].length() <= i) || (arrayOfString[j+1].length() <= i)) {
                    flag = false;
                }
                if(arrayOfString[j].charAt(i) != arrayOfString[j+1].charAt(i)) {
                    flag = false;
                }
            }

            if(!flag) {
                prefixLength = i;
                break;
            }
        }
        try {
            return (prefixLength == 0) ? "" : arrayOfString[0].substring(0, prefixLength);
        }catch(StringIndexOutOfBoundsException se){
            return arrayOfString[0].substring(0, prefixLength-1);
        }
    }

    public String getMaxLengthCommonPart(String[] arrayOfString) {
/*        if(arrayOfString.length == 0)
            return "";

        if(arrayOfString.length == 1)
            return arrayOfString[0];*/

        int[][] commonPartMatrix = new int[arrayOfString[0].length()][arrayOfString[1].length()];

        ArrayList<String> commonPartList = new ArrayList<>();

        for(int i = 0; i < commonPartMatrix.length; i++){
            for(int j = 0; j < commonPartMatrix[0].length; j++){
                if(arrayOfString[0].charAt(i) == arrayOfString[1].charAt(j)){
                    if((i != 0) && (j != 0))
                        commonPartMatrix[i][j] = commonPartMatrix[i-1][j-1] + 1;
                    else
                        commonPartMatrix[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < commonPartMatrix.length; i++){
            for(int j = 0; j < commonPartMatrix[0].length; j++){
                if(commonPartMatrix[i][j] > 1)
                    commonPartList.add(arrayOfString[0].substring(i-commonPartMatrix[i][j] + 1, i + 1));
            }
        }

        String result = "";

        Boolean flag;

        for(String commonPart : commonPartList){
            flag = true;
            for(String arrayString : arrayOfString)
                if(!arrayString.contains(commonPart))
                    flag = false;

            if(flag)
                if(commonPart.length() > result.length())
                    result = commonPart;
        }

        if(result == ""){
            System.out.println("common_part: none");
            return "";
            
        }else {
            System.out.println("common_part: " + result);
            return result;
        }
    }
}
