package tk.mylibraries.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionMD5 {

	private static final EncryptionMD5 INSTANCE = new EncryptionMD5();
	
	private EncryptionMD5() {
	}

	public static EncryptionMD5 getInstance() {
		return INSTANCE;
	}
	
	public String getPasswordEncryptionMD5(String password) {

		String passwordEncryptionMD5 = null;
		MessageDigest messageDigest = null;
		
		try {
			// CRIA UM OBJETO messageDigest COM O ALGORITIMO MD5
			messageDigest = MessageDigest.getInstance("MD5");
			
			// ADICIONA OS BYTES DA SENHA INFORMADA A MENSAGEM QUE SER� CRIPTOGRAFADA
			messageDigest.update(password.getBytes());			
			
			// CONVERTE OS BYTES DO OBJETO messageDigest PARA UM OBJETO DO TIPO BigInteger
			BigInteger bigInteger = new BigInteger(1, messageDigest.digest());
			
			// CONVERTE PARA UMA STRING O OBJETO bigInteger.
			// O toString(16) RETORNA A REPRESENTA��O DE UMA STRING DO OBJETO bigInteger REFERENTE AO RADIX (RAIZ) 16
			// ESSE RETORNO J� � O C�DIGO MD5.
			passwordEncryptionMD5 = bigInteger.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return passwordEncryptionMD5;
	}
}
