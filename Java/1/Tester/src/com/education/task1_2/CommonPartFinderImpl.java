package com.education.task1_2;


public class CommonPartFinderImpl implements CommonPartFinder {
    public String getMaxLengthCommonPrefix(String[] arrayOfString){
        Boolean flag = true;

        for(int i = 0; i < arrayOfString[0].length(); i++){
            for(int j = 0; j < arrayOfString.length - 1; j++){
                if((arrayOfString[j].length() <= i) || (arrayOfString[j+1].length() <= i)) {
                    flag = false;
                    i = (i <= 1) ? i : i-1;
                }
                if(arrayOfString[j].charAt(i) != arrayOfString[j+1].charAt(i)) {
                    flag = false;
                }
            }

            if(!flag)
                return (i == 0) ? "" : arrayOfString[0].substring(0,i);
        }
        return arrayOfString[0];
    }

    public String getMaxLengthCommonPart(String[] arrayOfString) {
        if(arrayOfString.length < 2)
            return arrayOfString[0];

        int[][] commonPartMatrix = new int[arrayOfString[0].length()][arrayOfString[1].length()];
        int commonPartLength = 0;
        int commonPartPos = 0;
        //String commonPart;

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

        return arrayOfString[0].substring(commonPartPos - commonPartLength + 1, commonPartPos + 1);
    }
}
