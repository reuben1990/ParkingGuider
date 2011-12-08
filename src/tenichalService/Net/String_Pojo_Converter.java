package tenichalService.Net;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tenichalService.Pojo.Park;

public class String_Pojo_Converter {
	
	public Park convertToPark(String s) throws JSONException {
		JSONObject jsonObject = new JSONObject(s);
		return jsonObjToPark(jsonObject);
	}

	public List<Park> convertToParks(String s) throws JSONException {
		List<Park> parks = new ArrayList<Park>();
		JSONArray jsonArray = new JSONArray(s);
		int length = jsonArray.length();
		for(int i = 0; i < length; ++ i) {
			parks.add(jsonObjToPark(jsonArray.getJSONObject(i)));
		}
		return parks;
	}
	
	private Park jsonObjToPark(JSONObject jsonObject) throws JSONException {
		Park park = new Park();
		park.set_id(jsonObject.getString("_id"));
		park.setAddress(jsonObject.getString("address"));
		park.setCreate_at(jsonObject.getString("created_at"));
		park.setDistrict(jsonObject.getString("district"));
		park.setEnd_working_time(jsonObject.getString("end_working_time"));
		park.setFirst_hour_rent(jsonObject.getInt("first_hour_rent"));
		park.setImage_url(jsonObject.getString("image_url"));
		park.setIsfree(jsonObject.getBoolean("isfree"));
		if(jsonObject.has("location")) {
			JSONObject locationJsonObject = jsonObject.getJSONObject("location");
			park.setLat(locationJsonObject.getDouble("lat"));
			park.setLng(locationJsonObject.getDouble("lng"));
		}
		park.setNext_hour_rent(jsonObject.getInt("next_hour_rent"));
		park.setParkname(jsonObject.getString("parkname"));
		park.setPreferential_conditions(jsonObject.getString("preferential_conditions"));
		park.setPublished(jsonObject.getBoolean("published"));
		park.setStart_working_time(jsonObject.getString("start_working_time"));
		park.setTips(jsonObject.getString("tips"));
		park.setUpdated_at(jsonObject.getString("updated_at"));
		return park;
	}
}
