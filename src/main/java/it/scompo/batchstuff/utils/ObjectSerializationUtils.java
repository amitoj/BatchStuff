package it.scompo.batchstuff.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;

public abstract class ObjectSerializationUtils {

	public static <T extends Serializable> String convertObjectIntoString(
			T objToSerialize) {

		String res = null;

		ByteArrayOutputStream byteArrayOutputStream = null;

		ObjectOutputStream objectOutputStream = null;

		try {

			byteArrayOutputStream = new ByteArrayOutputStream();

			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

			objectOutputStream.writeObject(objToSerialize);
			objectOutputStream.flush();

			res = Base64
					.encodeBase64String(byteArrayOutputStream.toByteArray());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	public static <T extends Serializable> T deserialize(
			String serializedString, Class<T> clazz) {

		T res = null;

		ByteArrayInputStream byteArrayInputStream = null;

		ObjectInputStream objectInputStream = null;

		byte[] bytes = null;

		try {

			bytes = Base64.decodeBase64(serializedString);

			byteArrayInputStream = new ByteArrayInputStream(bytes);

			objectInputStream = new ObjectInputStream(byteArrayInputStream);

			Object readObject = objectInputStream.readObject();

			res = clazz.cast(readObject);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

}
