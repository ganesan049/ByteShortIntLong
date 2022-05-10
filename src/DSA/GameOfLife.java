package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {
    public static void main(String[] args) {
        List<List<Integer>> board = new ArrayList<>(new ArrayList<>());
        board.add(Arrays.asList(0,1,0));
        board.add(Arrays.asList(0,0,1));
        board.add(Arrays.asList(1,1,1));
        board.add(Arrays.asList(0,0,0));
        findGameOfLife(board);
    }

    private static void findGameOfLife(List<List<Integer>> board) {
        int row = board.size();
        int col = board.get(0).size();
        List<List<Integer>> result = new ArrayList<>(new ArrayList<>());
        for(int i=0;i<row;i++){
            List<Integer> resultRow = new ArrayList<>();
            for(int j=0;j<col;j++){
                int count = 0;
                for(int k=Math.max(0,i-1);k<Math.min(row,i+2);k++){
                    for(int l=Math.max(0,j-1);l<Math.min(col,j+2);l++){
                        if(k!=i || j!=l){
                            count+=board.get(k).get(l);
                        }
                    }
                }
                if(board.get(i).get(j) == 1 && (count == 2 || count == 3)){
                    resultRow.add(1);
                }else if(board.get(i).get(j) == 0 && (count == 3)) {
                    resultRow.add(1);
                }else{
                    resultRow.add(0);
                }
            }
            result.add(resultRow);
        }
        System.out.println(result);
    }

}
