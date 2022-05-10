package Abstract;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List resultList = new ArrayList();
        Map<String,String> data1 = new HashMap<String,String>();
        Map<String,String> data2 = new HashMap<String,String>();
        data1.put("TABLE_NAME","CLAIM");
        data1.put("COLUMN_NAME","ID");
        data1.put("HIDDEN_COLUMN","NO");

        data2.put("TABLE_NAME","CLAIM");
        data2.put("COLUMN_NAME","LASTDML");
        data2.put("HIDDEN_COLUMN","YES");
        resultList.add(data1);
        resultList.add(data2);
        Map<String,Map<String,List<String>>> hiddenData = new HashMap<>();
        for (int i = 0; i < resultList.size(); i++) {
            Map<String,String> mapList = (Map<String,String>) resultList.get(i);
            String tableName = mapList.get("TABLE_NAME");
            String columnName = mapList.get("COLUMN_NAME");
            String hiddenColumn = mapList.get("HIDDEN_COLUMN");
            if(hiddenData.containsKey(tableName)){
                System.out.println(hiddenData.get(tableName));
                hiddenData.get(tableName).get("COLUMNS").add(columnName);
                if(hiddenColumn.equals("YES")){
                    hiddenData.get(tableName).get("HIDDEN_COLUMNS").add(hiddenColumn);
                }
            }else {
                List<String> hiddenList = new ArrayList<String>();
                Map<String, List<String>> columnMap = new HashMap<String, List<String>>();
                columnMap.put("COLUMNS", new ArrayList<>(Arrays.asList(columnName)));
                if(hiddenColumn.equals("YES")){
                    hiddenList.add(columnName);
                }
                columnMap.put("HIDDEN_COLUMNS",hiddenList);
                hiddenData.put(tableName,columnMap);
            }
        }
        System.out.println(hiddenData);
    }
}
