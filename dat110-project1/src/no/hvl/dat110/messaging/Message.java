package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		// TODO: check for length within boundary
		if (payload.length <= MessageConfig.SEGMENTSIZE) {
			this.payload = payload;	
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = null;
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		int length = payload.length;
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte)length;
		for (int i = 0; i < length; i++) {
			encoded[i+1] = payload[i];
		}
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		payload = new byte[received[0]];
		for (int i = 0; i < payload.length; i++) {
			payload[i] = received[i+1];
		}
		
		
		
		
	}
}
