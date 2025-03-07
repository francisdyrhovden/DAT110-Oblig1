package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.util.Arrays;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data byte arrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.getBytes().length + 1];

		// TODO: marshall RPC identifier and string into byte array
		try {
			encoded[0] = rpcid;
			for (int i = 0; i < str.getBytes().length; i++) {
				encoded[i+1] = str.getBytes()[i];
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = "";

		// TODO: unmarshall String contained in data into decoded
		try {
			decoded = new String(data);
			decoded = decoded.substring(1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];

		// TODO: marshall RPC identifier in case of void type
		try {
			encoded[0] = rpcid;
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] bytes = BigInteger.valueOf(x).toByteArray();
		byte[] encoded = new byte[bytes.length + 1];

		// TODO: marshall RPC identifier and string into byte array
		encoded[0] = rpcid;
		try {
			for (int i = 0; i < bytes.length; i++) {
				encoded[i+1] = bytes[i];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		decoded = new BigInteger(Arrays.copyOfRange(data, 1, data.length)).intValue();

		return decoded;

	}
}
