package qiusama.nju.edu;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] result = new int[n][n];
        for(int i = 0; i < result.length; i++ ){
            for (int j = 0; j < result[0].length; j++ ){
                result[i][j] = 0;
            }
        }
        result = cal(result, 0);
        return numToString(result);
    }
    public List<List<String>> numToString(int[][] nums){
        List<List<String>> result = new ArrayList<>();
        for(int[] num: nums){
            List<String> line = new ArrayList<>();
            for(int temp: num){
                String content = "";
                if(temp == 0){
                    content += ".";
                }else{
                    content += "Q";
                }
                line.add(content);
            }
            result.add(line);
        }
        return result;
    }
    public int[][] cal(int[][] result, int x){
//        for(int i = x; i < result.length; i++ ){
            for (int j = 0; j < result[0].length; j++ ){
                if(isValid(result, x,j)){
                    result[x][j] = 1;
                    cal(result, x+1);
                }
            }
            cal(result, x-1);
//        }
    }

    public boolean isValid(int[][] result, int x, int y){
        for(int i = 0; i < result.length; i++){
            if(i != y && result[x][i] == 1){
                return false;
            }
            if(i != x&&result[i][y] == 1){
                return false;
            }
        }
        int temp = 1;
        while(x - temp >= 0 && y - temp >= 0){
            if(result[x-temp][y-temp] == 1){
                return false;
            }
            temp++;
        }
        temp = 1;
        while(x - temp >= 0 && y + temp <= result.length - 1){
            if(result[x-temp][y + temp] == 1){
                return false;
            }
            temp++;
        }
        temp = 1;
        while(x + temp <= result.length - 1 && y + temp <= result.length - 1){
            if(result[x + temp][y + temp] == 1){
                return false;
            }
            temp++;
        }
        temp = 1;
        while(x + temp <= result.length - 1 && y - temp >= 0){
            if(result[x+temp][y-temp] == 1){
                return false;
            }
            temp++;
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println();
    }
}
