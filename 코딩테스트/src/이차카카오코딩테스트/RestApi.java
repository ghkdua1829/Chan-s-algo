package 이차카카오코딩테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RestApi {

	static Elevator elevatorChange(JSONObject json) throws JSONException {
		int id = json.getInt("id");
		int floor = json.getInt("floor");
		String status = json.getString("status");
		JSONArray passengers = json.getJSONArray("passengers");
		List<Call> callList = new ArrayList<RestApi.Call>();
		for(int i=0;i<passengers.length();i++) {
			JSONObject passenger = passengers.getJSONObject(i);
			Call cc = callChange(passenger);
			callList.add(cc);
		}
		
		Elevator e = new Elevator(id, floor, status, callList);
		return e;
	}
	
	static Call callChange(JSONObject json) throws JSONException {
		int id = json.getInt("id");
		int timestamp = json.getInt("timestamp");
		int start = json.getInt("start");
		int end = json.getInt("end");
		Call c = new Call(id, timestamp, start, end);
		return c;
	}

	public static void main(String[] args) throws JSONException {
		String startResponse = startAPI("asd", 0, 2);
		System.out.println(startResponse);

		JSONObject startResponseJson = new JSONObject(startResponse);
		JSONArray elevators = startResponseJson.getJSONArray("elevators");
		System.out.println(elevators.toString());
		for (int i = 0; i < elevators.length(); i++) {
			JSONObject e = (JSONObject) elevators.get(i);
			Elevator eee = elevatorChange(e);

//			System.out.println("asdasdasd"+e);
		}
		String token = startResponseJson.getString("token");
		while (true) {
			String callResponse = onCalls(token);
			JSONObject callResponseJson = new JSONObject(callResponse);

			boolean isEnd = callResponseJson.getBoolean("is_end");
			JSONArray calls = callResponseJson.getJSONArray("calls");
			if (calls.length() == 0 && isEnd) {
				System.out.println("Result : " + callResponseJson.getString("timestamp"));
				break;
			} else {
				System.out.println(callResponse);
			}
			JSONObject jsonObject = new JSONObject();
			org.json.simple.JSONArray commands = new org.json.simple.JSONArray();
			JSONObject command = new JSONObject();
			command.put("elevator_id", 0);
			command.put("command", "STOP");
			commands.add(command);
			JSONObject command2 = new JSONObject();
			command2.put("elevator_id", 1);
			command2.put("command", "STOP");
			commands.add(command2);
			jsonObject.put("commands", commands);

			System.out.println(jsonObject.toString());
			action(token, jsonObject.toString());
		}

	}

	static class StartApiResponse {
		String token;
		int timestamp;
		boolean is_end;
		Elevator[] elevators;
		public StartApiResponse(String token, int timestamp, boolean is_end, Elevator[] elevators) {
			super();
			this.token = token;
			this.timestamp = timestamp;
			this.is_end = is_end;
			this.elevators = elevators;
		}
		
	}

	static class Elevator {

		
		public Elevator(int id, int floor, String status, List<Call> passengers) {
			super();
			this.id = id;
			this.floor = floor;
			this.status = status;
			this.passengers = passengers;
		}

		int id, floor;
		String status;
		List<Call> passengers;
	}

	static class Call {
		
		public Call(int id, int timestamp, int start, int end) {
			super();
			this.id = id;
			this.timestamp = timestamp;
			this.start = start;
			this.end = end;
		}

		int id, timestamp, start, end;
	}

	static class Command {
		
		public Command(int elevator_id, String command, int[] call_ids) {
			super();
			this.elevator_id = elevator_id;
			this.command = command;
			this.call_ids = call_ids;
		}
		int elevator_id;
		String command;
		int[] call_ids;
	}

	static public String startAPI(String userKey, int problemId, int numberOfElevators) {
		try {
			URL url = new URL("http://localhost:8000/start/" + userKey + "/" + problemId + "/" + numberOfElevators);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000); // 서버에 연결되는 Timeout 시간 설정
			con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정

			con.setRequestMethod("POST");

			// json으로 message를 전달하고자 할 때
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoInput(true);
			con.setDoOutput(true); // POST 데이터를 OutputStream으로 넘겨 주겠다는 설정
			con.setUseCaches(false);
			con.setDefaultUseCaches(false);

			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
//			wr.write(jsonMessage); //json 형식의 message 전달 
			wr.flush();

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// Stream을 처리해줘야 하는 귀찮음이 있음.
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				return sb.toString();
			} else {
				System.out.println(con.getResponseMessage());
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return "";
	}

	static public String action(String token, String jsonMessage) {
		try {
			URL url = new URL("http://localhost:8000/action");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000); // 서버에 연결되는 Timeout 시간 설정
			con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정

			con.setRequestMethod("POST");

			// json으로 message를 전달하고자 할 때
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("X-Auth-Token", token);
			con.setDoInput(true);
			con.setDoOutput(true); // POST 데이터를 OutputStream으로 넘겨 주겠다는 설정
			con.setUseCaches(false);
			con.setDefaultUseCaches(false);

			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
			wr.write(jsonMessage); // json 형식의 message 전달
			wr.flush();

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// Stream을 처리해줘야 하는 귀찮음이 있음.
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				return sb.toString();
			} else {
				System.out.println(con.getResponseMessage());
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return "";
	}

	static public String onCalls(String token) {
		try {
			URL url = new URL("http://localhost:8000/oncalls");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000); // 서버에 연결되는 Timeout 시간 설정
			con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
//			con.addRequestProperty("x-api-key", RestTestCommon.API_KEY); // key값 설정

			con.setRequestMethod("GET");

			// json으로 message를 전달하고자 할 때
			con.setRequestProperty("X-Auth-Token", token);
			con.setDoInput(true);
			con.setDoOutput(true); // POST 데이터를 OutputStream으로 넘겨 주겠다는 설정
			con.setUseCaches(false);
			con.setDefaultUseCaches(false);

//			OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
////			wr.write(jsonMessage); // json 형식의 message 전달
//			wr.flush();

			StringBuilder sb = new StringBuilder();
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// Stream을 처리해줘야 하는 귀찮음이 있음.
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
//				System.out.println("" + sb.toString());
				return sb.toString();
			} else {
				System.out.println(con.getResponseMessage());
			}
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return "";

	}

}
