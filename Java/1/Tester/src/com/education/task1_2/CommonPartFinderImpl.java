package com.education.task1_2;


public class CommonPartFinderImpl implements CommonPartFinder {
    public String getMaxLengthCommonPrefix(String[] arrayOfString){
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
        return (prefixLength == 0) ? "" : arrayOfString[0].substring(0,prefixLength);
    }

    public String getMaxLengthCommonPart(String[] arrayOfString) {
        if(arrayOfString.length < 2)
            return arrayOfString[0];

        int[][] commonPartMatrix = new int[arrayOfString[0].length()][arrayOfString[1].length()];
        int commonPartLength = 0;
        int commonPartPos = 0;
        String commonPart;

        for(int i = 0; i < commonPartMatrix.length; i++){
            for(int j = 0; j < commonPartMatrix[0].length; j++){
                if(arrayOfString[0].charAt(i) == arrayOfString[1].charAt(j)){
                    if((i != 0) && (j != 0))
                        commonPartMatrix[i][j] = commonPartMatrix[i-1][j-1] + 1;
                    else
                        commonPartMatrix[i][j] = 1;

                    if(commonPartMatrix[i][j] > commonPartLength){
                        commonPartLength = commonPartMatrix[i][j];
                        commonPartPos = i;
                    }

                }
            }
        }
        commonPart = arrayOfString[0].substring(commonPartPos - commonPartLength + 1, commonPartPos + 1);

        for(int i = 0; i < arrayOfString.length; i++){
            if(!arrayOfString[i].contains(commonPart)){
                return "";
            }
        }
        return commonPart;
    }
}
