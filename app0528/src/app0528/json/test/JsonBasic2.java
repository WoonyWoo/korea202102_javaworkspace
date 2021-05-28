package app0528.json.test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonBasic2 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"name\":\"scott\",");
		sb.append("\"age\":36,");
		sb.append("\"pet\":[");
		sb.append("{");
		sb.append("\"type\":\"dog\",");
		sb.append("\"gender\":\"girl\",");
		sb.append("\"name\":\"뽀미\"");
		sb.append("},");
		sb.append("{");
		sb.append("\"type\":\"cat\",");
		sb.append("\"gender\":\"boy\",");
		sb.append("\"name\":\"까미\"");
		sb.append("}");
		sb.append("]");
		sb.append("}");
		
		//파싱
		JSONParser jsonParser = new JSONParser();
		try {
			JSONObject obj =  (JSONObject)jsonParser.parse(sb.toString()); //파싱시작!!
			String name = (String)obj.get("name");
			long age = (Long)obj.get("age"); //unboxing
			JSONArray petArray =  (JSONArray)obj.get("pet");
			
			for (int i = 0; i < petArray.size(); i++) {
				JSONObject pet = (JSONObject)petArray.get(i);
				
				String type = (String)pet.get("type");
				String gender = (String)pet.get("gender");
				String n = (String)pet.get("name");
				
				System.out.println(type+","+gender+","+n);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
