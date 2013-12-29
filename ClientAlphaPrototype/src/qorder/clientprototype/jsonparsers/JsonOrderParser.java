package qorder.clientprototype.jsonparsers;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import qorder.clientprototype.model.BasketProduct;
import qorder.clientprototype.model.OrderHolder;

public class JsonOrderParser {

	public JSONObject parse(List<BasketProduct> orders) throws JSONException {
		
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();

		json.put("tableNumber", OrderHolder.getTableNumber());

		for (BasketProduct order : orders) {
			
			JSONObject orderItem = new JSONObject();
			orderItem.put("productId", order.getId());
			orderItem.put("notes", order.getNotes());
			arr.put(orderItem);
		}

		json.put("orders", arr);

		return json;
	}
}
