package com.mohansrihari.util;

import java.io.IOException;
import java.io.StringReader;

import com.google.gson.stream.JsonReader;
import com.mohansrihari.model.FacebookError;

public class JsonUtil {

	public static FacebookError buildFacebookError(final String json){
		JsonReader reader 		= new JsonReader(new StringReader(json));
		FacebookError newObject = new FacebookError();

		try {
			reader.beginObject();
			reader.nextName();

			reader.beginObject();
			while (reader.hasNext()) {
				String name = reader.nextName();
				if (name.equals("message")) {
					newObject.setMessage( reader.nextString());
				} else if (name.equals("type")) {
					newObject.setType(reader.nextString());
				}  else if (name.equals("code")) {
					newObject.setCode(reader.nextString());
				} else {
					reader.skipValue();
				}
			}
			reader.endObject();
		} catch (IOException e) {
			return null;
		} finally {
			closeQuietly(reader);
		}
		return newObject;
	}

	private static void closeQuietly(final JsonReader reader) {
		try {
			reader.close();
		} catch (IOException e) {

		}
	}
}
