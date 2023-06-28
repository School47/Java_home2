// 1) Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
public class Home2_1 {
 public static void main(String[] args) {  
        String data = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"}";
        data = data.replaceAll("[{}\"]", ""); // удаляем мусор
        String[] keyValuePairs = data.split(",");

        StringBuilder strResult = new StringBuilder("SELECT * FROM students");

        for(String pair : keyValuePairs){
            String[] entry = pair.split(":");
            String key = entry[0].trim();
            String value = entry[1].trim();

            if(!"null".equals(value)){
                if(strResult.toString().contains("WHERE")) {
                    strResult.append(" AND ");
                } else {
                    strResult.append(" WHERE ");
                }
                strResult.append(key).append("='").append(value).append("'");
            }
        }

        System.out.println(strResult);
    }
}
